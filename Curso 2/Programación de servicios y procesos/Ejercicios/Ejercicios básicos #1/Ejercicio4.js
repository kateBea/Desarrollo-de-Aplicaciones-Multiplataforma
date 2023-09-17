/**
 * Calcula el IMC de una persona
 * @param peso peso del usuario/a en kilogramos
 * @param altura altura del usuario/a en centímetros
 * @returns imc
 * */
function getIMC(peso, altura) {
    const METROS_POR_CENTIMETRO = 0.01
    return peso / Math.pow((METROS_POR_CENTIMETRO * altura), 2)
}

/**
 * Devuelve un string que representa el nivel 
 * de peso acorde al IMC que se pasa
 * @param imc imc del individuo
 * @returns string que representa el nivel de peso
 * */
function getNivelDeImc(imc) {
    if (imc < 0 || isNaN(imc) || imc == null || imc === undefined) {
        return 'Rango inválido'
    }

    // NOTE: direct comparison with floats is dodgy. See Ejercicio3.js
    if (imc < 18.5) return 'Bajo peso'
    if (imc < 25.0) return 'Peso Normal'
    if (imc < 30.0) return 'Sobrepeso'
    
    return 'Obesidad'
}

// Cambiar a gusto. Peso en kilogramos y altura en centímetros
const pesoUsuario = 78.44;
const alturaUsuario = 182;  
const imc = getIMC(pesoUsuario, alturaUsuario)

console.log('Persona con IMC de ' + imc.toFixed(2) + ' tiene ' + getNivelDeImc(imc))