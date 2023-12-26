"use strict"

const Net = require("net");
const Dgram = require("dgram");
const Utils = require("../utils.js");

const LOCALHOST = "127.0.0.1";
const PORT_KNOCKING_TARGET_CLIENT = LOCALHOST;
const PORTS = [8081, 8082, 8083]
const TCP_SERVER_PORT = 5000;

let index = 0;

const server8081 = Dgram.createSocket("udp4");
const server8082 = Dgram.createSocket("udp4");
const server8083 = Dgram.createSocket("udp4");

let tcpServer = null;

function FromServerTo(message, address, port, server) {
    server.send(message, 0, message.length, port, address, (err, bytes) => {
        if (err) {
            throw err;
        }

        console.log('UDP message sent to ' + address + ':' + address);
    });
}

function InitTCPServer() {
    console.log("Inicializando servidor TCP");

    const tcpServer = Net.createServer((socket) => {
        console.log("Client connected");

        socket.on("data", (data) => {
            const strData = data.toString();
            console.log("Recibido: " + strData);

            // responder a cliente 
            // para no dejar a la espera
            socket.write("Hugo Pelayo");
        });

        socket.on("end", () => {
            console.log("Client disconnected");
        });

        socket.on("error", (error) => {
            console.log('Socket Error: ' + error.message);
        });
    });

    tcpServer.on("error", (error) => {
        console.log("Error de socket" + error.message);
    });

    tcpServer.listen(TCP_SERVER_PORT, () => {
        console.log("Servidor TCP en puerto: " + tcpServer);
    });
}

function InitServers() {
    const errorCallback = (server) => {
        return (err) => {
            console.log(`Error: ${err.message}`);
            server.close();
        }
    };

    const messageCallback = (server) => {
        return (msg, rinfo) => {
            console.log("Mensaje: " + msg + " recibido de " + rinfo.address + ':' + rinfo.port);

            if (rinfo.port < PORTS[index]) {
                ++index;
                FromServerTo(new Buffer.from("OK"), rinfo.address, rinfo.port);
            } else if (index == PORTS.length) {
                // cerramos los servidores UDP e 
                // inicializamos el TCP
                server8081.close();
                server8082.close();
                server8083.close();

                InitTCPServer();
            }
        }
    };

    const listeningCallback = (server) => {
        return () => {
            const address = server.address();
            console.log("Escuchando en " + address.address + ":" + address.port);
        }
    };

    server8081.on("error", errorCallback(server8081));
    server8081.on("message", messageCallback(server8081));
    server8081.on("listening", listeningCallback(server8081));

    server8082.on("error", errorCallback(server8082));
    server8082.on("message", messageCallback(server8082));
    server8082.on("listening", listeningCallback(server8082));

    server8083.on("error", errorCallback(server8083));
    server8083.on("message", messageCallback(server8083));
    server8083.on("listening", listeningCallback(server8083));
}

function BindServers() {
    server8081.bind(PORTS[0]);
    server8082.bind(PORTS[1]);
    server8083.bind(PORTS[2]);
}

function Run() {
    InitServers();

    BindServers();
}

Run();