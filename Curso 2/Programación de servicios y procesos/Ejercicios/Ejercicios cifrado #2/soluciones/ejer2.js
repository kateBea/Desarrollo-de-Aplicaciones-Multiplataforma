const crypto = require("crypto");
const fs = require("fs");

const archivoClavePublica = process.argv[2];
const archivo = process.argv[3];
const archivoSalida = process.argv[4];

const publicKey = fs.readFileSync(archivoClavePublica, 'utf-8');

const data = fs.readFileSync(archivo, 'utf-8');

const encryptedData = crypto.publicEncrypt(
  {
    key: publicKey,
    padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
    oaepHash: "sha256",
  },
  Buffer.from(data)
);

fs.writeFileSync(archivoSalida, encryptedData.toString("base64"), 'utf-8');
