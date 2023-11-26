const crypto = require("crypto");

// Se generan las claves pública y privada:
const { publicKey, privateKey } = crypto.generateKeyPairSync("rsa", {
    modulusLength: 2048
});

// Firma y verificación
// Datos a firmar
const verifiableData = "Hola mundo";

// Se genera la firma de los datos
const signature = crypto.sign("sha256", Buffer.from(verifiableData), {
    key: privateKey,
    padding: crypto.constants.RSA_PKCS1_PSS_PADDING,
});

console.log('La firma de:\n' + verifiableData + "\nes:\n" +
    signature.toString("base64"));

// Se verifica la firma de los datos:
const isVerified = crypto.verify(
    "sha256",
    Buffer.from(verifiableData),
    {
        key: publicKey,
        padding: crypto.constants.RSA_PKCS1_PSS_PADDING,
    },
    signature
);

// Si isVerified es 'true', los datos no han sido modificados
console.log("\nFirma válida: " + isVerified);
