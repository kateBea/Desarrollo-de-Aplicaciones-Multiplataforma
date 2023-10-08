function suma(op1, op2) {
    return op1 + op2;
}

function resta(op1, op2) {
    return op1 - op2;
}

function multiplicacion(op1, op2) {
    return op1 * op2;
}

function division(op1, op2) {
    if (op2 == 0) { return null; }

    return op1 / op2;
}

exports.suma = suma;
exports.resta = resta;
exports.division = division;
exports.multiplicacion = multiplicacion;
