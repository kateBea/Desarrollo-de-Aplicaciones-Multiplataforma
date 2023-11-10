/**
 * Punto de entrada aplicación cliente. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

const Utils = require("./common/utilities.js");
const Client = require("./src/client-manager.js");
const Logger = require("./common/logger.js");

const COMMAND_LINE_ARGS = process.argv;

const HELP_COMMAND = "--help";

const CASE_SUBIR = "subir";
const CASE_BORRAR = "borrar";
const CASE_LISTADO = "listado";
const CASE_DESCARGAR = "descargar";

/**
 * Muestra los comandos de este programa.
 * */
function Help() {
    console.log(
        "Usage: node cliente.js client_name client_password command [file_path]"
    );
}

/**
 * Muestra el uso correcto del programa.
 * */
function Usage() {
    console.log(
        "Número incorrecto de argumentos\n" +
        "Usa 'node cliente.js --help' para desplegar la ayuda\n" +
        "Usage: node cliente.js client_name password command [FILE_PATH]"
    );
}

/**
 * Valida los argumentos de la línea de comandos.
 * @returns {boolean} - Cierto si el listado de argumentos es válido y no se solicita la ayuda, falso en caso contrario.
 * */
function ParseComdLineArguments() {
    if (COMMAND_LINE_ARGS.length < 3) {
        // no alcanzado mínimo requerido de argumentos
        // ej.: node cliente.js --help
        Usage();
        return;
    }

    // El usuario quiere mostrar la ayuda
    if (COMMAND_LINE_ARGS[2] == HELP_COMMAND) {
        Help();
        return false;
    }

    // Se requiere comando si hay datos de cliente
    if (COMMAND_LINE_ARGS[4] == undefined) {
        Usage();
        return false;
    }
    else {
        // subir o descargar require nombre de fichero
        if (COMMAND_LINE_ARGS[4] == "subir" || COMMAND_LINE_ARGS[4] == "descargar") {
            return COMMAND_LINE_ARGS[4] != undefined;
        }
    }

    return true;
}

/**
 * Ejecuta un caso de prueba mostrando primero el mensaje de entrada.
 * @param {string} entryMessage - Mensaje de entrada para el registro.
 * @param {Function} task - Función que representa la tarea/caso de prueba a ejecutar.
 * @returns {Promise<boolean>} - Una promesa con un booleano. Resuelve true si la tarea se ejecuta correctamente, de lo contrario, resuelve false.
 */
async function RunCase(entryMessage, task) {
    Logger.Debug(entryMessage);

    try {
        task();
    }
    catch(err) {
        Logger.Error(err);
        return false;
    }

    return true;
}

/**
 * Entrada principal a la aplicación cliente.
 * */
function Run() {
    if (!ParseComdLineArguments()) {
        return;
    }

    const user = COMMAND_LINE_ARGS[2];
    const password = COMMAND_LINE_ARGS[3];
    const command = COMMAND_LINE_ARGS[4];

    switch (command) {
    case CASE_SUBIR:
        Logger.Debug(`Ejecutando comando subir para usuario ${user}`);
        Utils.CargarArchivo(COMMAND_LINE_ARGS[5]).then((result) => {
            const file = { path: COMMAND_LINE_ARGS[5], contents: result };
            Client.Execute(user, password, command, file);
        });
        break;

    case CASE_DESCARGAR:
        RunCase(`Ejecutando comando descargar para usuario ${user}`, () => {
            const file = { path: COMMAND_LINE_ARGS[5], contents: null };
            Client.Execute(user, password, command, file);
        });
        break;

    case CASE_LISTADO:
        RunCase(`Ejecutando comando listado para usuario ${user}`, () => {
            Client.Execute(user, password, command, undefined);
        });
        break;

    case CASE_BORRAR:
        RunCase(`Ejecutando comando borrar para usuario ${user}`, () => {
            const file = { path: COMMAND_LINE_ARGS[5], contents: null };
            Client.Execute(user, password, command, file);
        });
        break;

    default:
        Logger.Error("Comando no reconocido");
        break;
    }
}

Run();
