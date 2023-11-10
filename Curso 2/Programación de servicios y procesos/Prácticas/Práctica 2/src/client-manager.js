/**
 * Controlador del sistema del cliente. Version node: v18.18.0.
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
const { create } = require("domain");


/* Constantes */

const PORT      = 5000;
const LOCALHOST = "127.0.0.1";
const ADDRESS   = LOCALHOST;

const CASE_SUBIR = "subir";
const CASE_DESCARGAR = "descargar";


/**
 * Ejecuta una conexión de cliente con el servidor en la dirección prestablecida 
 * por las constantes ADDRESS y PORT para la transmisión de datos.
 * @param {string} clientName - Nombre del cliente.
 * @param {string} clientPassword - Contraseña del cliente.
 * @param {string} command - Comando a ejecutar en el servidor.
 * @param {Object} file - Archivo asociado al comando, si corresponde.
 * */
function Execute(clientName, clientPassword, command, file) {
    const client = Net.createConnection(PORT, ADDRESS, () => {
        Logger.Info(`Cliente [user: ${clientName}, password: ${clientPassword}] conectado con éxito`);

        if ((command == CASE_DESCARGAR || command == CASE_SUBIR) && file == undefined) {
            Logger.Warn(`Usando comando subir o descargar sin un archivo válido`);
        }

        // preparar los datos para mandar al servidor
        const uploadData = {
            "usuario": clientName,
            "password": clientPassword,
            "accion": command,
            "archivo": file != undefined ? file.path : null,
            "contenido": file != undefined ? file.contents : null,
        }

        client.write(JSON.stringify(uploadData));
    });
    
    client.on("data", (data) => {
        Logger.Debug(`Respuesta servidor: ${data}`);
        const respuesta = Utils.ParseJSON(data);

        if (respuesta != null) {
            switch (command) {
            case Utils.CASE_SUBIR:
                Logger.Info(respuesta["message"]);
                break;
        
            case Utils.CASE_DESCARGAR:
                Logger.Info(respuesta["message"]);
                
                // El contenido es un string JSON (no un objeto en sí)
                const fileInfo = Utils.ParseJSON(respuesta["respuesta"]);

                if (fileInfo != null) {
                    Logger.Debug(`Nombre fichero: ${fileInfo["nombre"]}`);
                    Logger.Debug(`Contenido fichero: ${fileInfo["contenido"]}`);
    
                    // [Creamos el fichero]
                    // creamos el fichero y sis existe sobresecribimos en el directorio de trabajo actual.
                    Fs.writeFileSync(fileInfo["nombre"], fileInfo["contenido"], { encoding: "utf8", flag: "w" }, (err) => {
                        if (err) {
                            Logger.Error(`Erroral crear el fichero de descarga. Mensaje: ${err}`);
                        }
    
                        Logger.Info("Fichero creado y escrito correctamente.");
                    });
                }
                else {
                    Logger.Warn("Datos de archivo no definidos.");
                }

                break;
        
            case Utils.CASE_LISTADO:
                Logger.Info(respuesta["message"]);

                // La respuesta es una lista con pares (nombre archivo, tamaño en bytes)
                for (let index in respuesta["respuesta"]) {
                    Logger.Info(`File: ${respuesta["respuesta"][index]["name"]}. Size: ${respuesta["respuesta"][index]["size"]}.`);
                }

                Logger.Info(respuesta["message"]);
                break;
        
            case Utils.CASE_BORRAR:
                Logger.Info(respuesta["message"]);
                break;

            case Utils.CASE_CERRAR:
                Logger.Info(respuesta["message"]);
                break;
        
            default:
                Logger.Error("Comando no reconocido");
                break;
            }
        }

        client.end();
    });
    
    client.on("error", (error) => {
        Logger.Error(`Error en cliente. Mensaje: ${error.message}.`);
    });
    
    client.on("close", () => {
        Logger.Info("Terminando conexión");
    });
}


/* Exportaciones de módulo */

exports.Execute = Execute;