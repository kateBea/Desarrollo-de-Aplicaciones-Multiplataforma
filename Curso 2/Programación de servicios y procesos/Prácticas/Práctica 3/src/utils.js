
/** Comandos */
const CLIENT_DISCONNECT = "/dc";

/** */
const NEW_CONNECTION = 
`
=======================================================
NUEVA CONEXIÓN DE __ADDRESS__
=======================================================
`;

const BIENVENIDA_CHAT = 
`
=======================================================
BIENVENIDO AL CHAT __NAME__
=======================================================
`;

const HELP_COMMAND = "--help";

function WriteToConsoleColored(str, color) {

}

function EncryptAsimetric() {

}

function DecryptAsimetric() {

}

function EncryptSimetric() {

}

function DecryptSimetric() {

}

class ChatClient {
    constructor(name, password, address, port) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.port = port;
    }

    displayClientInfo() {
        console.log(`Nombre: ${this.name}`);
        console.log(`Password: ${this.password}`);
        console.log(`Address: ${this.address}`);
        console.log(`Port: ${this.port}`);
    }
}

/** Exports */
exports.HELP_COMMAND = HELP_COMMAND;
exports.NEW_CONNECTION = NEW_CONNECTION;
exports.BIENVENIDA_CHAT = BIENVENIDA_CHAT;
exports.CLIENT_DISCONNECT = CLIENT_DISCONNECT;
exports.ChatClient = ChatClient;