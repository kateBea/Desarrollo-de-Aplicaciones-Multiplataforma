'use strict'

const dgram = require('dgram');

const BIND_PORT = 8000;

const server = dgram.createSocket('udp4');

server.on('error', (err) => {
    console.log('Error:\n' + err.stack);
    server.close();
});

server.on('message', (msg, rinfo) => {
    const clientMsg = msg;
    const clientPort = rinfo.port;
    const clientAddress = rinfo.address;

    console.log('Mensaje: ' + clientMsg + " recibido de " + clientAddress + ':' + clientPort);
});

server.on('listening', () => {
    const address = server.address();
    console.log("Escuchando en " + address.address + ":" + address.port);
});

server.bind(BIND_PORT);