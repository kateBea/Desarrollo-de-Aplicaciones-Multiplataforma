package edu.villablanca.democorrutinas.libros

import kotlinx.coroutines.delay
import kotlin.random.Random

class RepositorioAutores {
    val autores = listOf("Cervantes","Delibes", "Garcilaso", "Quevedo")

    suspend fun obtenerTodos() : List<String>{

        delay(Random.nextLong(400,3000))
        return autores
    }

}