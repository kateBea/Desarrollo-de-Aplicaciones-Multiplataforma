package edu.villablanca.democorrutinas

/**
 * Función que realiza ciertos calculos pesados.
 * Ejemplo calcular numeros primos
 * @param: numMayor: comprobar desde 2l número 2 hasta numMayor
 */
suspend fun FuncionIntensiva(numMayor: Int):String {
    val primos = mutableListOf<Int>()
    var numero = 2
    while (numero <= numMayor) {
        if (esPrimo(numero) && primos.size < 10) {  // en esta version solo mostramos los 10 primeros primos
            primos.add(numero)
        }
        numero++
    }

    return primos.toString()
}


/**
 * Algorítmo de fuerza bruta:
 * Se comprueba si es primo dividiendo por todos los números anteriores
 * @param n : número para comprobar
 */
suspend fun esPrimo(num: Int): Boolean {
    if (num <= 1) return false

    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}


