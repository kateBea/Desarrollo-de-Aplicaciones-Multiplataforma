/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound]
 * @param lowerBound límite inferior
 * @param upperBound límite superior
 * @returns número aleatorio
 * */
function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

for (let count = 0; count < 5; ++count) {
    console.log('Un número mágico: ' + getRandomInt(1, 10))
}