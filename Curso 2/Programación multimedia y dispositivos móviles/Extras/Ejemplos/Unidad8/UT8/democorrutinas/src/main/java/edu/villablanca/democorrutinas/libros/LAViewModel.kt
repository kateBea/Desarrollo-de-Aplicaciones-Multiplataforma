package edu.villablanca.democorrutinas.libros

import android.view.View
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LAViewModel: ViewModel() {
    private val _librosautores = MutableStateFlow(LibrosAutoresEntity())
    val librosautores = _librosautores.asStateFlow()

     suspend fun obtenerLibrosAutoeres(){
       val la: LibrosAutoresEntity = LibrosAutores(RepositorioLibros(),RepositorioAutores()).obtenerLibrosAutores()

        _librosautores.value = la


    }
}