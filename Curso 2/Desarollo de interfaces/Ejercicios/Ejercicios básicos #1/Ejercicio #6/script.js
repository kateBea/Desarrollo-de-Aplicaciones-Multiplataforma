var operando1 = undefined;  // String representando el primer operando
var operando2 = undefined;  // String representando el segundo operando
var operador = undefined;   // String representando el operador

var hayOperando1 = false;
var hayOperador = false;
var hayOperando2 = false;
var operacionCompletada = false;

function resetOperacion() {
    operando1 = undefined; 
    operando2 = undefined;  
    operador = undefined; 

    hayOperando1 = false;
    hayOperador = false;
    hayOperando2 = false;
    operacionCompletada = false;
}

function mostrarEnCasillaResultado() {    
    // No tenemos botón de clear por eso
    // reseteamos al hacer clic sobre cualquier botón 
    // cuando la operación ya se ha completado
    if (operacionCompletada) {
        document.getElementById("casilla-resultado").value = '';
        resetOperacion();
        return;
    }

    let casillaStr = operando1;

    if (operador != undefined) {
        casillaStr = casillaStr + ' ' + operador;
    }
    
    // Para poder leer segundo operando debe haver operador
    if (operando2 != undefined) {
        casillaStr = casillaStr + ' ' + operando2;
    }

    if (hayOperando1 && hayOperando2) {
        let resultado = 0;
        let num1 = parseInt(operando1);
        let num2 = parseInt(operando2);

        if (operador == '+') { resultado = parseInt(operando1) + parseInt(operando2); }
        if (operador == '-') { resultado = parseInt(operando1) - parseInt(operando2); }
        if (operador == '*') { resultado = parseInt(operando1) * parseInt(operando2); }
        if (operador == '÷') { resultado = parseFloat(operando1) / parseInt(operando2).toFixed(1); }
        
        casillaStr = casillaStr + ' = ' + resultado;

        operacionCompletada = true;
    }

    document.getElementById("casilla-resultado").value = casillaStr;
}

function digit0() { 
    console.log('click tecla 0...');

    if (!hayOperando1) {
        operando1 = document.getElementById("digit0").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit0").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit1() { 
    console.log('click tecla 1...');
    
    if (!hayOperando1) {
        operando1 = document.getElementById("digit1").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit1").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit2() { 
    console.log('click tecla 2...');

    if (!hayOperando1) {
        operando1 = document.getElementById("digit2").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit2").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit3() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit3").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit3").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit4() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit4").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit4").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit5() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit5").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit5").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit6() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit6").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit6").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit7() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit7").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit7").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit8() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit8").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit8").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function digit9() { 
    if (!hayOperando1) {
        operando1 = document.getElementById("digit9").value;
        hayOperando1 = true;
    }
    else if (!hayOperando2 && hayOperador) {
        operando2 = document.getElementById("digit9").value;
        hayOperando2 = true;
    }

    mostrarEnCasillaResultado();
}

function suma() { 
    if (!hayOperador) {
        operador = document.getElementById("operador-suma").value;
        hayOperador = true;
    }

    mostrarEnCasillaResultado();
}

function resta() { 
    if (!hayOperador) {
        operador = document.getElementById("operador-resta").value;
        hayOperador = true;
    }

    mostrarEnCasillaResultado();
}

function producto() { 
    if (!hayOperador) {
        operador = document.getElementById("operador-multiplicacion").value;
        hayOperador = true;
    }

    mostrarEnCasillaResultado();
}

function division() { 
    if (!hayOperador) {
        operador = document.getElementById("operador-division").value;
        hayOperador = true;
    }

    mostrarEnCasillaResultado();
}