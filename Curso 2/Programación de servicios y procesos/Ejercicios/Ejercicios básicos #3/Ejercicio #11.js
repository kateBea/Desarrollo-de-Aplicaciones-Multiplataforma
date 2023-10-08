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
    let lista = new Map();

    lista.set("Daniel Rodríguez", generarNumeroTelf());
    lista.set("Paule Gómez", generarNumeroTelf());
    lista.set("Carla Carrasco", generarNumeroTelf());
    lista.set("Guillermo López", generarNumeroTelf());
    lista.set("Jose", generarNumeroTelf());
    lista.set("Carlos Preto", generarNumeroTelf());

    if (lista.has(process.argv[2])) {
        console.log("El número asociado a " + process.argv[2] + " es " + lista.get(process.argv[2]));
    } else {
        console.log("No existe número asociado a " + process.argv[2]);
    }

    
}

tests()