function repeatStr(str, count) {
    let result = ''
    for (let i = 0; i < count; ++i)
        result = result.concat(str)

    return result;
} 

function dibujarTriangulo(filas, invertido) {
    if (invertido) {
        for (let i = filas - 1; i >= 0; --i) {
            let espacios = repeatStr(' ', filas - (i + 1))
            let asteriscos = repeatStr('*', 2 * (i + 1) - 1) 
            console.log(espacios + asteriscos)
        }
    }
    else {
        for (let i = 0; i < filas; ++i) {
            let espacios = repeatStr(' ', filas - (i + 1))
            let asteriscos = repeatStr('*', 2 * (i + 1) - 1) 
            console.log(espacios + asteriscos)
        }
    }
}

function dibujarRectangulo(base, altura) {
    for (let i = 0; i < altura; ++i)
        console.log(repeatStr('*', base))
}

function dibujarHexagono(lado) {
    let filas = lado
    let base = 2 * lado - 1
    let altura = lado - 2

    dibujarTriangulo(filas, false)
    dibujarRectangulo(base, altura)
    dibujarTriangulo(filas, true) 
}

const lado = 4
console.log('Hexágono de lado ' + lado + ':\n')
dibujarHexagono(lado)