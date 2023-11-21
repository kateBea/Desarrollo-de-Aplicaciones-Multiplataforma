const crypto = require("crypto");
const fs = require('fs');

const algorithm = "aes-192-cbc";

function encrypt(text, password, iv, func) {
  //generate encryption key using the secret.
  crypto.scrypt(password, 'salt', 24, (err, key) => {
    if (err) throw err;

    const cipher = crypto.createCipheriv(algorithm, key, iv);

    let encrypted = '';
    cipher.setEncoding('hex');
    cipher.on('data', (chunk) => encrypted += chunk);
    cipher.on('end', () => func(null, encrypted))
    cipher.on('error', (err) => func(err, null))

    cipher.write(text);
    cipher.end();
  });
}

const password = process.argv[2];
const archivo = process.argv[3];
const texto_a_cifrar = fs.readFileSync(archivo, 'utf-8');
const iv = 'ABCDEFGHIJKLMNOP';

encrypt(texto_a_cifrar, password, iv, (err,cifrado) => {
  if(err) console.log(err);
  fs.writeFileSync(archivo + '.cifrado', cifrado, 'utf-8');
  console.log('Archivo cifrado: ' + archivo + '.cifrado')
});
