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
    return numero % 2 == 0
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
            acabado = true
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

/**
 * Crear una función que inicializa una variable con nombre alumno y que pueda ser nula.
 * Asignarle un valor string y imprimirlo. A continuación, asignar null y escribir
 * utilizando los operadores: "?.", "?:" y "!!."
 * */
fun basicEj4() {
    println("\nEjercicio básico 4:")

    var alumno: String? = "Juan"
    println("El valor es $alumno")


    alumno = null

    val nombre: String = alumno?: "Nombre por defecto"
    println(nombre)

    println("La longitud del string es ${nombre!!.length}")

}


/**
 * Lee entero de consola. Lo devuelve si es correcto, null
 * en caso contrario.
 * @returns entero leído de consola
 * */
fun leerEntero(): Int? {
    print("Introduce un entero: ")
    return readlnOrNull()?.toIntOrNull()
}

fun basicEj5() {
    println("\nEjercicio básico 5:")
    val valor = leerEntero()

    print("El valor introducido es $valor")
}

fun muchasCadenas(str1: String, str2: String, repeatCount: Int = 0): String {
    var result = str1 + str2
    for (counter in 1..repeatCount) {
        result = "$result $str1$str2"
    }

    return result
}

/**
 * Calcula la media de los elementos de una lista de enteros.
 * */
fun<T> media(vararg lista: T): Float {
    var adder = 0.0f

    for (element in lista) {
        if (element is Int) {
            adder += element
        }
    }

    return adder / lista.size.toFloat()
}

/**
 * Calcula la media de los elementos de una lista de enteros o reales.
 * */
fun<T> mediaIntOrDouble(vararg lista: T): Double {
    var adder = 0.0

    for (element in lista) {
        when (element) {
            is Int -> adder += element
            is Float -> adder += element
            is Double -> adder += element
        }
    }

    return adder / lista.size
}

/**
 * Imprime los elementos de una lista de manera formateada.
 * */
fun<T> toListString(lista: Array<T>): String {
    var result = "[ "
    var first = true

    for (element in lista) {
        if (first) {
            first = false
        }
        else {
            result += " "
        }

        result += element.toString()
    }

    result += " ]"
    return result
}

/**
 * Crear una función “muchasCadenas” que admite dos parámetros string de entrada y
 * un entro. La función crea un nuevo string con la primera cadena y la segunda
 * repetida tantas veces como indica el parámetro entero. Este parámetro entero debe
 * tener un valor por defecto de “1”. Probar la función invocando con y sin parámetro
 * por defecto y usando llamadas con parámetros con nombre.
 * */
fun funcionesEj1() {
    println("\nEjercicio funciones 1:")

    // Llamada con parámetro
    println(muchasCadenas("Juan", "Pedro", 4))
    // Llamada sin parámetro
    println(muchasCadenas("Juan", "Pedro"))
    // Llamada parámetros con nombre
    println(muchasCadenas(str2 = "Juan", str1 = "Pedro"))
}

/**
 * Crear una función que admite un número de parámetros variables y devuelve el
 * cálculo de la media aritmética. Incluir en las pruebas una llamada con un array.
 * */
fun funcionesEj2() {
    println("\nEjercicio funciones 2:")
    
    val lista = arrayOf(1, 2, 3, 4, 5)
    println("Lista ${ toListString(lista) }")
    println("Media ${ media(*lista) }")
}

/**
 * Helper para ejercicio funcionesEj3.
 * */
fun<T> mostrarConMedia(lista: Array<T>) {
    println("Lista ${ toListString(lista) }")
    println("Media ${ mediaIntOrDouble(*lista) }")
}

/**
 * Crear una función basada en el ejercicio anterior que esté parametrizada para
 * funcionar solamente con enteros y double.
 * */
fun funcionesEj3() {
    println("\nEjercicio funciones 3:")

    val listEnteros = arrayOf(1, 2, 3, 4, 5)
    val listFloats = arrayOf(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 7.0f)
    val listDoubles = arrayOf(1.0, 2.2, 3.44, 4.2, 5.44, 9.22)

    mostrarConMedia(listEnteros)
    mostrarConMedia(listFloats)
    mostrarConMedia(listDoubles)
}

fun lambdas1() {
    println("\nEjercicio lambdas 1:")
}

fun lambdas2() {
    println("\nEjercicio lambdas 2:")
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

    println("\nc. Ejercicios lambdas:")
    println("    1. Lambdas")
    println("    2. Transformer")

    println("\nd. Salir")
}

fun main(args: Array<String>) {
    var terminar = false

    val basics = arrayOf(Runnable { basicEj1() }, Runnable { basicEj2() }, Runnable { basicEj3() }, Runnable { basicEj4() }, Runnable { basicEj5() } )
    val functions = arrayOf(Runnable { funcionesEj1() }, Runnable { funcionesEj2() }, Runnable { funcionesEj3() })
    val lambdas = arrayOf(Runnable { lambdas1() }, Runnable { lambdas2() })

    while (!terminar) {
        mostrarMenu()

        print("\nEntre la sección que desea ejecutar: ")
        val section: String? = readlnOrNull()

        if (section != null) {
            if (section == "d") {
                terminar = true
            }
            else {
                // leer índice de ejercicio
                print("\nEntre el índice de ejercicio, por favor: ")
                val index = Integer.parseInt(readln())

                when (section) {
                    "a" -> basics[index - 1].run()
                    "b" -> functions[index - 1].run()
                    "c" -> lambdas[index - 1].run()
                }
            }
        }

        println()
    }

    println("Terminando...")
}
