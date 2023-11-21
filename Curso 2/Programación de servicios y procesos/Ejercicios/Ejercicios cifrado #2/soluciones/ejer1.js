const crypto = require("crypto");
const fs = require("fs");

//const { publicKey, privateKey } = crypto.generateKeyPairSync("rsa", {
//  // The standard secure default length for RSA keys is 2048 bits
//  modulusLength: 2048,
//});

const publicKey = fs.readFileSync('server.publica', 'utf-8');
const privateKey = fs.readFileSync('server.privada', 'utf-8');


const data = "Hola mundo";

const encryptedData = crypto.publicEncrypt(
  {
    key: publicKey,
    padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
    oaepHash: "sha256",
  },
  Buffer.from(data)
);

console.log("Texto cifrado: ", encryptedData.toString("base64"));

const decryptedData = crypto.privateDecrypt(
  {
    key: privateKey,
    padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
    oaepHash: "sha256",
  },
  encryptedData
);

console.log("Texto descifrado: ", decryptedData.toString());


// Firma y verificación

const verifiableData = "Datos a verificar";

const signature = crypto.sign("sha256", Buffer.from(verifiableData), {
  key: privateKey,
  padding: crypto.constants.RSA_PKCS1_PSS_PADDING,
});

console.log(signature.toString("base64"));

const isVerified = crypto.verify(
  "sha256",
  Buffer.from(verifiableData),
  {
    key: publicKey,
    padding: crypto.constants.RSA_PKCS1_PSS_PADDING,
  },
  signature
);

console.log("signature verified: ", isVerified);
