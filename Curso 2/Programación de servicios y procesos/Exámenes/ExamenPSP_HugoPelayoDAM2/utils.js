"use strict"

const Crypto = require("crypto");

const SIMETRIC_CRYPT_ALGO = "aes-192-cbc";
const IV_VECTOR =  'ABCDEFGHIJKLMNOP';

/**
 * Encripta un mensaje utilizando cifrado asimétrico con una clave pública.
 *
 * @param {string} message - El mensaje que se va a encriptar.
 * @param {string} publicKey - La clave pública utilizada para la encriptación.
 * @param {string} format - El formato de salida de depuración para el texto cifrado (opcional) por defector es "base64".
 * @returns {Buffer} - Datos encriptados como un objeto Buffer.
 * */
function EncryptAsimetric(message, publicKey) {
    const encryptedData = Crypto.publicEncrypt(
        {
            key: publicKey,
            padding: Crypto.constants.RSA_PKCS1_OAEP_PADDING,
            oaepHash: "sha256",
        },

        // Se usa "Buffer.from" para transformar el texto a tipo Buffer
        Buffer.from(message)
    );

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
function DecryptAsimetric(message, privateKey) {
    const decryptedData = Crypto.privateDecrypt(
        {
            key: privateKey,
            padding: Crypto.constants.RSA_PKCS1_OAEP_PADDING,
            oaepHash: "sha256",
        },

        Buffer.from(message)
    );

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
        console.log("Error al parsear JSON");
    }

    return result;
}

exports.ParseJSON = ParseJSON;

exports.EncryptSimetric = EncryptSimetric;
exports.EncryptAsimetric = EncryptAsimetric;
exports.DecryptAsimetric = DecryptAsimetric;
exports.DecryptSimetric = DecryptSimetric;

exports.Sign = Sign;
exports.Verify = Verify;