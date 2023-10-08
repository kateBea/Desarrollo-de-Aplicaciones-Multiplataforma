const casillaResultadoId = "casilla-resultado";
const clear = "CE";
const equals = "=";

var displayExpression = ''; // Cadena de caracteres que contiene la operación completa, se muestra por la casilla resultado con formato de presentación amigable
var computeExpression = ''; // Cadena de caracteres que contiene la operación completa, es más amigable para evaluar
var contadorTokens = 0;   // Número de tokens
const maxTokens = 20;

function mostrarExpresion(valor) {
    document.getElementById(casillaResultadoId).value = valor;
}

function isOperand(character) {
    return character === "+" || character === "-" || character === "*" || character === "÷";
}

function dispatchValue(value) {
    // Logging 
    console.log("Click botón: " + value);

    if (value === clear) {
        displayExpression = "";
        computeExpression = "";
        contadorTokens = 0;
        mostrarExpresion(displayExpression)
    }
    else if (value === equals) {
        console.log("Evaluación de: '" + computeExpression + "'");
        let resultadoExpresion = eval(computeExpression.trim());
        mostrarExpresion(resultadoExpresion); 
    }
    else if (contadorTokens < maxTokens) {
        displayExpression = displayExpression + (isOperand(value) ? (" " + value + " ") : value);
        computeExpression = computeExpression + value;
        contadorTokens += 1;
        mostrarExpresion(displayExpression)
    }

    console.log("Valor pasado es: " + value);
    console.log("Valor de expresión actual es: " + displayExpression);
    console.log("Valor de expresión a calcular actual es: " + computeExpression);
}

