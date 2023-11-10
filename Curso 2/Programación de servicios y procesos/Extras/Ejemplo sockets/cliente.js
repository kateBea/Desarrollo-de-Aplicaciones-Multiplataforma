'use strict'

const dgram = require('node:dgram');
const LOCALHOST = '127.0.0.1';
const PORT = 8000;
const ADDRESS = LOCALHOST;
const client = dgram.createSocket('udp4');

const message = new Buffer.from('Hello World');

client.send(message, 0, message.length, PORT, ADDRESS, (err, bytes) => {
    if (err) {
        throw err;
    }

    console.log('UDP message sent to ' + ADDRESS + ':' + PORT);
    client.close();
});