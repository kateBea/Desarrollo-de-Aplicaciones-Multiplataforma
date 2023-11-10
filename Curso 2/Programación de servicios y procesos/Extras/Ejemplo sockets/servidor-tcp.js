'use strict'

const net = require("net");
const port = 5000;
const server = net.createServer((socket) => {
    console.log("Client connected");
    socket.on("data", (data) => {
        const strData = data.toString();
        console.log('Recibido: ' + strData);
        socket.write(strData);
    });
    socket.on("end", () => {
        console.log("Client disconnected");
    });
    socket.on("error", (error) => {
        console.log('Socket Error: ' + error.message);
    });
});

server.on("error", (error) => {
    console.log('Socket Error: ' + error.message);
});

server.listen(port, () => {
    console.log("TCP socket server is running on port: " + port);
});