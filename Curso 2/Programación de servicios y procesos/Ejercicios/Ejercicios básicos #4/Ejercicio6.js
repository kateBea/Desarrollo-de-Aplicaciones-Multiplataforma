const fs = require('fs');
const file = 'datos.txt';


fs.readFile(file, 'utf8',
    (err, data) => {
        if (err) {
            throw err;
        } 

        console.log(data);
    }
);