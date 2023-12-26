"use strict"

const Dgram = require("dgram");
const Utils = require("../utils.js");

const BIND_PORT = 8000;
const PASSWORD = "12345";


const server = Dgram.createSocket("udp4");

function FromServerTo(message, address, port) {
    server.send(message, 0, message.length, port, address, (err, bytes) => {
        if (err) {
            throw err;
        }
        
        console.log('UDP message sent to ' + address + ':' + address);
    });
}

server.on("error", (err) => {
    console.log(`Error: ${err.message}`);
    server.close();
});

server.on("message", (msg, rinfo) => {
    console.log('Mensaje: ' + msg + " recibido de " + rinfo.address + ':' + rinfo.port);

    Utils.DecryptSimetric(new Buffer.from(msg).toString("utf8"), PASSWORD, (error, decriptedData) => {
        if (error) {
            console.log("Error al desencriptar los datos");
            return;
        }

        const parsedData = Utils.ParseJSON(new Buffer.from(decriptedData).toString("utf8"));
        console.log(parsedData);

        parsedData["número"] += 1;

        Utils.EncryptSimetric(JSON.stringify(parsedData), PASSWORD, (error, encriptedData) => {
            if (error) {
                console.log(`Error al encriptar datos. ${error.message}`);
                return;
            }

            FromServerTo(new Buffer.from(encriptedData), rinfo.address, rinfo.port);
        });

    });
});

server.on("listening", () => {
    const address = server.address();
    console.log("Escuchando en " + address.address + ":" + address.port);
});

server.bind(BIND_PORT);