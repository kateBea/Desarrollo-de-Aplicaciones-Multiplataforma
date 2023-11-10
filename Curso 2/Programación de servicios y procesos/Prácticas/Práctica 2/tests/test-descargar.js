/**
 * Casos de prueba comando descargar. Version node: v18.18.0.
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
    const runner = (user, pass, fileName, index) => {
        Logger.Info("Case de prueba borrar " + index);
        const file = { path: fileName, contents: null };
        Client.Execute(user, pass, Utils.CASE_DESCARGAR, file);
    }; 

    // Ejecutar una serie de peticiones a la vez
    Promise.all([
        runner("pepe", "12345", "archivo1.txt", 1),
        runner("pepe", "12345", "archivo2.txt", 1),
        runner("pepe", "12345", "archivo3.txt", 1),
        runner("pepe", "1234", "archivo1.txt", 1),
        runner("lolo", "12345", "archivo1.txt", 1),

    ]).then((resultados) => {
        Logger.Info("Casos de prueba ejecutados con éxito.");
    })
}


/* Exports del módulo */

exports.Run = Run;