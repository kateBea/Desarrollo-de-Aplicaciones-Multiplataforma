function getDecimalPart(realNumber) {
    return realNumber - parseInt(realNumber)
}

function getWholePart(realNumber) {
    return parseInt(realNumber)
}

const real = 23.44

console.log('Parte decimal de ' + real + ' = ' + getDecimalPart(real))
console.log('Parte entera de ' + real + ' = ' + getWholePart(real))