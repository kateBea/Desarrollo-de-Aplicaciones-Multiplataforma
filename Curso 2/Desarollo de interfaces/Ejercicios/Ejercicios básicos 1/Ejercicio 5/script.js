function factorialRecursivo(numero) {
    return numero <= 0 ? 1 : numero * factorialRecursivo(numero - 1);
}

function factorialIterativo(numero) {
    let resultado = 1;

    for (let multiplicador = 1; multiplicador <= numero; ++multiplicador) {
        resultado = multiplicador * resultado;
    }

    return resultado;
}

const num = parseInt(prompt("Introduce un número entre el 1 y el 100"));
document.write("<p>El factorial de " + num + " es " + factorialRecursivo(num) + "</p>");
document.close();