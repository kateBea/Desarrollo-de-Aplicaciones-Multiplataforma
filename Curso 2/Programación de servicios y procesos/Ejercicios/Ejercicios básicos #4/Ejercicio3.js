const fs = require('fs');

for (let count = 0; count < 100; ++count) {
    try {
        fs.appendFileSync('datos.txt', (count + 1) + ' ', 'utf8');
    } catch (err) {
        console.log("Error al escribir el archivo datos.txt");
    }
}

try {
    fs.appendFileSync('datos.txt', '\n', 'utf8');
} catch (err) {
    console.log("Error al escribir el archivo datos.txt");
}
