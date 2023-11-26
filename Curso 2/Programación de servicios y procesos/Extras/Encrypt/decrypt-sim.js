const crypto = require("crypto");
const algorithm = "aes-192-cbc";

// El descifrado se podría realizar con:

function decrypt(encrypted, password, iv, func) {
    // Genera la clave de cifrado usando el secreto.
    crypto.scrypt(password, 'salt', 24, (err, key) => {
        if (err) throw err;
        // Crea un objeto decipher
        const decipher = crypto.createDecipheriv(algorithm, key, iv);
        let decrypted = '';
        decipher.on('readable', () => {
            let chunk;
            while (null !== (chunk = decipher.read())) {
                decrypted += chunk.toString('utf8');
            }
        });
        decipher.on('end', () => func(null, decrypted));
        decipher.on('error', (err) => func(err, null));
        decipher.write(encrypted, 'hex');
        decipher.end();
    });
}

const password = 'contraseña';
const iv = 'ABCDEFGHIJKLMNOP';
const cifrado = 'b7a50483519f701c533498605c38b4df';

decrypt(cifrado, password, iv, (err, valor) => {
    if (err) console.log(err);
    console.log(valor);
});
