const fs = require('fs');
const fichero = 'datos.txt';

for (let count = 0; count < 100; ++count) {
    fs.appendFile(fichero, (count + 1) + ' ', 'utf-8', 
        (err) => 
        {
            if (err) {
                throw err;
            }
        }
    );
}

fs.appendFile(fichero, '\n', 'utf-8', 
    (err) => 
    {
        if (err) {
            throw err;
        }

        console.log("El archivo " + fichero + " se ha guardado correctamente");
    }
);