function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

/**
 * Cierto si el primer parametro es divisible por el segundo
 * */
function esDivisiblePor(num1, num2) {
    return num1 % num2 == 0
}

function mostrarDivisores(numero) {
    let str = ''

    for (let count = 1; count * count <= numero; ++count) {
        if (esDivisiblePor(numero, count)) {
            str = str + count + ' '
        }
    }

    console.log('Divisores de ' + numero)
    console.log(str)
}

const numero = getRandomInt(0, 500);
mostrarDivisores(numero)