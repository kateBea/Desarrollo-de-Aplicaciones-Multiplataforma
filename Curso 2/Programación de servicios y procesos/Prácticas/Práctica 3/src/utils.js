/**
 * Utilidades cliente/servidor. 
 * Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict"

const Crypto = require("crypto");


/** Constantes */

const CLIENT_DISCONNECT = "/dc";

const SIMETRIC_CRYPT_ALGO = "aes-192-cbc";
const IV_VECTOR =  'ABCDEFGHIJKLMNOP';

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
const DEBUG_ENABLE_COMMAND = "--debug-enable";
const DEBUG_DISABLE_COMMAND = "--debug-disabled";

const COLOR_NEGRO = 30;
const COLOR_ROJO = 31;
const COLOR_VERDE = 32;
const COLOR_AMARILLO = 33;
const COLOR_AZUL = 34;
const COLOR_MAGENTA = 35;
const COLOR_CYAN = 36;
const COLOR_BLANCO = 37;

// utilidades de depuración
var debugEnable = true;

const RUN_ON_DEBUG =
    (runnable) => {
        if (debugEnable) { runnable(); }
    };

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


/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound].
 *
 * @param {number} lowerBound - Límite inferior del rango.
 * @param {number} upperBound - Límite superior del rango.
 * @returns {number} - Número aleatorio en el rango especificado.
 * */
function GetRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}


/**
 * Imprime texto en la consola con el color especificado.
 * Si el color no se proporciona, se utiliza el color blanco por defecto.
 *
 * @param {string} contenido - El contenido de texto a imprimir.
 * @param {string} color - El código de color ANSI para el texto (opcional).
 * */
function TextoColoreado(contenido, color) {
    if (color == undefined) {
        color = COLOR_BLANCO;
    }

    console.log(`\x1b[0;${color}m${contenido}\x1b[0m`);
}


/**
 * Retorna una cadena de texto con el formato para imprimir con el color especificado.
 * Si el color no se proporciona, se utiliza el color blanco por defecto.
 *
 * @param {string} contenido - El contenido de texto.
 * @param {string} color - El código de color ANSI para el texto (opcional).
 * @returns {string} - La cadena de texto formateada con el color.
 * */
function TextoColoreadoStr(contenido, color) {
    if (color == undefined) {
        color = COLOR_BLANCO;
    }

    return `\x1b[0;${color}m${contenido}\x1b[0m`;
}


/**
 * Encripta un mensaje utilizando cifrado asimétrico con una clave pública.
 *
 * @param {string} message - El mensaje que se va a encriptar.
 * @param {string} publicKey - La clave pública utilizada para la encriptación.
 * @param {string} format - El formato de salida de depuración para el texto cifrado (opcional) por defector es "base64".
 * @returns {Buffer} - Datos encriptados como un objeto Buffer.
 * */
function EncryptAsimetric(message, publicKey, format) {
    const encryptedData = Crypto.publicEncrypt(
        {
            key: publicKey,
            padding: Crypto.constants.RSA_PKCS1_OAEP_PADDING,
            oaepHash: "sha256",
        },

        // Se usa "Buffer.from" para transformar el texto a tipo Buffer
        Buffer.from(message)
    );
    
    RUN_ON_DEBUG(() => {
        TextoColoreado("\nTexto cifrado:\n" + encryptedData.toString(format == undefined ? "base64" : format), COLOR_MAGENTA);
    });

    return encryptedData;
}


/**
 * Desencripta un mensaje utilizando cifrado asimétrico con una clave privada.
 *
 * @param {Buffer} message - Los datos encriptados que se van a desencriptar.
 * @param {string} privateKey - La clave privada utilizada para la desencriptación.
 * @param {string} format - El formato de salida de depuración para el texto cifrado (opcional) por defector es "base64".
 * @returns {Buffer} - Datos desencriptados como un objeto Buffer.
 * */
function DecryptAsimetric(message, privateKey, format) {
    RUN_ON_DEBUG(() => {
        TextoColoreado(`Decrypt message:\n${message.toString("base64")}`);
    });

    const decryptedData = Crypto.privateDecrypt(
        {
            key: privateKey,
            padding: Crypto.constants.RSA_PKCS1_OAEP_PADDING,
            oaepHash: "sha256",
        },

        Buffer.from(message)
    );

    RUN_ON_DEBUG(() => {
        TextoColoreado("\nTexto descifrado:\n" + decryptedData.toString(format == undefined ? "base64" : format), COLOR_MAGENTA);
    });

    return decryptedData
}


/**
 * Encripta un mensaje utilizando cifrado simétrico con una contraseña.
 * La función a llamar debe ser del estilo onEncrypt(error, result) donde
 * error contendrá el error en caso de error en encriptado y result contendrá el 
 * mensaje encriptado si no hay ningún error.
 *
 * @param {string} message - El mensaje que se va a encriptar.
 * @param {string} password - La contraseña utilizada para generar la clave de cifrado.
 * @param {Function} onEncrypt - Función a llamar cuando esté completado el encriptado.
 * */
function EncryptSimetric(message, password, onEncrypt) {
    // Genera la clave de cifrado usando el secreto.
    Crypto.scrypt(password, 'salt', 24, (err, key) => {
        if (err) {
            throw err;
        }
        
        RUN_ON_DEBUG(() => {
            TextoColoreado(`EncryptSimetric received ${message} of type ${typeof(message)}`, COLOR_ROJO);
        });

        let encrypted = '';
        const cipher = Crypto.createCipheriv(SIMETRIC_CRYPT_ALGO, key, IV_VECTOR);

        cipher.setEncoding('hex');
        cipher.on('data', (chunk) => encrypted += chunk);
        cipher.on('end', () => onEncrypt(null, encrypted));
        cipher.on('error', (err) => onEncrypt(err, null));
        cipher.write(message);
        cipher.end();
    });
}


/**
 * Desencripta un mensaje utilizando cifrado simétrico con una contraseña.
 * La función a llamar debe ser del estilo onDecrypt(error, result) donde
 * error contendrá el error en caso de error en encriptado y result contendrá el 
 * mensaje encriptado si no hay ningún error. Es aconsejable que los datos a 
 * desencriptar estén en el mismo formato y tipo de datos con que se encriptó.
 * 
 * @param {string} message - El mensaje encriptado que se va a desencriptar.
 * @param {string} password - La contraseña utilizada para generar la clave de desencriptación.
 * @param {Function} onDecrypt - Función de retorno de llamada que maneja el texto desencriptado o un error.
 * */
function DecryptSimetric(message, password, onDecrypt) {
    Crypto.scrypt(password, 'salt', 24, (err, key) => {
        if (err) {
            throw err;
        }

        RUN_ON_DEBUG(() => {
            TextoColoreado(`DecryptSimetric received ${message} of type ${typeof(message)}`, COLOR_ROJO);
        });

        // Crea un objeto decipher
        const decipher = Crypto.createDecipheriv(SIMETRIC_CRYPT_ALGO, key, IV_VECTOR);
        let decrypted = '';

        decipher.on('readable', () => {
            let chunk;
            while (null !== (chunk = decipher.read())) {
                decrypted += chunk.toString("utf8");
            }
        });
        
        decipher.on('end', () => onDecrypt(null, decrypted));
        decipher.on('error', (err) => onDecrypt(err, null));
        decipher.write(message, 'hex');
        decipher.end();
    });
}


/**
 * Firma un mensaje utilizando una clave privada y un algoritmo de hash específico.
 *
 * @param {string} message - El mensaje que se va a firmar.
 * @param {string} privateKey - La clave privada utilizada para la firma.
 * @param {string} algo - El algoritmo de hash a utilizar (opcional). Por defecto se usa "sha256"
 * @returns {Buffer} - La firma del mensaje como un objeto Buffer.
 * */
function Sign(message, privateKey, algo) {
    const signature = Crypto.sign(
        algo == undefined ? "sha256" : algo, 
        Buffer.from(message), 
        { key: privateKey, padding: Crypto.constants.RSA_PKCS1_PSS_PADDING }
    );

    return signature;
}


/**
 * Verifica la firma de un conjunto de datos utilizando una clave pública y un algoritmo de hash específico.
 *
 * @param {Buffer} signature - La firma que se va a verificar.
 * @param {string} verifiableData - Los datos que se van a verificar.
 * @param {string} publicKey - La clave pública utilizada para la verificación.
 * @param {string} algo - El algoritmo de hash a utilizar (opcional). Por defecto se usa "sha256".
 * @returns {boolean} - true si la verificación es exitosa, false si la firma es inválida.
 * */
function Verify(signature, verifiableData, publicKey, algo) {
    const verification = Crypto.verify(
        algo == undefined ? "sha256" : algo,
        Buffer.from(verifiableData),
        { key: publicKey, padding: Crypto.constants.RSA_PKCS1_PSS_PADDING },
        signature
    );

    return verification;
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
        TextoColoreado(`Error al parsear fichero JSON. Contenido:\n ${constentsStr}`, COLOR_ROJO);
    }

    return result;
}


/**
 * Establece el estado de depuración para habilitar o deshabilitar mensajes de depuración.
 *
 * @param {boolean} value - true para habilitar la depuración, false para deshabilitarla.
 * */
function SetDebug(value) {
    debugEnable = value;
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
exports.DEBUG_ENABLE_COMMAND = DEBUG_ENABLE_COMMAND;
exports.DEBUG_DISABLE_COMMAND = DEBUG_DISABLE_COMMAND;

exports.ParseJSON = ParseJSON;

exports.EncryptSimetric = EncryptSimetric;
exports.EncryptAsimetric = EncryptAsimetric;
exports.DecryptAsimetric = DecryptAsimetric;
exports.DecryptSimetric = DecryptSimetric;

exports.Sign = Sign;
exports.Verify = Verify;

exports.GetRandomInt = GetRandomInt;

exports.SetDebug = SetDebug;
exports.RUN_ON_DEBUG = RUN_ON_DEBUG;