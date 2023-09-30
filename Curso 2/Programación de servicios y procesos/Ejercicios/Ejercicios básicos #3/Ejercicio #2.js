const MODULO_EJERCICIO1 = "./Ejercicio #1.js";
const ejercicio1 = require(MODULO_EJERCICIO1);

/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound]
 * @param lowerBound límite inferior
 * @param upperBound límite superior
 * @returns número aleatorio
 * */
function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function generarDNIAleatorio() {
    let result = '';
    const totalDigitosDNI = 8;
    const letraAleatoria = ejercicio1.LETRAS_DNI[getRandomInt(0, ejercicio1.LETRAS_DNI.length - 1)];

    for (let i = 0; i < totalDigitosDNI; ++i) { result = result + getRandomInt(0, 9); }

    result = result + letraAleatoria;

    return result;
}

function tests() {
    const limiteCasos = 5;

    for (let i = 0; i < limiteCasos; ++i) {
        const dni = generarDNIAleatorio();
        const letraDni = dni.charAt(dni.length - 1);

        console.log("Corresponde letra " + letraDni + " a DNI " + dni + "? " + ejercicio1.esDNI(dni, letraDni));
    }
}

tests();