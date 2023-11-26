/**
 * Controlador del cliente. 
 * Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

/** Imports */

const Fs = require("fs");
const Dgram = require('dgram');
const Crypto = require("crypto");
const Utils = require("./utils.js");
const Readline = require("readline");


/** Constantes */

const PORT = 8000;
const LOCALHOST = '127.0.0.1';
const ADDRESS = LOCALHOST;
const SOCKET_TYPE = "udp4";

const COMMAND_LINE_ARGS = process.argv;

/** Globales */
let client;
let readliner;

let clientPublicKey;
let clientPrivateKey;
let serverPublicKey;

let serverClinetCommunicationPass = undefined;

/**
 * Muestra los comandos de este programa.
 * */
function Help() {
    console.log(
        "Usage: node cliente.js client_name [OPTIONS]\n\n" +
        "OPTIONS:\n\n" +
        "  --debug-enable   ->  Habilitar los mensajes de depuración por consola\n" +
        "  --debug-disabled ->  Deshabilitar los mensajes de depuración por consola\n"
    );
}


/**
 * Muestra el uso correcto del programa.
 * */
function Usage() {
    console.log(
        "Número incorrecto de argumentos\n" +
        "Usa 'node cliente.js --help' para desplegar la ayuda\n" +
        "Usage: node cliente.js client_name [OPTIONS]"
    );
}


/**
 * Valida los argumentos de la línea de comandos.
 * @returns {boolean} - Cierto si el listado de argumentos es válido y no se solicita la ayuda, falso en cualquier otro caso.
 * */
function ParseComdLineArguments() {
    if (COMMAND_LINE_ARGS.length < 3) {
        // no alcanzado mínimo requerido de argumentos
        Usage();
        return;
    }

    // El usuario quiere mostrar la ayuda
    if (COMMAND_LINE_ARGS[2] == Utils.HELP_COMMAND) {
        Help();
        return false;
    }

    if (process.argv[3] === "--debug-enable") {
        Utils.SetDebug(true);
    }
    else if (process.argv[3] === "--debug-disabled") {
        Utils.SetDebug(false);
    }

    return true;
}


/**
 * Maneja la conexión inicial del cliente con el servidor. Verifica la firma del servidor,
 * desencripta la contraseña generada asimétricamente y la almacena para comunicaciones futuras.
 *
 * @param {Object} parsedData - Datos recibidos del servidor en formato JSON.
 * */
function HandleFirstConnection(parsedData) {
    try {
        const generatedPass = parsedData["clientKey"];

        const signature = new Buffer.from(parsedData["signature"]["data"]);
        const password = Utils.DecryptAsimetric(generatedPass, clientPrivateKey).toString("utf8");
        
        const result = Utils.Verify(signature, password, serverPublicKey);
        
        if (result) {
            serverClinetCommunicationPass = password;
            Utils.RUN_ON_DEBUG(() => {
                Utils.TextoColoreado(`Verificación de firma correcta`);
            });
        } else {
            Utils.TextoColoreado(`Erro en verificación de firma. Contraseña compormetida`);
        }

        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado(`Contraseña para este cliente: ${serverClinetCommunicationPass}`);
        });
    } catch (error) {
        Utils.TextoColoreado(`Error al parsear datos del servidor. ${error.message}`);
    }
}


/**
 * Inicializa el cliente UDP y el lector de línea para la entrada del usuario.
 * Maneja mensajes recibidos del servidor, incluyendo la conexión inicial.
 * Cierra la conexión cuando se detecta el comando de desconexión.
 * */
function Init() {
    // client
    client = Dgram.createSocket(SOCKET_TYPE);

    client.on("message", (msg, rinfo) => {
        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado(`Mensaje recibido de: ${rinfo.address}:${rinfo.port}`, Utils.COLOR_AMARILLO);
            Utils.TextoColoreado(msg, Utils.COLOR_MAGENTA);
        });
        
        if (serverClinetCommunicationPass == undefined) {
            // tratamos la conexión por primera vez
            const parsedData = Utils.ParseJSON(msg);
            HandleFirstConnection(parsedData);
        } else {
            Utils.RUN_ON_DEBUG(() => {
                Utils.TextoColoreado(`¿Cliente ya tiene contraseña?: ${serverClinetCommunicationPass}`);
            });

            Utils.DecryptSimetric(Buffer.from(msg).toString("utf8"), serverClinetCommunicationPass, (error, decryptedData) => {
                if (error) {
                    Utils.TextoColoreado(`Error al desencriptar simétricamente mensaje de servidor. ${error.message}`);
                    return;
                }

                Utils.RUN_ON_DEBUG(() => {
                    Utils.TextoColoreado(`datos del servidor: ${decryptedData}`);
                });

                const parsedData = Utils.ParseJSON(decryptedData);

                if (parsedData == null) {
                    Utils.TextoColoreado(`Datos JSON no existentes`);
                } else {
                    const clientName = parsedData["clientName"];
                    const clientColor = parsedData["clientColor"];

                    // mostramos el mensaje de otro cliente por el chat 
                    Utils.TextoColoreado(`${Utils.TextoColoreadoStr(`${clientName}`, clientColor)}: ${Utils.TextoColoreadoStr(`${parsedData["message"]}`, Utils.COLOR_MAGENTA)}\n${`[Client: ${COMMAND_LINE_ARGS[2]}] (escribe '${Utils.CLIENT_DISCONNECT}' para desconetar): `}`); 
                }

            })
        }
    });

    // readline
    readliner = Readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    readliner.on("close", () => {
        client.close();
        Utils.TextoColoreado("Desconectado.", Utils.COLOR_VERDE);
    });
}


/**
 * Maneja las entradas del usuario. Envía mensajes al servidor mientras la conexión esté activa.
 *
 * @param {string} targetString - Centinela que indica el fin de lectura por consola.
 * */
function HandleUserInputs(targetString) {
    readliner.question(
        `[Client: ${COMMAND_LINE_ARGS[2]}] (escribe '${targetString}' para desconetar): `, 
        function(userInput) {
            // Asegurarse de que cliente i servidor usan el mismo formato de strings para mejor compatibilidad.
            // El formato de JSON.stringify es dependiente de la implementación de la librería de JS que usemos.
            const clientMsg = Buffer.from(JSON.stringify({ "name": COMMAND_LINE_ARGS[2], "message": userInput })).toString("utf8");

            Utils.EncryptSimetric(clientMsg, serverClinetCommunicationPass, (error, encryptedMessage) => {
                if (error) {
                    Utils.TextoColoreado(`Error al encriptar mensaje: ${error.message}`);
                    return;
                }

                client.send(encryptedMessage, 0, encryptedMessage.length, PORT, ADDRESS, (err, bytes) => {
                    if (err) {
                        Utils.TextoColoreado(`Error al enviar mensaje a servidor. ${error.message}`, Utils.COLOR_ROJO);
                        return;
                    }

                    Utils.RUN_ON_DEBUG(() => {
                        Utils.TextoColoreado(`Mensaje UDP enviado a ${ADDRESS}:${PORT}`, Utils.COLOR_VERDE);
                    });

                    if (userInput === targetString) {
                        readliner.close();
                    } else {
                        HandleUserInputs(targetString);
                    }
                });
            });
        });
}


/**
 * Conecta al cliente con el servidor y se encarga de cargar las claves
 * pública y privada del cliente junto con la pública del servidor.
 * */
function ConnectToServer() {
    // cargar claves
    try {
        clientPublicKey = Fs.readFileSync("client-public.cert", { encoding: "utf8" }); 
        clientPrivateKey = Fs.readFileSync("client-private.key", { encoding: "utf8" });
    
        serverPublicKey = Fs.readFileSync("server-public.cert", { encoding: "utf8" });
        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado("Claves de cliente y pública de servidor cargadas", Utils.COLOR_MAGENTA);
        });
    } catch(err) {
        Utils.TextoColoreado(`Excepción. Mensaje [ ${err.message} ]`, Utils.COLOR_ROJO);
    }

    // Vamos a enviar la clave pública del cliente cifrada
    const simetricPassFormat = "base64";
    const simetricPass = Crypto.randomBytes(5);

    Utils.RUN_ON_DEBUG(() => {
        Utils.TextoColoreado(`Contraseña generada (${simetricPassFormat}): ${simetricPass.toString(simetricPassFormat)}`, Utils.COLOR_MAGENTA);
    });

    // ciframos la contraseña de forma asimétrica con la clave pública del server
    const simetricPassEncripted = Utils.EncryptAsimetric(simetricPass, serverPublicKey);

    // Ciframos el mensaje (clave pública del cliente) con la contraseña.
    // La contraseña no se usa cifrada aquí porque se va a decifrar en el servidor, es decir,
    // no nos sirviría decifrar una contraseña que no está cifrada.
    Utils.EncryptSimetric(clientPublicKey, simetricPass, (error, encryptedMessage) => {
        if(error) {
            Utils.TextoColoreado(`Error al encriptar simétricamente la clave pública del cliente. ${error.message}`);
            return;
        }

        const message = new Buffer.from(JSON.stringify({ "name": COMMAND_LINE_ARGS[2], "message": encryptedMessage, "pass": simetricPassEncripted })).toString("utf8");

        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado(`Datos a enviar:\n${message}`);
        });

        client.send(message, 0, message.length, PORT, ADDRESS, (err, bytes) => {
            if (err) {
                Utils.TextoColoreado("Error al enviar mensaje desde cliente", Utils.COLOR_ROJO);
                return;
            }

            Utils.RUN_ON_DEBUG(() => {
                Utils.TextoColoreado(`Mensaje UDP enviado a ${ADDRESS}:${PORT}`, Utils.COLOR_VERDE);
            });
        });
    });
}


/**
 * Bucle principal del cliente, lee datos de la línea de comandos,
 * encripta el mensaje leído y lo manda al servidor.
 * */
function RunMainLoop() {
    HandleUserInputs(Utils.CLIENT_DISCONNECT);
}


/**
 * Entrada principal del cliente. Lo inicializa y, si la conexión con el servidor se
 * ha completad correctamente, permite acceso al chat interactivo.
 * */
function Run() {
    if (!ParseComdLineArguments()) {
        return;
    }

    Init();

    ConnectToServer();

    RunMainLoop();
    Utils.TextoColoreado(Utils.BIENVENIDA_CHAT.replace("__NAME__", COMMAND_LINE_ARGS[2]));

}

Run();