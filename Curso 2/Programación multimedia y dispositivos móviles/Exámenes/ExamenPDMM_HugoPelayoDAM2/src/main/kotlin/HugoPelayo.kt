const val OPCION1 = 1
const val OPCION2 = 2
const val OPCION3 = 3
const val OPCION4 = 4
const val OPCION5 = 5
const val SALIR = 6

// las propiedades deben tener
// visibilidad similar a los atributos
class EquipoResultado (
    var id: Int,
    var nombreEquipo: String,
    var puntos: Int = 0,
    var totalGolesFavor: Int = 0,
    var totalGolesContra: Int = 0) {

    override fun toString(): String {
        return "EquipoResultado(id=$id, nombreEquipo='$nombreEquipo', puntos=$puntos, totalGolesFavor=$totalGolesFavor, totalGolesContra=$totalGolesContra)"
    }
}

data class Encuentro (var id1: Int, var golesFavor1r: Int, val id2: Int, var golesFavor2: Int)
object Campeonato {
    private var listaEquipos = mutableListOf<EquipoResultado>()
    private var listaEncuentros = mutableListOf<Encuentro>()

    private fun existeEquipo(id: Int): Int {
        var index = 0
        var encontrado = false

        while (index < listaEquipos.size && !encontrado) {
            encontrado = listaEquipos[index++].id == id
        }

        return if (!encontrado) -1 else index - 1
    }

    fun estadisticas(operacion: (Int) -> Double): String {
        return "TODO"
    }

    fun addEquipo(equipoResultado: EquipoResultado) {
        if (existeEquipo(equipoResultado.id) != -1) {
            println("Equipo ya existe")
        } else {
            listaEquipos.add(equipoResultado)
            println("Equipo añadido")
        }
    }

    fun deleteEquipo(idEquipo: Int) {
        val index = existeEquipo(idEquipo)
        if (index == -1) {
            println("Equipo no existe")
        } else {
            listaEquipos.removeAt(index)
            println("Equipo borrado")
        }
    }

    fun listarResultados() {
        for (elem in listaEncuentros) {
            val e1 = listaEquipos[existeEquipo(elem.id1)]
            val e2 = listaEquipos[existeEquipo(elem.id2)]

            println("${e1.nombreEquipo} vs ${e2.nombreEquipo} -> ${elem.golesFavor1r} : ${elem.golesFavor2}")
        }
    }

    fun resultadoPartido(equipo1Id: Int, golesFavor1r: Int, equipo2Id: Int, golesFavor2: Int) {
        val busqueda1 = existeEquipo(equipo1Id)
        val busqueda2 = existeEquipo(equipo2Id)

        if (busqueda1 != -1 && busqueda2 != -1) {
            when {
                golesFavor2 == golesFavor1r -> {
                    // empate
                    listaEquipos[busqueda1].puntos += 1
                    listaEquipos[busqueda2].puntos += 1
                }

                golesFavor2 < golesFavor1r -> {
                    // el equipo 1 ha ganado
                    listaEquipos[busqueda1].puntos += 1
                }

                else -> {
                    // el equipo 2 ha ganado
                    listaEquipos[busqueda2].puntos += 1
                }
            }

            listaEncuentros.add(Encuentro(equipo1Id, golesFavor1r, equipo2Id, golesFavor2))
        } else {
            println("No existe alguno de los equipos")
        }
    }
}
fun mostrarMenu() {
    println("$OPCION1. Añadir nuevo EquipoResultado")
    println("$OPCION2. Borrar EquipoResultado")
    println("$OPCION3. Actualizar resultados después de un partido")
    println("$OPCION4. Listar todos los resultados")
    println("$OPCION5. Estadísticas del campeonato")
    println("$SALIR. Salir del programa")
}

fun leerCadena(prompt: String?): String? {
    if (prompt != null) {
        print(prompt)
    }

    return readlnOrNull()
}

fun opcion1() {
    val id = leerCadena("Introduce ID: ")?.toIntOrNull()
    val nombre = leerCadena("Introduce nombre: ")

    if (id != null && nombre != null) {
        Campeonato.addEquipo(EquipoResultado(id, nombre))
    } else {
        println("Error al leer los datos")
    }
}

fun opcion2() {
    val id = leerCadena("Introduce ID: ")?.toIntOrNull()

    if (id != null) {
        Campeonato.deleteEquipo(id)
    } else {
        println("Error al leer los datos")
    }
}

fun opcion3() {
    val id1 = leerCadena("Introduce ID equipo1: ")?.toIntOrNull()
    val goles1 = leerCadena("Introduce goles a favor equipo1: ")?.toIntOrNull()

    val id2 = leerCadena("Introduce ID equipo2: ")?.toIntOrNull()
    val goles2 = leerCadena("Introduce goles a favor equipo2: ")?.toIntOrNull()

    if (id1 != null && goles1 != null && id2 != null && goles2 != null) {
        Campeonato.resultadoPartido(id1, goles1, id2, goles2)
    } else {
        println("Error en los datos")
    }
}

fun opcion4() {
    Campeonato.listarResultados()
}

fun opcion5() {

}

fun main() {
    var input: Int? = null
    var acabado: Boolean = false

    do {
        mostrarMenu()
        input = leerCadena("\nEntra un índice: ")?.toIntOrNull()

        input?.let{
            when (input) {
                OPCION1 -> opcion1()
                OPCION2 -> opcion2()
                OPCION3 -> opcion3()
                OPCION4 -> opcion4()
                OPCION5 -> opcion5()
                SALIR -> acabado = true
            }
        }
    } while (!acabado)

    println("Saliendo del programa")
}