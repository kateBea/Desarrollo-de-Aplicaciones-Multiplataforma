package edu.villablanca.democorrutinas.libros


import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext


class LibrosAutores(
     private val librosRepositorio: RepositorioLibros,
     private val autoresRepositorio: RepositorioAutores

 ){

    /**
     * En paralelo obtenemos libros y autores, se crea un obeto LibrosAutoresEntity que
     * se devuelve
     */
     suspend fun obtenerLibrosAutores() : LibrosAutoresEntity = coroutineScope {
            val libros = async {librosRepositorio.obtenerTodos()}
            val autores = async {autoresRepositorio.obtenerTodos()}
            LibrosAutoresEntity(libros.await(),autores.await())
     }
 }
