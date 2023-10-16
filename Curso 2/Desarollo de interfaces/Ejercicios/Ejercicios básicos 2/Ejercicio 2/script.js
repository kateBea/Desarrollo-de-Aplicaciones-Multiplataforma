const numero = parseInt(prompt("Introduce un número entero por favor"))

function tablaMultiplicacion() {
    let resultado = 'Tabla de Multiplicación<br/>'

    for (let mult = 1; mult < 11; ++mult) {
        resultado = resultado + (mult + " * " + numero + " = " + (mult*numero)) + "<br/>";
    }

    document.getElementById("multiplicacion").innerHTML = resultado;
}

function tablaSuma() {
    let resultado = 'Tabla de Suma<br/>'

    for (let mult = 1; mult < 11; ++mult) {
        resultado = resultado + (mult + " + " + numero + " = " + (mult+numero)) + "<br/>";
    }

    document.getElementById("suma").innerHTML = resultado;
}

function tablaDivision() {
    let resultado = 'Tabla de División<br/>'

    for (let mult = 1; mult < 11; ++mult) {
        resultado = resultado + (mult + " / " + numero + " = " + (mult/numero).toFixed(2)) + "<br/>";
    }

    document.getElementById("division").innerHTML = resultado;
}

tablaMultiplicacion()
tablaSuma()
tablaDivision()