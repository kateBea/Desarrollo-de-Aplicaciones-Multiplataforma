/**
 * Adivina un número generado al azar
 * @author Hugo Pelayo
 * */

import java.util.Random

fun main() {
    val rand = Random()
    val getRandom = { a: Int, b: Int -> rand.nextInt() % b + a }
    val maxIntentos = 5

    val numeroAleatorio: Int = getRandom(1, 100)

    var finalizado = false
    var intentos = 0
    var numeroIntroducido: Int

    while (!finalizado && intentos < maxIntentos) {
        print("Introduce un número: ")
        numeroIntroducido = Integer.parseInt(readln())

        if (numeroIntroducido > numeroAleatorio) {
            println("¡El número introducido es grande!")
        }
        else if (numeroIntroducido < numeroAleatorio) {
            println("¡El número introducido es pequeño!")
        }
        else {
            finalizado = true
        }

        ++intentos
    }

    if (finalizado) {
        println("¡Felicidades has adivinado el número!")
    }
    else {
        println("¡Que mal, no has adivinado el número :'( ... el número secreto era ${numeroAleatorio}!")
    }
}