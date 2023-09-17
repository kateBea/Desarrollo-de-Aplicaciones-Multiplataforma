/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound]
 * @param lowerBound límite inferior
 * @param upperBound límite superior
 * @returns número aleatorio
 * */
function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function getParidadStr(numero) {
    if (numero % 2 == 0) { return 'par ' }

    return 'impar'
}

const numero = getRandomInt(-100000, 100000)
console.log('El número ' + numero + ' es ' + getParidadStr(numero))