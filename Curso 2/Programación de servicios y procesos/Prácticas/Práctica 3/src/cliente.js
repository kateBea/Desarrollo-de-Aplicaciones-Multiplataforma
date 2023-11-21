"use strict"

const dgram = require('dgram');
const LOCALHOST = '127.0.0.1';
const PORT = 8000;
const ADDRESS = LOCALHOST;
const client = dgram.createSocket('udp4');

const message = "Este es un mensaje";

client.send(message, 0, message.length, PORT, ADDRESS, (err, bytes) => {
    if (err) {
        throw err;
    }

    console.log('UDP message sent to ' + ADDRESS + ':' + PORT);
    client.close();
});