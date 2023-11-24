
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

class ChatClient {
    constructor(name, password, address, port, color) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.port = port;
        this.color = color;
    }

    displayClientInfo() {
        console.log(`Nombre: ${this.name}`);
        console.log(`Password: ${this.password}`);
        console.log(`Address: ${this.address}`);
        console.log(`Port: ${this.port}`);
        console.log(`Color: ${this.color}`);
    }
}

const COLOR_NEGRO = 30;
const COLOR_ROJO = 31;
const COLOR_VERDE = 32;
const COLOR_AMARILLO = 33;
const COLOR_AZUL = 34;
const COLOR_MAGENTA = 35;
const COLOR_CYAN = 36;
const COLOR_BLANCO = 37;

const Colores = [
    COLOR_NEGRO,
    COLOR_ROJO,
    COLOR_VERDE,
    COLOR_AMARILLO,
    COLOR_AZUL,
    COLOR_MAGENTA,
    COLOR_CYAN,
    COLOR_BLANCO,
];

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

/**
 * Parsea una cadena JSON y devuelve el objeto resultante o null si hay un error.
 * @param {string} contentsStr - Cadena que contiene datos en formato JSON.
 * @returns {Object} Objeto resultante del análisis JSON (lista u objeto) o null si hay un error.
 * */
function ParseJSON(constentsStr) {
    let result = null;

    try {
        result = JSON.parse(constentsStr);
    }
    catch(err) {
        Logger.Error(`Error al parsear fichero JSON. Contenido:\n ${constentsStr}`)
    }

    return result;
}

function TextoColoreado(contenido, color) {
    if (color == undefined) {
        color = COLOR_BLANCO;
    }

    console.log(`\x1b[0;${color}m${contenido}\x1b[0m`);
}

function TextoColoreadoStr(contenido, color) {
    if (color == undefined) {
        color = COLOR_BLANCO;
    }

    return `\x1b[0;${color}m${contenido}\x1b[0m`;
}

/** Exports */
exports.TextoColoreado = TextoColoreado;
exports.TextoColoreadoStr = TextoColoreadoStr;

exports.COLOR_NEGRO = COLOR_NEGRO;
exports.COLOR_ROJO = COLOR_ROJO;
exports.COLOR_VERDE = COLOR_VERDE;
exports.COLOR_AMARILLO = COLOR_AMARILLO;
exports.COLOR_AZUL = COLOR_AZUL;
exports.COLOR_MAGENTA = COLOR_MAGENTA;
exports.COLOR_CYAN = COLOR_CYAN;
exports.COLOR_BLANCO = COLOR_BLANCO;
exports.Colores = Colores;

exports.HELP_COMMAND = HELP_COMMAND;
exports.NEW_CONNECTION = NEW_CONNECTION;
exports.BIENVENIDA_CHAT = BIENVENIDA_CHAT;
exports.CLIENT_DISCONNECT = CLIENT_DISCONNECT;
exports.ChatClient = ChatClient;
exports.ParseJSON = ParseJSON;