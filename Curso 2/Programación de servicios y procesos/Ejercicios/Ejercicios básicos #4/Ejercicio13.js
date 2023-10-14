// Es modulo de JS para hashear cadenas

var fs = require('fs');
var md5 = require('md5');
 
fs.readFile('datos.txt', function(err, buf) {
    console.log(md5(buf));
});