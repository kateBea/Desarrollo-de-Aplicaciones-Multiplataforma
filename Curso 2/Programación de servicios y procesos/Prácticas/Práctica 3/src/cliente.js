/**
 * Controlador del cliente. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

/** Imports */

const Dgram = require('dgram');
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

/**
 * Muestra los comandos de este programa.
 * */
function Help() {
    console.log(
        "Usage: node cliente.js client_name"
    );
}

/**
 * Muestra el uso correcto del programa.
 * */
function Usage() {
    console.log(
        "Número incorrecto de argumentos\n" +
        "Usa 'node cliente.js --help' para desplegar la ayuda\n" +
        "Usage: node cliente.js client_name"
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

    // argumentos inecesarios
    if (COMMAND_LINE_ARGS.length != 3) {
        Usage();
        return false;
    }

    return true;
}

function Init() {
    // client
    client = Dgram.createSocket(SOCKET_TYPE);

    // readline
    readliner = Readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    readliner.on('close', () => {
        client.close();
        console.log('Desconectado.');
    });
}

function HandleUserInputs(targetString) {
    readliner.question(`[Channel: Main] (escribe '${targetString}' para desconetar): `, (userInput) => {
        if (userInput === targetString) {
            readliner.close();
        } else {
            const message = new Buffer.from(userInput);
            
            client.send(message, 0, message.length, PORT, ADDRESS, (err, bytes) => {
                if (err) {
                    throw err;
                }
            
                console.log('UDP message sent to ' + ADDRESS + ':' + PORT);
                HandleUserInputs(targetString);
            });
        }
    });
}

function  ConnectToServer() {

}

function RunMainLoop() {
    ConnectToServer();

    HandleUserInputs(Utils.CLIENT_DISCONNECT);
}

function Run() {
    if (!ParseComdLineArguments()) {
        return;
    }

    console.log(Utils.BIENVENIDA_CHAT.replace("__NAME__", COMMAND_LINE_ARGS[2]));

    Init();

    RunMainLoop();
}

Run();