function getRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}

function sumaEntre(limiteInf, limiteSup) {
    if (limiteSup < limiteInf)
        sumaEntre(limiteSup, limiteInf)

    let suma = 0
    let operandos = ''
    for (let count = limiteInf + 1; count < limiteSup; ++count) {
        operandos = operandos + count
        suma += count

        if (count != limiteSup - 1)
            operandos += ' + '
    }

    
    console.log(operandos + ' = ' + suma)
}

sumaEntre(getRandomInt(0, 55), getRandomInt(0, 55))