function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function tabladeMultiplicarDe(numero) {
    for (let count = 0; count < 10; ++count)
        console.log(count + ' * ' + numero + ' = ' + (count * numero))
}

const numero = getRandomInt(1, 15)
tabladeMultiplicarDe(numero)