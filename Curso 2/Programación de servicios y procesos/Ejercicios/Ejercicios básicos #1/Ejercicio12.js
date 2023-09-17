function dibujarRectangulo(base, altura) {
    for (let fila = 0; fila < altura; ++fila) {
        let str = ''
        for (let columna = 0; columna < base; ++columna) {
            str = str + '*'
        }

        console.log(str)
    }
}

const base = 5
const altura = 3

dibujarRectangulo(base, altura)