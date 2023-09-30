function tests() {
    let op1 = parseInt(process.argv[2]);
    let op2 = parseInt(process.argv[4]);
    let op = process.argv[3].trim();

    let resultado = 0;
    let opValida = true;
    let isOperand = '+-*/'.includes(op);

    if (isOperand) {

        switch (op) {
            case '+':
                resultado = op1 + op2;
                break;
            case '-':
                resultado = op1 - op2;
                break;
            case '*':
                resultado = op1 * op2;
                break;
            case '/':
                if (op2 == 0) {
                    opValida = false;
                } else { 
                    resultado = op1 / op2;
                }
                break;
            default:
                break;
        }
    } else {
        opValida = false;
    }

    if (opValida)
        console.log("El resultado de la operación es: " + resultado);
    else 
        console.log("Operación inválida");
}

tests()