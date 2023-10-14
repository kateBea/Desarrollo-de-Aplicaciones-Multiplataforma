const fs = require('fs');
const file = 'datos.txt';

console.log(fs.readFileSync(file, 'utf8'));