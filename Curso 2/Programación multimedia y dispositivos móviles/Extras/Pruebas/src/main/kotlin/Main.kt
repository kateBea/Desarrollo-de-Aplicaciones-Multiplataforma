fun factorialRecursivo(num: Int): Int = if (num <= 0) 1 else factorialRecursivo(num - 1 ) * num

fun factorialIterativo(num: Int): Int {
    var result = 1

    for (value in num downTo 1) {
        result *= value
    }

    return result
}

operator fun Int.times(str: String) = str.repeat(this)
operator fun String.get(range: IntRange) = substring(range)

class Persona (nombre: String) {
    var nombre: String = "Unknown"

    init {
        this.nombre = nombre
    }

    infix fun ConcatenarNombreCon(valor: String):Persona {
        this.nombre += " $valor"
        return this
    }

    override fun toString(): String {
        return "Nombre: ${this.nombre}"
    }
}

fun main(args: Array<String>) {
    println(args)

    for (elem in 1..10) {
        println(elem)
    }

    println(factorialRecursivo(5))
    println(factorialIterativo(5))

    println(2 * "Bye ")

    val str = "Always forgive your enemies, nothing annoys them so much."
    println(str[0..14])

    val p1 = Persona("Pedro") ConcatenarNombreCon "destruir"
    println(p1)
}