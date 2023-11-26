// decrypt-asymmetric.js

const crypto = require("crypto");

// Se importa la clave privada desde el archivo que contiene la clave
const privateKey = require("./private-key");

// El texto cifrado se obtiene desde el resultado de encrypt-asymmetric.js
const encryptedData = Buffer.from("...Texto cifrado en base64...");

// Para descifrar:
const decryptedData = crypto.privateDecrypt(
    {
        key: privateKey,
        padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
        oaepHash: "sha256",
    },
    encryptedData
);

// Los datos descifrados están en formato Buffer, se usa toString para
// recuperar el texto original:
console.log("\nTexto descifrado:\n" + decryptedData.toString(""));
