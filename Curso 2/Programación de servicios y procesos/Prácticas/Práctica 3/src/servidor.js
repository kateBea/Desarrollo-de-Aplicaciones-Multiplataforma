/**
 * Controlador del servidor. 
 * Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */


"use strict"

/** Imports */

const Fs = require("fs");
const Dgram = require('dgram');
const Utils = require("./utils.js");


/** Constantes */

const BIND_PORT = 8000;
const PASSWORD_LENGTH = [8, 9, 10, 11, 12];
const PASSWORD_LETTERS = Array.from("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

const COMMAND_LINE_ARGS = process.argv;

/** Tipos */

class ChatClient {
    constructor(name, password, address, port, color) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.port = port;
        this.color = color;
    }

    displayClientInfo() {
        console.log(`Nombre: ${this.name}`);
        console.log(`Password: ${this.password}`);
        console.log(`Address: ${this.address}`);
        console.log(`Port: ${this.port}`);
        console.log(`Color: ${this.color}`);
    }
}


/** Globales */

let server;
let clients = []

let serverPublicKey;
let serverPrivateKey;

// pasado este tiempo el servidor se cierra
// representa tiempo en milisegundos (10 segundos por defecto)
let timeOut = 60000;
let timeOutObj = undefined;


/**
 * Verifica si ya hay un cliente conectado con el nombre proporcionado.
 *
 * @param {string} clientName - El nombre del cliente que se está buscando.
 * @returns {number} - Si se encuentra un cliente con el nombre dado, devuelve el índice del cliente. Si no se encuentra, devuelve -1.
 * */
function IsAlreadyConnected(clientName) {
    for (let clientIndex in clients) {
        if (clients[clientIndex].name == clientName) {
            return clientIndex;
        }
    }

    return -1;
}


/**
 * Muestra los comandos de este programa.
 * */
function Help() {
    console.log(
        "Usage: node servidor.js [OPTIONS]\n\n" +
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
        "Usa 'node servidor.js --help' para desplegar la ayuda\n" +
        "Usage: node servidor [OPTIONS]"
    );
}


/**
 * Valida los argumentos de la línea de comandos.
 * @returns {boolean} - Cierto si el listado de argumentos es válido y no se solicita la ayuda, falso en cualquier otro caso.
 * */
function ParseComdLineArguments() {
    if (COMMAND_LINE_ARGS.length < 2) {
        // no alcanzado mínimo requerido de argumentos
        Usage();
        return;
    }

    // El usuario quiere mostrar la ayuda
    if (COMMAND_LINE_ARGS[2] == Utils.HELP_COMMAND) {
        Help();
        return false;
    }

    if (process.argv[2] === "--debug-enable") {
        Utils.SetDebug(true);
    }
    else if (process.argv[2] === "--debug-disabled") {
        Utils.SetDebug(false);
    }

    return true;
}


/**
 * Genera una contraseña aleatoria utilizando letras de 
 * un conjunto predefinido y con una longitud aleatoria.
 *
 * @returns {string} - La contraseña generada.
 * */
function GeneratePassword() {
    const passLenght = Utils.GetRandomInt(8, PASSWORD_LENGTH.length);

    let result = "";

    for (let count = 0; count < passLenght; ++count) {
        result += PASSWORD_LETTERS[Utils.GetRandomInt(0, PASSWORD_LETTERS.length)];
    }

    return result;
}


/**
 * Muestra el cliente por la consola.
 * @param {Object} client - cliente a ser mostrado.
 * */
function PrintClient(client) {
    Utils.TextoColoreado(`Nombre: ${client.name}\nPass: ${client.password}\nAddress: ${client.address}\nPuerto: ${client.port}\nColor: ${client.color}\n`,
        Utils.COLOR_AMARILLO
    );
}


/**
 * Elimina un cliente de la lista en la posición especificada por el índice.
 * Verifica si el índice es válido
 *
 * @param {number} clientIndex - Índice del cliente que se va a eliminar en la lista.
 * @returns {boolean} - Devuelve true si la eliminación es exitosa, false si el índice está fuera de los límites.
 * */
function DeleteClient(clientIndex) {
    if (clientIndex >= 0 && clientIndex < clients.length) {
        clients.splice(clientIndex, 1);
        return true;
    } else {
        // El índice está fuera de los límites de la lista
        return false; // No se puede eliminar
    }
}


/**
 * Carga las claves del servidor desde archivos en el sistema de archivos.
 * La clave pública del servidor no se utiliza en esta implementación específica.
 * La función carga la clave pública y privada del servidor desde archivos y muestra un mensaje si la carga es exitosa.
 *
 * @returns {Boolean} - cierto si se han cargado correctamente las claves, falso en caso contrario.
 * */
function LoadKeys() {
    try {
        // por petición de la práctica se carga pero no se llega a usar esta clave en el lado del servidor.
        serverPublicKey = Fs.readFileSync("server-public.cert", { encoding: "utf8" });

        serverPrivateKey = Fs.readFileSync("server-private.key", { encoding: "utf8" });

        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado("Claves cargadas", Utils.COLOR_MAGENTA);
        });

        return true;
    } catch (err) {
        Utils.TextoColoreado(`Excepción. Mensaje [ ${err.message} ]`);
        return false;
    }
}


/**
 * Entrada principal a nuestro servidor, lo inicializa y pone 
 * a escuhar por el puerto establecido.
 * */
function Run() {
    if (!ParseComdLineArguments()) {
        return;
    }

    Utils.RUN_ON_DEBUG(() => {
        Utils.TextoColoreado("Iniciando servidor", Utils.COLOR_VERDE);
    });

    if (!LoadKeys()) {
        return;
    }

    server = Dgram.createSocket("udp4");

    server.on("error", (err) => {
        Utils.TextoColoreado(`Error en el servidor: ${err.message}, stack: ${err.stack}`);
        server.close();
    });

    server.on("message", (msg, rinfo) => {
        // reseteamos time out, hay actividad
        clearTimeout(timeOutObj);

        timeOutObj = setTimeout(() => {
            server.close();
        }, timeOut);

        Utils.RUN_ON_DEBUG(() => { Utils.TextoColoreado(`Server received:\n${msg}`, Utils.COLOR_AMARILLO); });

        const parsedData = Utils.ParseJSON(msg);

        if (parsedData == null || parsedData["name"] == undefined) {
            // no es la primera conexión

            for (let clientIndex in clients) {
                Utils.RUN_ON_DEBUG(() => { Utils.TextoColoreado(`client: ${clients[clientIndex].name}, pass: ${clients[clientIndex].password}`) });

                // el cliente envia la información como string utf8
                const message = new Buffer.from(msg).toString("utf8");

                Utils.DecryptSimetric(message, clients[clientIndex].password, (error, decriptedMsg) => {
                    if (error) {
                        Utils.TextoColoreado(`Error al desencriptar datos recibidos del cliente o contraseña incorrecta`);
                        return;
                    }

                    const parsedDecriptedData = Utils.ParseJSON(decriptedMsg);
                    const clientMsg = parsedDecriptedData["message"];

                    // el cliente se ha desconectado
                    if (clientMsg == Utils.CLIENT_DISCONNECT) {
                        Utils.TextoColoreado(`Cliente ${clients[clientIndex].name} se ha desconectado`);

                        // temporal para debug, se habrá perdido el nombre cuando se borre el cliente
                        const nombreCliente = new Buffer.from(clients[clientIndex].name).toString("utf8");
                        
                        // eliminar el cliente
                        if (DeleteClient(clientIndex)) {
                            Utils.RUN_ON_DEBUG(() => {
                                Utils.TextoColoreado(`Cliente ${nombreCliente} borrado con éxito`);
                            });
                        } else {
                            Utils.TextoColoreado(`Error al borrar el cliente ${clients[clientIndex].name}`);
                        }
                        
                        return;
                    }

                    for (let clientIndexReceiver in clients) {
                        // no reenviar mensaje al emisor
                        if (clients[clientIndexReceiver].name != clients[clientIndex].name) {
                            Utils.TextoColoreado(`Cliente receptor: ${clients[clientIndexReceiver].name}`);
                            const message = JSON.stringify({ "clientName": clients[clientIndex].name, "clientColor": clients[clientIndex].color, "message": clientMsg });

                            Utils.EncryptSimetric(message, clients[clientIndexReceiver].password, (error, encryptedData) => {
                                Utils.RUN_ON_DEBUG(() => { Utils.TextoColoreado(`Mensaje cifrado: ${encryptedData}`) });
                                server.send(encryptedData, 0, encryptedData.length, clients[clientIndexReceiver].port, clients[clientIndexReceiver].address, (err, bytes) => {
                                    if (err) {
                                        Utils.TextoColoreado(`Error al enviar mensaje desde cliente`, Utils.COLOR_ROJO);
                                        return;
                                    }

                                    Utils.TextoColoreado(`UDP mensaje enviado a la dirección -> ${clients[clientIndexReceiver].address}:${clients[clientIndexReceiver].port}`, Utils.COLOR_VERDE);
                                });
                            });
                        }
                    }
                });
            }

            return;
        }

        const clientMsg = parsedData["message"];
        const clientName = parsedData["name"];
        const clientPort = rinfo.port;
        const clientAddress = rinfo.address;

        // buscamos el cliente en la lista de clientes
        const result = IsAlreadyConnected(clientName);

        if (result == -1) {
            const simetricPassStr = new Buffer.from(parsedData["pass"]["data"]);
            Utils.TextoColoreado(`Password encrypted: ${simetricPassStr}`, Utils.COLOR_MAGENTA);

            const clientSimetricPassDecrypted = Utils.DecryptAsimetric(simetricPassStr, serverPrivateKey);

            Utils.RUN_ON_DEBUG(() => {
                Utils.TextoColoreado(`Contraseña simétrica descifrada: ${clientSimetricPassDecrypted.toString("base64")}`, Utils.COLOR_AZUL);
            });

            // contraseña del servidor para este nuevo usuario
            // este es el mensaje que le vamos a devolver al cliente
            const generatedPassword = GeneratePassword();
            const signature = Utils.Sign(generatedPassword, serverPrivateKey);

            Utils.DecryptSimetric(clientMsg, clientSimetricPassDecrypted, (error, decryptedClientPublicKey) => {
                if (error) {
                    Utils.TextoColoreado(`Erroe al desencriptar la clave pública del cliente. ${error.message}`);
                    return;
                }

                Utils.RUN_ON_DEBUG(() => {
                    Utils.TextoColoreado(`Clave pública de cliente:\n${decryptedClientPublicKey}`);
                });

                // encriptamos asimétricamente la clave generada para el cliente.
                const encriptedGeneratedKey = Utils.EncryptAsimetric(generatedPassword, decryptedClientPublicKey);

                Utils.RUN_ON_DEBUG(() => {
                    Utils.TextoColoreado(`Contraseña generada encriptada (base64): ${encriptedGeneratedKey.toString("base64")}`)
                });

                const message = new Buffer.from(JSON.stringify({ "clientKey": encriptedGeneratedKey, "signature": signature })).toString("utf8");

                server.send(message, 0, message.length, clientPort, clientAddress, (err, bytes) => {
                    if (err) {
                        Utils.TextoColoreado(`Error al enviar mensaje desde cliente`, Utils.COLOR_ROJO);
                        return;
                    }

                    Utils.RUN_ON_DEBUG(() => {
                        Utils.TextoColoreado(`UDP mensaje enviado a la dirección -> ${clientAddress}:${clientPort}`, Utils.COLOR_VERDE);
                    });

                    clients.push(new ChatClient(clientName, generatedPassword, clientAddress, clientPort, Utils.Colores[Utils.GetRandomInt(0, Utils.Colores.length)]));

                    Utils.RUN_ON_DEBUG(() => {
                        PrintClient(clients[clients.length - 1]);
                    });

                    Utils.TextoColoreado(Utils.NEW_CONNECTION.replace("__ADDRESS__", `${clientAddress}:${clientPort}`), Utils.COLOR_VERDE);
                });
            });
        }

        Utils.RUN_ON_DEBUG(() => {
            Utils.TextoColoreado(`Mensaje: '${clientMsg}'  recibido de ${clientAddress}:${clientPort}`, Utils.COLOR_AMARILLO);
        });
    });

    server.on("listening", () => {
        const address = server.address();
        Utils.TextoColoreado(`Servidor escuchando en ${address.address}:${address.port}`);
    });

    timeOutObj = setTimeout(() => {
        server.close();
    }, timeOut);

    server.bind(BIND_PORT);
}

Run();