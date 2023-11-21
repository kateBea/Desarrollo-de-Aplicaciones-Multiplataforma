'use strict'
const crypto = require("crypto");
const fs = require("fs");

const clavePrivada = process.argv[2];
const archivo = process.argv[3];
const archivoSalida = process.argv[4];

const privateKey = fs.readFileSync(clavePrivada, 'utf-8');

// Se leen los datos y se transforman en Buffer
const encryptedData = Buffer.from(fs.readFileSync(archivo, 'utf-8'), 'base64');

const decryptedData = crypto.privateDecrypt(
  {
    key: privateKey,
    padding: crypto.constants.RSA_PKCS1_OAEP_PADDING,
    oaepHash: "sha256",
  },
  encryptedData
);

fs.writeFileSync(archivoSalida, decryptedData.toString(), 'utf-8');

