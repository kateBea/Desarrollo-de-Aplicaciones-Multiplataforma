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
    const runner = (user, pass, index) => {
        Logger.Info("Case de prueba listado " + index);
        Client.Execute(user, pass, Utils.CASE_LISTADO, undefined);
    }; 
    
    // Ejecutar una serie de peticiones a la vez
    Promise.all([
        runner("pepe", "12345", 1),
        //runner("lolo", "12346", 2),
        //runner("pepe", "12345", 3),
        //runner("lolo", "12345", 4),
        //runner("lolo", "12345", 5),
    ]).then((resultados) => {
        Logger.Info("Casos de prueba ejecutados con éxito.");
    })
}


/* Exports del módulo */

exports.Run = Run;