const fs = require('fs');
const file = 'datos.txt';

fs.writeFile(file, 'Hola mundo', (err) => { 
    if (err) {
        throw err;
    }

    console.log('Escritura asíncrona exitosa');

    fs.readFile(file, 'utf8', (err, data) => {
        if (err) {
            throw err;
        }
    
        console.log('Lectura asíncrona exitosa' + '\n' + data);
    });
});