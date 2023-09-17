function esUltimoAnioDeSiglo(anio) {
    return anio % 100 == 0
}

function esBisiestoStr(anio) {
    let esBisiesto = false
    if (anio >= 1582 && esUltimoAnioDeSiglo(anio)) {
        esBisiesto = anio % 400 == 0
    }
    else {
        esBisiesto = anio % 4 == 0
    }

    return esBisiesto ? 'bisiesto' : 'no bisiesto'
}

const year1 = 1988
const year2 = 2011
const year3 = 1700
const year4 = 1500
const year5 = 2400

console.log('El año ' + year1 + ' es ' + esBisiestoStr(year1))
console.log('El año ' + year2 + ' es ' + esBisiestoStr(year2))
console.log('El año ' + year3 + ' es ' + esBisiestoStr(year3))
console.log('El año ' + year4 + ' es ' + esBisiestoStr(year4))
console.log('El año ' + year5 + ' es ' + esBisiestoStr(year5))

