/**
 * Controlador del sistema del servidor. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

/* Imports */

const Fs = require("fs");
const Net = require("net");
const Logger = require("../common/logger.js");
const Utils = require("../common/utilities.js");


/* Constantes */

const LISTEN_PORT           = 5000;
const LOCALHOST             = "127.0.0.1";
const ADDRESS               = LOCALHOST;
const DATABASE_FILE_PATH    = "./src/server-storage.json";

const USER_ADMIN        = "administrador";
const USER_ADMIN_PASS   = "YGWpDasGa123+";


/**
 * Verifica si algún elemento de la lista cumple con la condición proporcionada por el predicado, en dicho caso retorna el primero.
 * @param {Array} list - Lista en la que se buscará el elemento.
 * @param {Function} predicate - Función que representa la condición que debe cumplir el elemento.
 * @returns {number} - El índice del primer elemento que cumple con la condición del predicado o -1 si no se encuentra ningún elemento.
 * */
function Contains(list, predicate) {
    let result = -1;
    for (let index in list) {
        if (predicate(list[index])) {
            result = index;
            break;
        }
    }

    return result;
}


/**
 * Valida la existencia y la autenticidad de un cliente en la base de datos gestionada por este servidor.
 * @param {string} clientName - Nombre del cliente a validar.
 * @param {string} clientPass - Contraseña del cliente a verificar.
 * @returns {object} - Un objeto que indica si el cliente es válido, si existe y su índice en la base de datos.
 * */
function ValidateClient(clientName, clientPass) {
    const result = { "isValid": false, "exists": false, "userIndex": -1 };
    const serverDBContentsStr = Fs.readFileSync(DATABASE_FILE_PATH, "utf8");
    const serverDBContents = Utils.ParseJSON(serverDBContentsStr);

    if (serverDBContents == null) {
        Logger.Error("Server contenst are null");
        return result;
    }

    Logger.Debug(serverDBContentsStr);

    let index = 0;
    while (index < serverDBContents.length && !result["exists"]) {
        result["userIndex"] = index;
        result["exists"] = serverDBContents[index]["usuario"] == clientName;

        if (!result["exists"]) {
            ++index;
        }
    }

    // El usuario existe y la contraseña es válida
    result["isValid"] = result["exists"] && serverDBContents[index]["password"] == clientPass;

    return result;
}


/**
 * Valida un usuario. Si el usuario es válido procesa peticiones de el cliente identificado
 * por sus credenciales. Devuelve al cliente un objeto con tres campos ({"respuesta", "comando", "message"}),
 * donde "respuesta" un string JSON conteniendo la respuesta del servidor, "comando" indica 
 * el comando para el cual se retorna la respuesta y "message" es el mensaje indicando informativo
 * sobre la ejecuación de la petición. Retorna una promesa con tres campos
 * @param {string} socket - Socket por el cual sel servidor se comunica con el cliente.
 * @param {string} data - String JSON con los datos enviados por el cliente
 * @returns {Promise<Object>} - Objeto con los datos procesados.
 * */
async function HandleRequest(socket, data) {
    const jsonContents = Utils.ParseJSON(data);

    // cargar datos de la base de datos del servidor
    const dbFileContentsStr = Fs.readFileSync(DATABASE_FILE_PATH, "utf8");
    const databaseContents = Utils.ParseJSON(dbFileContentsStr);

    // [Depuración]
    Logger.Debug(`Server received: ${data.toString()}`);
    Logger.Debug(`JSON data:\n${JSON.stringify(jsonContents, null, 4)}`);

    if (jsonContents == null) {
        Logger.Error("Error al recoger los datos del cliente.");
        return false;
    }

    
    let wantWriteChanges = false;
    let execResult = { result: true, serialize: wantWriteChanges, serializeContents: null, wantCloseServer: false };
    const respuesta = { "respuesta": null, "comando": jsonContents["accion"], "message": "El usuario no existe, use comando 'subir' para dar de alta" };


    // [procesamos petición de cierre si es el caso]
    if (jsonContents["usuario"] == USER_ADMIN && jsonContents["password"] == USER_ADMIN_PASS && jsonContents["accion"] == Utils.CASE_CERRAR) {
        respuesta["message"] = "Cerrando servidor";
        execResult.wantCloseServer = true;

        // respondemos al cliente para no dejarlo a la espera
        socket.write(JSON.stringify(respuesta));

        // no procesamos ninguna
        return execResult;
    }
    else if (jsonContents["accion"] == Utils.CASE_CERRAR && !(jsonContents["usuario"] == USER_ADMIN && jsonContents["password"] == USER_ADMIN_PASS)) {
        respuesta["message"] = "Comando no autorizado";

        // respondemos al cliente para no dejarlo a la espera
        socket.write(JSON.stringify(respuesta));

        return execResult;
    }
    

    // [procesar petición de cliente no administrador si existe]

    // validamos primero el acceso
    const resultValidation = ValidateClient(jsonContents["usuario"], jsonContents["password"]);
    Logger.Debug(`Validation results: ${JSON.stringify(resultValidation)}`);

    if (!resultValidation["exists"]) {
        // usuario no existe, hay que darle de alta.
        const nuevaCuota = Utils.GenRandomInt(5221, 15239);
        const nuevoUsuario = { "usuario": jsonContents["usuario"], "password": jsonContents["password"],"cuota": nuevaCuota, "archivos": [] };
        respuesta["message"] = `Sin coincidencias. Entrada recién creada para usuario ${jsonContents["usuario"]} con contraseña ${jsonContents["password"]} y cuota ${nuevaCuota}`;
        databaseContents.push(nuevoUsuario);
        wantWriteChanges = true;
    }
    else if(!resultValidation["isValid"] && resultValidation["exists"]) {
        // usuario existe pero los credenciales son incorrectos
        respuesta["message"] = "Credenciales incorrectos";
    }
    else if (resultValidation["exists"] && resultValidation["isValid"]) {
        // El usuario existe y los credenciales son correctos. Procesar comando.

        // índice a un fichero válido en la lista de ficheros
        // de un usuario en la base datos o -1
        let userFileIndex = -1;

        switch (jsonContents["accion"]) {
            case Utils.CASE_SUBIR:
                Logger.Debug(`Servidor: Ejecutando comando ${Utils.CASE_SUBIR} para ${jsonContents["usuario"]}`);
                userFileIndex = Contains(databaseContents[resultValidation["userIndex"]]["archivos"], (elemento) => { 
                    return elemento["nombre"] == jsonContents["archivo"];
                });

                if (userFileIndex == -1) {
                    Logger.Debug(`Cuota: ${databaseContents[resultValidation["userIndex"]]["cuota"]} Requerido: ${jsonContents["contenido"].length}`);

                    // Añadaimos el archivo a la base de datos y actualizamos la cuota
                    if (databaseContents[resultValidation["userIndex"]]["cuota"] >= jsonContents["contenido"].length) {
                        databaseContents[resultValidation["userIndex"]]["archivos"].push({ "nombre": jsonContents["archivo"], "contenido": jsonContents["contenido"]});
                        
                        respuesta["message"] = `Fichero ${jsonContents["archivo"]} guardado correctamente`;
                        wantWriteChanges = true;
                    }
                    else {
                        respuesta["message"] = `Fichero ${jsonContents["archivo"]} no se guardó. Excedida cuota de usuario`;
                    }

                }
                else {
                    respuesta["message"] = `El fichero ${jsonContents["archivo"]} ya existe.`;
                }

                // Comando no retorna contenido
                respuesta["respuesta"] = null;

                break;

            case Utils.CASE_DESCARGAR:
                Logger.Debug(`Servidor: Ejecutando comando descargar para ${jsonContents["usuario"]}`);
                userFileIndex = Contains(databaseContents[resultValidation["userIndex"]]["archivos"], (elemento) => { 
                    return elemento["nombre"] == jsonContents["archivo"];
                });

                if (userFileIndex != -1) {
                    Logger.Debug("Encontrado contenido");
                    respuesta["respuesta"] = JSON.stringify({ "nombre": databaseContents[resultValidation["userIndex"]]["archivos"][userFileIndex]["nombre"], 
                                    "contenido": databaseContents[resultValidation["userIndex"]]["archivos"][userFileIndex]["contenido"] });
                    respuesta["message"] = "Archivo descargado correctamente.";
                }
                else {
                    respuesta["message"] = `El fichero ${jsonContents["archivo"]} no existe`;
                    respuesta["respuesta"] = null;
                }

                break;

            case Utils.CASE_LISTADO:
                Logger.Debug(`Servidor: Ejecutando comando listado para ${jsonContents["usuario"]}`);
                
                const listaResultado = [];
                
                let counter = 0;

                for (let index in  databaseContents[resultValidation["userIndex"]]["archivos"]) {
                    counter += databaseContents[resultValidation["userIndex"]]["archivos"][index]["contenido"].length;
                    listaResultado.push({ "name": databaseContents[resultValidation["userIndex"]]["archivos"][index]["nombre"],
                                            "size": databaseContents[resultValidation["userIndex"]]["archivos"][index]["contenido"].length });
                }

                respuesta["respuesta"] = listaResultado;
                respuesta["message"] = `Espacio disponible ${databaseContents[resultValidation["userIndex"]]["cuota"] - counter} bytes`;
                break;

            case Utils.CASE_BORRAR:
                Logger.Debug(`Servidor: Ejecutando comando borrar para ${jsonContents["usuario"]}`);
                
                userFileIndex = Contains(databaseContents[resultValidation["userIndex"]]["archivos"], (elemento) => { 
                    return elemento["nombre"] == jsonContents["archivo"];
                });
                
                if (userFileIndex != -1) {
                    databaseContents[resultValidation["userIndex"]]["archivos"].splice(databaseContents[resultValidation["userIndex"]]["archivos"][userFileIndex], 1);

                    wantWriteChanges = true;

                    respuesta["message"] = `El fichero ${jsonContents["archivo"]} se ha borrado correctamente.`;
                }
                else {
                    respuesta["message"] = `El fichero ${jsonContents["archivo"]} no existe.`;
                }

                // Comando no retorna contenido
                respuesta["respuesta"] = null;

                break;

            default:
                Logger.Error("Servidor: Comando desconocido");
                break;
        }
    }
    
    // [Respuesta]
    socket.write(JSON.stringify(respuesta));

    execResult.serialize = wantWriteChanges;
    execResult.serializeContents = databaseContents;

    return execResult;
}


/**
 * Punto de entrada principal. Crea el servidor y lo pone
 * a escuhar y responder peticiones por los puertos establecidos.
 * */
function Run() {
    const server = Net.createServer((socket) => {
        // Esta función se ejcuta cada vez que se conecta un nuevo cliente al servidor.
    
        Logger.Info(`Nuevo cliente conectado de dirección ${socket.localAddress} y puerto ${socket.localPort}`);
    
    
        // Para el cliente nuevo establecemos los event listeners
        // que se llaman cada vez que recibimos un tipo de evento específico.
    
        socket.on("data", (data) => {
            // [Procesar datos recibidos con asincronía]
            HandleRequest(socket, data).then((result) => { 
                if(result.wantCloseServer) {
                    server.close();
                }
                else if (result.result) {
                    Logger.Info(`Petición procesada correctamente`); 

                    // Commit the cambios si es necesario
                    if (result.serialize) {
                        Fs.writeFileSync(DATABASE_FILE_PATH, JSON.stringify(result.serializeContents, null, 4), { encoding: "utf8", flag: "w" });
                    }
                }
                else {
                    Logger.Info(`Petición abortada.`); 
                }
            });
        });
    
        socket.on("end", () => {
            Logger.Info("Cliente disconnected");
        });
    
        socket.on("error", (error) => {
            Logger.Error(`Socket error. Message: ${error.message}`);
        });
    });
    
    // Configuramos un listener para errores en el mismo servidor
    server.on("error", (error) => {
        Logger.Error(`Socket error. Message: ${error.message}`);
    });

    server.on("close", (error) => {
        Logger.Info(`Cerrando servidor.`);
    });
    
    server.listen(LISTEN_PORT, ADDRESS, () => {
        Logger.Info(`TCP socket server is running on port: ${LISTEN_PORT} at address ${ADDRESS}`);
    });
}


// Validar utilidades del servidor.
Utils.CargarArchivo(DATABASE_FILE_PATH).
    then((contenido) => {
        if (Utils.ParseJSON(contenido) == null) {
            Logger.Error("Fichero de base de datos inválido");
        }
        else {
            Run();
        }
    })
    .catch((error) => {
        Logger.Error(`Error al cargar archivo. Error: ${error}`);
    });