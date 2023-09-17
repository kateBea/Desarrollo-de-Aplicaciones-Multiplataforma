function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function dibujarTrianguloRectangulo(altura) {
    for (let fila = 0; fila < altura; ++fila) {
        let str = ''
        for (let columna = 0; columna < fila + 1; ++columna) {
            str = str + '*'
        }

        console.log(str)
    }
}

dibujarTrianguloRectangulo(getRandomInt(5, 15))