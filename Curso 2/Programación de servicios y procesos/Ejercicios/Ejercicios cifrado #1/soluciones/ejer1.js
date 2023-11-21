'use strict'
const crypto = require('node:crypto')
const fs = require('fs')
const hashFunc = crypto.createHash('md5')
if(process.argv.length == 3) {
  const texto = fs.readFileSync(process.argv[2], "utf-8");
  hashFunc.update(texto)
  console.log('El código hash es:')
  console.log(hashFunc.digest('hex'))
}
