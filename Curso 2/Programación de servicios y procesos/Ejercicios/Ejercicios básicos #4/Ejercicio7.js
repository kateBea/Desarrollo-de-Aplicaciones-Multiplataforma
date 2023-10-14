const fs = require('fs');
const file = 'datos.txt';

try {
    fs.writeFileSync('datos.txt', 'Hola mundo', 'utf8');
} catch (err) {
    console.log("Error al escribir el archivo datos.txt");
}

console.log(fs.readFileSync(file, 'utf8'));
