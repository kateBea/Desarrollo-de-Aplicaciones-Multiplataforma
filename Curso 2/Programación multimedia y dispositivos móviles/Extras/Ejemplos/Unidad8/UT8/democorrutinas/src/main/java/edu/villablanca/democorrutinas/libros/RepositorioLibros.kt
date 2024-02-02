package edu.villablanca.democorrutinas.libros

import kotlinx.coroutines.delay
import kotlin.random.Random

class RepositorioLibros {
    val libros = listOf("El Quiote","Las Ratas", "Los Santos Inocentes","El Buscón" )
    suspend fun obtenerTodos() : List<String>{
        delay(Random.nextLong(400,3000))
        return libros
    }
}