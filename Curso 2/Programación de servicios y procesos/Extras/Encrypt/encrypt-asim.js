// encrypt-asymmetric.js

const fs = require("fs");
const crypto = require("crypto");

// Se generan las claves pública y privada:
const publicKey = fs.readFileSync("server-public.cert", { encoding: "utf8" })

// Texto a cifrar
const data = "Hola mundo";

// Para cifrar:
const encryptedData = crypto.publicEncrypt(
    {
        key: publicKey,
        padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
        oaepHash: "sha256",
    },
    // Se usa "Buffer.from" para transformar el texto a tipo Buffer
    Buffer.from(data)
);

// El texto cifrado está en formato binario, se puede usar "base64" o
// "hexadecimal" para tener un formato más legible:
console.log("\nTexto cifrado:\n" + encryptedData.toString("base64"));
