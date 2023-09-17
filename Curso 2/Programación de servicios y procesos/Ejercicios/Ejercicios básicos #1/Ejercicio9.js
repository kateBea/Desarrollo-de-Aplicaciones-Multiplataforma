function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function potenciasDeDos(limite) {
    for (let exponente = 0; exponente <= limite; ++exponente)
        console.log('Potencia de 2 ' + exponente + '-ésima: ' + Math.pow(2, exponente))
}

potenciasDeDos(getRandomInt(0, 50))