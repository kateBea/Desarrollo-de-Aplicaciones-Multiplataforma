const crypto = require("crypto");
const fs = require('fs');

const algorithm = "aes-192-cbc";

function decrypt(encrypted, password, iv, func) {
  //generate encryption key using secret
  crypto.scrypt(password, 'salt', 24, (err, key) => {
    if (err) throw err;

    //create decipher object
    const decipher = crypto.createDecipheriv(algorithm, key, iv);

    let decrypted = '';
    decipher.on('readable', () => {
      while (null !== (chunk = decipher.read())) {
        decrypted += chunk.toString('utf8');
      }
    });
    decipher.on('end', () => func(null, decrypted));
    decipher.on('error', (err) => func(err, null))

    decipher.write(encrypted, 'hex');
    decipher.end();
  })
}

const iv = 'ABCDEFGHIJKLMNOP';
const archivo = process.argv[3];
const cifrado = fs.readFileSync(archivo, 'utf-8');
const password = process.argv[2];
const archivo_salida = process.argv[4];
decrypt(cifrado, password, iv, (err, valor) => {
  if(err) console.log(err);
  fs.writeFileSync(archivo_salida, valor, 'utf-8');
  console.log('Archivo guardado en: ' + archivo_salida)
})
