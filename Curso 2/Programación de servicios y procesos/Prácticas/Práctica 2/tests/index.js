/**
 * CSelector de casos de prueba. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

/** Imports */

const Logger = require("../common/logger.js");
const TestCaseSubir = require("./test-subir.js");
const TestCaseBorrar = require("./test-borrar.js");
const TestCaseListado = require("./test-listado.js");
const TestCaseDescargar = require("./test-descargar.js");


/** Constantes */

const COMMAND_LINE_ARGS = process.argv;
const CASE_SUBIR = "test-case-subir";
const CASE_BORRAR = "test-case-borrar";
const CASE_LISTADO = "test-case-listado";
const CASE_DESCARGAR = "test-case-bajar";


/* Globales */

let testCase;


/**
 * Recoge el tipo de caso de la línea de comandos.
 * */
function ParseComdLineArguments() {
    for (let cmd in COMMAND_LINE_ARGS) {
        Logger.Debug(`argv[${cmd}]: ` + COMMAND_LINE_ARGS[cmd]);
    }

    testCase = COMMAND_LINE_ARGS[COMMAND_LINE_ARGS.length - 1];
}


/**
 * Entrada principal al programa.
 * */
function Run() {
    ParseComdLineArguments();

    switch (testCase) {
        case CASE_SUBIR:
            Logger.Info("Iniciando pruebas de subida de archivos");
            TestCaseSubir.Run();
            break;

        case CASE_BORRAR:
            Logger.Info("Iniciando pruebas de borrado de archivos");
            TestCaseBorrar.Run();
            break;

        case CASE_LISTADO:
            Logger.Info("Iniciando pruebas de listado de archivos");
            TestCaseListado.Run();
            break;

        case CASE_DESCARGAR:
            Logger.Info("Iniciando pruebas de descarga de archivos");
            TestCaseDescargar.Run();
            break;
    }
}

Run()