"use strict"

const Net = require("net");
const Dgram = require("dgram");
const Utils = require("../utils.js");

const LOCALHOST = '127.0.0.1';
const ADDRESS = LOCALHOST;
const COMMAND_LINE_ARGS = process.argv;

let client = null;
let clientTcp = null;
let socketType = null;

function FromClientTo(message, address, port) {
    client.send(message, 0, message.length, port, address, (err, bytes) => {
        if (err) {
            throw err;
        }
        
        console.log('UDP message sent to ' + address + ':' + port);
        client.close();
    });
}

function ParseCommandLineArgs() {
    if (COMMAND_LINE_ARGS.length != 3) {
        return false;
    }
    
    console.log(COMMAND_LINE_ARGS[2])
    if (COMMAND_LINE_ARGS[2] != "udp1" && COMMAND_LINE_ARGS[2] != "udp2" &&
        COMMAND_LINE_ARGS[2] != "udp3" && COMMAND_LINE_ARGS[2] != "tcp") {
        return false;
    }

    socketType = COMMAND_LINE_ARGS[2];

    return true;
}

function GetPortFromSocketType() {
    switch(socketType) {
        case "udp1": return 8081;
        case "udp2": return 8082;
        case "udp3": return 8083;
        case "tcp": return 8084;
    }

    return -1;
}

function InitUDPClient(port) {
    client = Dgram.createSocket('udp4');

    client.on("message", (msg, rinfo) => {
        console.log(`Recibido: ${msg}`);

        if (msg.equals(new Buffer.from("OK"))) {
            console.log("OK");
        }

        client.close();
    });
}

function InitTCPClient(port) {
    console.log("Inicializando cliente TCP");

    clientTcp = Net.createConnection(port, ADDRESS, () => {
        console.log("Connected");
        clientTcp.write(`Ping TCP a ${ADDRESS}:${port}`);
    });
    
    
    clientTcp.on("data", (data) => {
        console.log("Recibido: " + data);
        
        clientTcp.end();
    });
    
    clientTcp.on("error", (error) => {
        console.log("Error: " + error.message);
    });
    
    clientTcp.on("close", () => {
        console.log("Cerrando cliente");
    });
}

function Run() {
    if (!ParseCommandLineArgs()) {
        console.log("Bad usage");
        return;
    }

    const port = GetPortFromSocketType();

    if (port == 8084) {
        InitTCPClient(port);
    } else if(port != -1) {
        InitUDPClient();

        const pingMessage = new Buffer.from(`Ping a ${ADDRESS}:${port}`);
        FromClientTo(pingMessage, ADDRESS, port);
    } else {
        console.log("Puerto inválido");
    }
}

Run();