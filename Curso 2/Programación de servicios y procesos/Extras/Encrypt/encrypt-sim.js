const crypto = require("crypto");
const algorithm = "aes-192-cbc";

function encrypt(text, password, iv, func) {
    // Genera la clave de cifrado usando el secreto.
    crypto.scrypt(password, 'salt', 24, (err, key) => {
        if (err) throw err;
        const cipher = crypto.createCipheriv(algorithm, key, iv);
        let encrypted = '';
        cipher.setEncoding('hex');
        cipher.on('data', (chunk) => encrypted += chunk);
        cipher.on('end', () => func(null, encrypted));
        cipher.on('error', (err) => func(err, null));
        cipher.write(text);
        cipher.end();
    });
}

const texto_a_cifrar = 'hello World';
const password = 'contraseña';
const iv = 'ABCDEFGHIJKLMNOP';

// En criptografía, un vector de inicialización (conocido por sus siglas en
// inglés IV) es un bloque de bits que es requerido para permitir un cifrado en
// flujo o un cifrado por bloques, en uno de los modos de cifrado, con un
// resultado independiente de otros cifrados producidos por la misma clave.

encrypt(texto_a_cifrar, password, iv, (err, cifrado) => {
    if (err) console.log(err);
    console.log(cifrado);
});