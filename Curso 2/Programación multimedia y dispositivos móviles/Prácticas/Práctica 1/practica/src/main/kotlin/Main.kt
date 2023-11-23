/******************************************************************
 * Práctica KOTLIN
 *
 * @author Hugo Pelayo (Segundo DAM)
 * @version 1.0.0
 * ****************************************************************/

import java.util.*
import java.time.LocalDate
import kotlin.random.Random

const val PARTE_1 = "a"
const val PARTE_2 = "b"
const val SALIR = "c"

const val SOBREPESO = 1
const val NO_IDEAL = -1
const val IDEAL = 0
const val DESCONOCIDO = -2

const val MAYOR_DE_EDAD = 18

const val CM_A_M = 0.01f


/**
 * Enumerado de sexo
 * */
enum class Sexo { HOMBRE, MUJER }

/**
 * Enumerado de departamentos
 * */
enum class Departamento { CONTABILIDAD, RRHH, VENTAS, ALMACEN }

/**
 * Clase base Persona
 * */
open class Persona(
    edad: Int = 0,
    nombre: String = "",
    sexo: String = "",
    peso: Float = 0.0f,
    altura: Float = 0.0f,
    dni: String = GenerarDNI(),
) {
    var edad: Int? = null
        set(edad) {
            field = 0.coerceAtLeast(edad ?: 0)
        }
    var nombre: String? = null
    var sexo: Sexo? = null
    var peso: Float? = null
        set(peso) {
            field = 0.0f.coerceAtLeast(peso ?: 0.0f)
        }
    var altura: Float? = null
        set(altura) {
            field = 0.0f.coerceAtLeast(altura ?: 0.0f)
        }
    var dni: String? = null

    init {
        this.nombre = nombre
        this.dni = dni

        // validaciones
        this.edad = edad.coerceAtLeast(0)
        this.peso = peso.coerceAtLeast(0.0f)
        this.altura = altura.coerceAtLeast(0.0f)

        ComprobarSexo(sexo)
    }

    fun CalcularImc(): Int {
        val alturaM: Float = altura?.times(CM_A_M) ?: 0.0f
        val imc = peso?.div((alturaM * alturaM))

        return if (imc != null) {
            when {
                imc < 20 -> NO_IDEAL
                imc in 20.0..25.0 -> IDEAL
                else -> SOBREPESO
            }
        } else {
            DESCONOCIDO
        }

    }

    companion object {
        // Este objeto forma parte de la clase,
        // no se requerirá una instancia para su uso
        fun GenerarDNI(): String {
            val dniNumero = Random.nextInt(10000000, 99999999)
            val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
            val letra = letras[dniNumero % 23]
            return "$dniNumero$letra"
        }
    }

    fun EsMayorDeEdad(): Boolean {
        return if (edad != null) {
            MAYOR_DE_EDAD <= edad!!
        } else {
            false
        }
    }

    private fun CalcularIMC(): Int {
        return if (altura != null) {
            val targetAltura = altura?: 1.0f
            val imc: Float? = peso?.div((targetAltura * targetAltura))

            val imcCmp = imc?: 0.0f

            when {
                imcCmp < 20 -> NO_IDEAL
                imcCmp in 20.0..25.0 -> IDEAL
                else -> SOBREPESO
            }
        } else {
            DESCONOCIDO
        }
    }

    private fun ComprobarSexo(sexo: String) {
        val target = sexo.uppercase(Locale.getDefault())

        when(target) {
            "H" -> this.sexo = Sexo.HOMBRE
            "HOMBRE" -> this.sexo = Sexo.HOMBRE
            "M" -> this.sexo = Sexo.MUJER
            "MUJER" -> this.sexo = Sexo.MUJER
            else -> this.sexo = Sexo.HOMBRE
        }
    }

    override fun toString(): String {
        return "[ Nombre: $nombre, Edad: $edad, DNI: $dni, Sexo: $sexo, Peso: $peso, Altura: $altura ]"
    }
}

/**
 * Clase Empleado que hereda de Persona.
 * */
class Empleado(
    nombre: String,
    edad: Int,
    sexo: String,
    peso: Float,
    altura: Float,
    departamento: Departamento,
    sueldoBase: Double,
    alta: Int
) : Persona(edad, nombre, sexo, peso, altura) {
    var departamento: Departamento
    var sueldoBase: Double
    var anioAlta: Int

    init {
        this.departamento = departamento
        this.sueldoBase = sueldoBase
        this.anioAlta = alta
    }

    // Método para calcular el sueldo bruto
    fun SueldoBruto(extra: Float): Double {
        val aniosTrabajados = LocalDate.now().year - anioAlta
        var sueldo = sueldoBase + extra * aniosTrabajados

        if (departamento == Departamento.VENTAS) {
            sueldo += sueldoBase * 0.1
        }

        return sueldo.coerceAtMost(sueldoBase + 200.0)
    }

    // Método toString para obtener la representación en cadena del objeto
    override fun toString(): String {
        return super.toString() + " Empleado: [ Departamento: $departamento, Sueldo Base: $sueldoBase, Año de Incorporación: $anioAlta ]"
    }
}

/**
 * Muestra el menú principal de la aplicación.
 * */
fun MostrarMenu() {
    println("a. Prueba parte 1")
    println("b. Prueba parte 2")
    println("c. Salir del programa")
}

/**
 * Lee una cadena de caractéres de la entrada estándar.
 * Retorna un string vacío si el usuario no introduce datos,
 * de lo contrario retorna la entrada del usuario.
 * */
fun LeerCadena(prompt: String?): String? {
    if (prompt != null) {
        print(prompt)
    }
    return readlnOrNull()
}

/**
 * Clase Empresa que contiene una lista de empleados.
 * Se construye con una lista vacía de empleados.
 */
class Empresa {
    private val listaEmpleados = mutableListOf<Empleado>()

    // Método para insertar un empleado en la lista
    fun InsertarEmpleado(empleado: Empleado) {
        listaEmpleados.add(empleado)
    }

    // Método para listar empleados según un filtro
    fun ListarEmpleados(filtro: (Empleado) -> Boolean) {
        val empleadosFiltrados = listaEmpleados.filter(filtro)
        for (empleado in empleadosFiltrados) {
            println(empleado)
        }
    }
}

/**
 * Función para la primera parte del programa.
 * */
fun Parte1() {
    // Creación de objetos

    // persona 1
    var nombre = LeerCadena("Introduce el nombre: ")
    var edad = LeerCadena("Introduce la edad: ")?.toIntOrNull()
    var sexo = LeerCadena("Introduce el sexo ( HOMBRE [H] / MUJER [M] ): ")
    val peso = LeerCadena("Introduce el peso: ")?.toFloatOrNull()
    val altura = LeerCadena("Introduce la altura (en cm): ")?.toFloatOrNull()
    val objeto1 = Persona(edad ?: 0, nombre ?: "", sexo ?: "", peso ?: 0.0f, altura ?: 0.0f)

    // persona 2
    nombre = LeerCadena("Introduce el nombre: ")
    edad = LeerCadena("Introduce la edad: ")?.toIntOrNull()
    sexo = LeerCadena("Introduce el sexo ( HOMBRE [H] / MUJER [M] ): ")
    val objeto2 = Persona(edad ?: 0, nombre ?: "", sexo ?: "")

    // persona 3
    val objeto3 = Persona()
    objeto3.nombre = "Clara"
    objeto3.edad = 22
    objeto3.sexo = Sexo.MUJER
    objeto3.peso = 76.4f
    objeto3.altura = 178.0f

    val personas = arrayOf(objeto1, objeto2, objeto3)

    val IndexIMC = fun(persona: Persona): String {
        return when (persona.CalcularImc()) {
            SOBREPESO -> "Tiene sobrepeso"
            NO_IDEAL -> "Tiene peso no ideal"
            IDEAL -> "Tiene peso ideal"
            else -> "Error en el cálculo de peso"
        }
    }

    // comprobación IMC
    for (persona in personas) {
        println("${persona.nombre}: ${IndexIMC(persona)}")
    }

    // comprobación edad
    for (persona in personas) {
        println("${persona.nombre} es mayor de edad: ${if (persona.EsMayorDeEdad()) "Sí" else "No"}")
    }

    // mostrar datos
    for (persona in personas) {
        println(persona)
    }
}

/**
 * Función para la segunda parte del programa.
 * */
fun Parte2() {
    val empleado1 = Empleado("Juan", 27, "H", 78.2f, 177.0f, Departamento.VENTAS, 1080.0, LocalDate.now().minusYears(4).year)
    val empleado2 = Empleado("Ana", 25, "m", 61.2f, 167.0f, Departamento.RRHH, 1180.0, LocalDate.now().minusYears(2).year)
    val empleado3 = Empleado("Clara", 22, "mujer", 70.3f, 178.5f, Departamento.VENTAS, 1280.0, LocalDate.now().minusYears(5).year)

    val empresa = Empresa()
    empresa.InsertarEmpleado(empleado1)
    empresa.InsertarEmpleado(empleado2)
    empresa.InsertarEmpleado(empleado3)

    println("\nListado de empleados del departamento de VENTAS:")
    empresa.ListarEmpleados { it.departamento == Departamento.VENTAS }
}

fun main(args: Array<String>) {
    var input: String?

    do {
        MostrarMenu()
        input = LeerCadena("Entra opción: ")

        when (input) {
            PARTE_1 -> Parte1()
            PARTE_2 -> Parte2()
        }
    } while (input?.equals(SALIR) != true)

    println("Saliendo del programa...")
}