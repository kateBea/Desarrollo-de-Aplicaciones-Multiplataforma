/**
 * Controlador del servidor. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */


"use strict"

/** Imports */

const Dgram = require('dgram');
const Utils = require("./utils.js");


/** Constantes */

const BIND_PORT = 8000;


/** Globales */

let server;
let clients = []


function IsAlreadyConnected(clientName) {
    for (clientIndex in clients) {
        if (clients[clientIndex].name == clientName) {
            return true;
        }
    }

    return -1;
}

function GeneratePassword() {

}

function Run() {
    server = Dgram.createSocket('udp4');

    server.on('error', (err) => {
        console.log('Error:\n' + err.stack);
        server.close();
    });
    
    server.on('message', (msg, rinfo) => {
        const clientMsg = msg;
        const clientName = null;
        const clientPort = rinfo.port;
        const clientAddress = rinfo.address;
        
        const result = IsAlreadyConnected(clientName);

        if (result == -1) {
            // Nueva conexión
            const password = GeneratePassword();
            clients.push(new ChatClient(clientName, password, clientAddress, clientPort));
            console.log(Utils.NEW_CONNECTION.replace("__ADDRESS__", `${clientAddress}:${clientPort}`));
        } else {
            // el cliente ya se había conectado
        }

        // debug
        console.log(`Mensaje: '${clientMsg}'  recibido de ${clientAddress}:${clientPort}`);
    });
    
    server.on('listening', () => {
        const address = server.address();
        console.log("Escuchando en " + address.address + ":" + address.port);
    });
    
    server.bind(BIND_PORT);
}

Run();