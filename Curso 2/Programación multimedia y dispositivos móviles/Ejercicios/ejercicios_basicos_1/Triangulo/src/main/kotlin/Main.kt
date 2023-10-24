/**
 * Muestra un triángulo rectángulo por la consola
 * @author Hugo Pelayo
 * */

fun main() {
    println("Ejercicio 2:")

    for (rowL in 0..5) {
        for (col in 0..rowL) {
            print("*")
        }

        print('\n')
    }
}