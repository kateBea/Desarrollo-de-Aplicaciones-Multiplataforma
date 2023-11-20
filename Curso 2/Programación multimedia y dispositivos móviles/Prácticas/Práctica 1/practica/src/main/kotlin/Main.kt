/******************************************************************
 * Práctica KOTLIN
 *
 * @author Hugo Pelayo (Segundo DAM)
 * @version 1.0.0
 * ****************************************************************/


/******************************************************************
 * Imports
 * ****************************************************************/
import java.util.*
import java.time.LocalDate
import kotlin.random.Random

/******************************************************************
 * Constantes
 * ****************************************************************/
const val PARTE_1 = "a"
const val PARTE_2 = "b"
const val SALIR = "c"

const val SOBREPESO = 1
const val NO_IDEAL = -1
const val IDEAL = 0

const val MAYOR_DE_EDAD = 18

const val CM_A_M = 0.01f

/******************************************************************
 * Utilidades
 * ****************************************************************/

// Función para mostrar el menú
fun mostrarMenu() {
    println("a. Prueba parte 1")
    println("b. Prueba parte 2")
    println("c. Salir del programa")
}

// Función para leer una cadena desde la entrada estándar
fun leerCadena(prompt: String?): String? {
    if (prompt != null) {
        print(prompt)
    }
    return readlnOrNull()
}

/******************************************************************
 * Definición de objetos
 * ****************************************************************/

/**
 * Enumerado de sexo
 */
enum class Sexo { HOMBRE, MUJER }

// Función para convertir una cadena en un valor del enumerado Sexo
fun ToSexo(valor: String): Sexo {
    val target = valor.uppercase(Locale.getDefault())

    return when(target) {
        "H" -> Sexo.HOMBRE
        "HOMBRE" -> Sexo.HOMBRE
        "M" -> Sexo.MUJER
        "MUJER" -> Sexo.MUJER
        else -> Sexo.HOMBRE
    }
}

/**
 * Enumerado de departamentos
 */
enum class Departamento { CONTABILIDAD, RRHH, VENTAS, ALMACEN }

/**
 * Clase base Persona
 */
open class Persona(
    private var edad: Int = 0,
    private var nombre: String = "",
    private var sexo: Sexo = Sexo.HOMBRE,
    private var peso: Float = 0.0f,
    private var altura: Float = 0.0f,
    private val dni: String = GenerarDNI(),
) {
    init {
        if (edad < 0) {
            this.edad = 0
        }
        if (peso < 0) {
            this.peso = 0.0f
        }
        if (altura < 0) {
            this.altura = 0.0f
        }
    }

    // Constructor secundario
    constructor(nombre: String, edad: Int, sexo: Sexo) : this(edad, nombre, sexo) {
        ComprobarSexo()
    }

    // Método para calcular el IMC
    fun CalcularImc(): Int {
        val alturaM: Float = altura * CM_A_M
        val imc = peso / (alturaM * alturaM)

        return when {
            imc < 20 -> NO_IDEAL
            imc in 20.0..25.0 -> IDEAL
            else -> SOBREPESO
        }
    }

    companion object {
        // Método para generar un DNI aleatorio
        fun GenerarDNI(): String {
            val dniNumero = Random.nextInt(10000000, 99999999)
            val letras = "TRWAGMYFPDXBNJZSQVHLCKE"
            val letra = letras[dniNumero % 23]
            return "$dniNumero$letra"
        }
    }

    // Método para verificar si es mayor de edad
    fun EsMayorDeEdad(): Boolean {
        return edad >= MAYOR_DE_EDAD
    }

    // Método privado para calcular el IMC
    private fun CalcularIMC(): Int {
        val imc = peso / (altura * altura)
        return when {
            imc < 20 -> -1
            imc in 20.0..25.0 -> 0
            else -> 1
        }
    }

    // Método privado para comprobar el sexo
    private fun ComprobarSexo(): Sexo {
        return if (sexo == Sexo.HOMBRE || sexo == Sexo.MUJER) {
            sexo
        } else {
            Sexo.HOMBRE
        }
    }

    // Métodos públicos para establecer atributos
    fun SetNombre(nombre: String) {
        this.nombre = nombre
    }

    fun SetEdad(edad: Int) {
        this.edad = if (edad < 0) 0 else edad
    }

    fun SetSexo(sexo: Sexo) {
        this.sexo = sexo
    }

    fun SetPeso(peso: Float) {
        this.peso = if (peso < 0) 0.0f else peso
    }

    fun SetAltura(altura: Float) {
        this.altura = if (altura < 0) 0.0f else altura
    }

    // Método toString para obtener la representación en cadena del objeto
    override fun toString(): String {
        return "[ Nombre: $nombre, Edad: $edad, DNI: $dni, Sexo: $sexo, Peso: $peso, Altura: $altura ]"
    }
}

/**
 * Clase Empleado que hereda de Persona
 */
class Empleado(
    nombre: String,
    edad: Int,
    sexo: Sexo,
    peso: Float,
    altura: Float,
    departamento: Departamento,
    sueldoBase: Double,
    anioAlta: Int
) : Persona(edad, nombre, sexo, peso, altura) {
    private var departamento: Departamento
    private var sueldoBase: Double
    private var anioAlta: Int

    // Inicializador secundario
    init {
        this.departamento = departamento
        this.sueldoBase = sueldoBase
        this.anioAlta = anioAlta
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

    // Getter para obtener el departamento
    fun GetDepartamento(): Departamento {
        return departamento
    }

    // Getter para obtener el sueldo base
    fun GetSueldoBase(): Double {
        return sueldoBase
    }

    // Getter para obtener el año de incorporación
    fun GetAnioIncorporacion(): Int {
        return anioAlta
    }

    // Método toString para obtener la representación en cadena del objeto
    override fun toString(): String {
        return super.toString() + " Empleado: [ Departamento: $departamento, Sueldo Base: $sueldoBase, Año de Incorporación: $anioAlta ]"
    }
}

/**
 * Clase Empresa que contiene una lista de empleados
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

/******************************************************************
 * Funciones
 * ****************************************************************/

// Función para la primera parte del programa
fun parte1() {
    // Creación de objetos
    var nombre = leerCadena("Introduce el nombre: ")
    var edad = leerCadena("Introduce la edad: ")?.toIntOrNull()
    var sexo = leerCadena("Introduce el sexo ( HOMBRE [H] / MUJER [M] ): ")
    val peso = leerCadena("Introduce el peso: ")?.toFloatOrNull()
    val altura = leerCadena("Introduce la altura (en cm): ")?.toFloatOrNull()

    val objeto1 = Persona(edad ?: 0, nombre ?: "", ToSexo(sexo ?: ""), peso ?: 0.0f, altura ?: 0.0f)

    nombre = leerCadena("Introduce el nombre: ")
    edad = leerCadena("Introduce la edad: ")?.toIntOrNull()
    sexo = leerCadena("Introduce el sexo ( HOMBRE [H] / MUJER [M] ): ")
    val objeto2 = Persona(edad ?: 0, nombre ?: "", ToSexo(sexo ?: ""))

    val objeto3 = Persona()

    objeto3.SetNombre("Clara")
    objeto3.SetEdad(22)
    objeto3.SetSexo(Sexo.MUJER)
    objeto3.SetPeso(76.4f)
    objeto3.SetAltura(178.0f)

    val IndexIMC = fun(persona: Persona): String {
        return when (persona.CalcularImc()) {
            SOBREPESO -> "Tiene sobrepeso"
            NO_IDEAL -> "Tiene peso no ideal"
            IDEAL -> "Tiene peso ideal"
            else -> "Error en el cálculo de peso"
        }
    }

    // comprobación IMC
    println("Persona 1: ${IndexIMC(objeto1)}")
    println("Persona 2: ${IndexIMC(objeto2)}")
    println("Persona 3: ${IndexIMC(objeto3)}")

    // comprobación edad
    println("Persona 1 es mayor de edad: ${if (objeto1.EsMayorDeEdad()) "Sí" else "No"}")
    println("Persona 2 es mayor de edad: ${if (objeto2.EsMayorDeEdad()) "Sí" else "No"}")
    println("Persona 3 es mayor de edad: ${if (objeto3.EsMayorDeEdad()) "Sí" else "No"}")

    // mostrar datos
    println(objeto1)
    println(objeto2)
    println(objeto3)
}

// Función para la segunda parte del programa
fun parte2() {
    val empleado1 = Empleado("Juan", 27, Sexo.HOMBRE, 78.2f, 177.0f, Departamento.VENTAS, 1080.0, LocalDate.now().minusYears(4).year)
    val empleado2 = Empleado("Ana", 25, Sexo.MUJER, 61.2f, 167.0f, Departamento.RRHH, 1180.0, LocalDate.now().minusYears(2).year)
    val empleado3 = Empleado("Clara", 22, Sexo.MUJER, 70.3f, 178.5f, Departamento.VENTAS, 1280.0, LocalDate.now().minusYears(5).year)

    val empresa = Empresa()
    empresa.InsertarEmpleado(empleado1)
    empresa.InsertarEmpleado(empleado2)
    empresa.InsertarEmpleado(empleado3)

    println("\nListado de empleados del departamento de VENTAS:")
    empresa.ListarEmpleados { it.GetDepartamento() == Departamento.VENTAS }
}

// Función principal del programa
fun main(args: Array<String>) {
    var input: String?

    do {
        mostrarMenu()
        print("Entra opción: ")
        input = readlnOrNull()

        when (input) {
            PARTE_1 -> parte1()
            PARTE_2 -> parte2()
        }
    } while (input?.equals(SALIR) != true)

    println("Saliendo del programa...")
}