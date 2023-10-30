/**
 * Proyecto Maven conteniendo la lista de ejercicios de la carpeta
 * ejercicios_kotlin_1. El proyecto fue realizado con IntelliJ IDEA
 * Ultimate usando el JDK 19. Abrir carpeta Ejercicios_Kotlin1 para ejecutar
 * el programa.
 *
 * @author Hugo Pelayo
 * @date 30 de octubre de 2023
 * */

/** Imports */
import java.util.Random


/**
 * Adivinar el número. Se prepara un número oculto y se pide por consola al usuario
 * que lo adivine. El programa indica que el número del usuario es mayor, menor o bien
 * que es el número oculto.
 * */
fun basicEj1() {
    println("\nEjercicio básico 1:")

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


/**
 * Paridad.
 * @returns Retorna cierto si el número es par.
 * */
fun esPar(numero: Int): Boolean {
    return numero % 2 == 0;
}


/**
 * Imprimir los diez primeros números impares.
 * */
fun basicEj2() {
    println("\nEjercicio básico 2:")

    var controlador = 10
    var numero = 1
    var acabado = false

    while (!acabado) {
        if (!esPar(numero)) {
            println("Encontrado número par $numero")
            --controlador
        }

        ++numero

        if (controlador == 0) {
            acabado = true;
        }
    }

}


/**
 * Imprimir medio triángulo con "*". Pedir por consola el número de filas
 * */
fun basicEj3() {
    println("\nEjercicio básico 3:")
    print("Entra un entero positivo para el tamaño del triángulo rectángulo: ")
    val size = Integer.parseInt(readln())

    for (rowL in 0..size + 1) {
        for (col in 0..rowL) {
            print("*")
        }

        print('\n')
    }
}

fun basicEj4() {
    println("\nEjercicio básico 4:")
}

fun basicEj5() {
    println("\nEjercicio básico 5:")
}

fun funcionesEj1() {
    println("\nEjercicio funciones 1:")
}

fun funcionesEj2() {
    println("\nEjercicio funciones 2:")
}

fun funcionesEj3() {
    println("\nEjercicio funciones 3:")
}

fun mostrarMenu() {
    println("a. Ejercicios básicos:")
    println("    1. Adivinar el número")
    println("    2. Diez primeros números")
    println("    3. Triángulo")
    println("    4. Nullable")
    println("    5. Lectura")

    println("\nb. Ejercicios funciones:")
    println("    1. Cadenas")
    println("    2. Media aritmética")
    println("    3. Media aritmética alt.")

    println("\nc. Salir")
}

fun main(args: Array<String>) {
    var terminar = false

    while (!terminar) {
        mostrarMenu()

        // leer sección
        print("\nEntre la sección que desea ejecutar: ")
        val section = readln();

        if (section == "c") {
            terminar = true;
        }
        else {
            // leer índice de ejercicio
            print("\nEntre el índice de ejercicio, por favor: ")
            val index = Integer.parseInt(readln())

            if (section == "a") {
                when (index) {
                    1 -> basicEj1()
                    2 -> basicEj2()
                    3 -> basicEj3()
                    4 -> basicEj4()
                    5 -> basicEj5()
                }
            }
            else if (section == "b") {
                when (index) {
                    1 -> funcionesEj1()
                    2 -> funcionesEj2()
                    3 -> funcionesEj3()
                }
            }
        }

        println()
    }

    println("Terminando...")
}