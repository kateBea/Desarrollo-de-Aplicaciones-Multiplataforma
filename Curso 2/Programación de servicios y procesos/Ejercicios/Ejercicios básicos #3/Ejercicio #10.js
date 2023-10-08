/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound]
 * @param lowerBound límite inferior
 * @param upperBound límite superior
 * @returns número aleatorio
 * */
function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function generarNumeroTelf() {
    let str = ''

    str += getRandomInt(6, 7);
    str += getRandomInt(0, 9);
    str += getRandomInt(0, 9);

    str += ' '

    str += getRandomInt(0, 9);
    str += getRandomInt(0, 9);

    str += ' '

    str += getRandomInt(0, 9);
    str += getRandomInt(0, 9);

    str += ' '

    str += getRandomInt(0, 9);
    str += getRandomInt(0, 9);

    return str;
}

function tests() {
    let lista = []

    for (let count = 0; count < 7; ++count) {
        lista.push(generarNumeroTelf());
    }

    for (let count = 0; count < 7; ++count) {
        console.log(lista[count]);
    }
}

tests()

