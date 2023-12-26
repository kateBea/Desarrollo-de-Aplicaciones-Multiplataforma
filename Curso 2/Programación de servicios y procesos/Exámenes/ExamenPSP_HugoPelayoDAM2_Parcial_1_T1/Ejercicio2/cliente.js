"use strict"

const Dgram = require("dgram");
const Utils = require("../utils.js");

const PASSWORD = "12345";
const LOCALHOST = '127.0.0.1';
const PORT = 8000;
const ADDRESS = LOCALHOST;
const client = Dgram.createSocket('udp4');

const numero = 1;
const message = new Buffer.from(JSON.stringify({ "número": numero })).toString("utf8");

Utils.EncryptSimetric(message, PASSWORD, (error, encriptedData) => {
    if (error) {
        console.log("Error al encriptar mensaje");
        return;
    }

    const finalEncriptedMessage = new Buffer.from(encriptedData);
    client.send(finalEncriptedMessage, 0, finalEncriptedMessage.length, PORT, ADDRESS, (err, bytes) => {
        if (err) {
            throw err;
        }
        
        console.log("Cliente ha enviado: " + numero);
        console.log('UDP message sent to ' + ADDRESS + ':' + PORT);
    });
});


client.on("message", (msg, rinfo) => {
    console.log(`Recibido: ${msg}`);

    Utils.DecryptSimetric(new Buffer.from(msg).toString("utf8"), PASSWORD, (error, decriptedData) => {
        if (error) {
            throw error;
        }
        
        const parsedData = Utils.ParseJSON(decriptedData);

        if (parsedData) {
            console.log(`Servidor ha mandado: ${parsedData["número"]}`);
        } else {
            console.log("Error al parsear los datos JSON");
        }
    });

    client.close();
});