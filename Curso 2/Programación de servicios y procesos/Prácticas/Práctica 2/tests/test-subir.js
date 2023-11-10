/**
 * Casos de prueba comando listado. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */


"use strict"

/* Imports */

const Utils = require("../common/utilities.js");
const Logger = require("../common/logger.js");
const Client = require("../src/client-manager.js");


/**
 * Punto de entrada principal.
 * */
function Run() {
    // Ejecutar una serie de peticiones a la vez
    Promise.all([
        (() => {
            Logger.Info("Case de prueba subir 1");
            Utils.CargarArchivo("init-server.sh").then((result) => {
                const file = { path: "init-server.sh", contents: result };
                Client.Execute("pepe", "12345", Utils.CASE_SUBIR, file);
            });
        })(),
    ]).then((resultados) => {
        Logger.Info("Casos de prueba ejecutados con éxito.");
    })
}


/* Exports del módulo */

exports.Run = Run;