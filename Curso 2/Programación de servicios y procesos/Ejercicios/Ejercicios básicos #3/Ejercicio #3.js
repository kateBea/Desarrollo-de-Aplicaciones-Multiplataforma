const MODULO_EJERCICIO1 = "./Ejercicio #1.js";
const ejercicio1 = require(MODULO_EJERCICIO1);

const LETRAS_NIE = Array.from("XYZ");

/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound]
 * @param lowerBound límite inferior
 * @param upperBound límite superior
 * @returns número aleatorio
 * */
function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function generarNIEAleatorio() {
    let result = '';
    const totalDigitosNIE = 7;
    const letraInicio = LETRAS_NIE[getRandomInt(0, LETRAS_NIE.length - 1)];
    const letraFin = ejercicio1.LETRAS_DNI[getRandomInt(0, ejercicio1.LETRAS_DNI.length - 1)];

    for (let i = 0; i < totalDigitosNIE; ++i) { result = result + getRandomInt(0, 9); }

    result = result + letraFin;
    result = letraInicio + result

    return result;
}

function esNIE(nie, letraInicio, letraFin) {
    if (letraInicio.length != 1 || letraFin.length != 1) {
        console.log("Uno de los strings no es una letra");
        return false;
    }

    let numeroNIE = parseInt(nie.substring(1, nie.length - 1));

    // No se hace control de errores, se asume que empieza por X, Y, Z
    if (nie.startsWith("Y")) { numeroNIE += 10000000; }
    else if (nie.startsWith("Z")) { numeroNIE += 20000000; }

    console.log("\nNIE: " + nie);
    console.log("Letras pasadas (inicio, fin): " + letraInicio + letraFin)
    console.log("Número de NIE parseado: " + numeroNIE);
    console.log("Letra de DNI que corresponde: " + ejercicio1.LETRAS_DNI[(numeroNIE % 23)]);
    console.log("----------------------------------"); 

    return ejercicio1.LETRAS_DNI[(numeroNIE % 23)] == letraFin; 
}

function tests() {
    const limiteTests = 5;

    for (let i = 0; i < limiteTests; ++i) {
        const nie = generarNIEAleatorio();
        const letraIni = LETRAS_NIE[getRandomInt(0, 2)];
        const letraFin = ejercicio1.LETRAS_DNI[getRandomInt(0, ejercicio1.LETRAS_DNI.length - 1)];

        console.log("Es NIE: " + esNIE(nie, letraIni, letraFin));

    }
}

tests()