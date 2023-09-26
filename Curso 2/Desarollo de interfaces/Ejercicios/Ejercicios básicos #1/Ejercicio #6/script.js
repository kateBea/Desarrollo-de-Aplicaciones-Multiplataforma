const casillaResultadoId = "casilla-resultado";

var expresion = ''; // Cadena de caracteres que contiene la operación completa
var contadorTokens = 0;   // Número de tokens
const maxTokens = 21;

function mostrarExpresion() {
    document.getElementById(casillaResultadoId).value = expresion;
}

function dispatchValue(value) {
    if (contadorTokens == maxTokens) {
        return;
    }

    expresion = expresion + " " + value;
    contadorTokens += 1;

    console.log("Valor pasado es: " + value);
    console.log("Valor de expresión actual es: " + expresion);
    mostrarExpresion(); 
}

