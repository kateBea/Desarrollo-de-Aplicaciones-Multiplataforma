/**
 * Controlador del cliente. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

/** Imports */

const Fs = require("fs");
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

let clientPublicKey;
let clientPrivateKey;
let serverPrivateKey;

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

    readliner.on("close", () => {
        client.close();
        Utils.TextoColoreado("Desconectado.", Utils.COLOR_VERDE);
    });
}

function SenMessage(message) {
    client.send(message, 0, message.length, PORT, ADDRESS, (err, bytes) => {
        if (err) {
            throw err;
        }

        Utils.TextoColoreado('UDP message sent to ' + ADDRESS + ':' + PORT, Utils.COLOR_VERDE);
        HandleUserInputs(targetString);
    });
}

function HandleUserInputs(targetString) {`\x1b[0;${1}m${1}\x1b[0m`
    readliner.question(
        `[Client: ${COMMAND_LINE_ARGS[2]}] (escribe '${targetString}' para desconetar): `, 
        function(userInput) {
            if (userInput === targetString) {
                readliner.close();
            } else {
                const message = new Buffer.from(JSON.stringify({ "nombre": COMMAND_LINE_ARGS[2], "mensaje": userInput }));
                
                SenMessage(message);
        }
    });
}

function ConnectToServer() {
    // cargar claves
    try {
        clientPublicKey = Fs.readFileSync("client-public.cert", { encoding: "utf8" }); 
        clientPrivateKey = Fs.readFileSync("client-private.key", { encoding: "utf8" });
    
        serverPrivateKey = Fs.readFileSync("server-public.cert", { encoding: "utf8" });
    } catch(err) {
        console.log(`Excepción. Mensaje [ ${err.message} ]`);
    }

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