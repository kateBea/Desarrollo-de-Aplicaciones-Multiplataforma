'use strict'

const net = require("net");

const host = "127.0.0.1";
const port = 5000;

const client = net.createConnection(port, host, () => {
    console.log("Connected");
    client.write('Hello World');
});

let contador = 0;

client.on("data", (data) => {
    console.log("Received: " + data);
    if (contador > 5) client.end();
    else client.write("" + contador++);
});

client.on("error", (error) => {
    console.log("Error: " + error.message);
});

client.on("close", () => {
    console.log("Connection closed");
});