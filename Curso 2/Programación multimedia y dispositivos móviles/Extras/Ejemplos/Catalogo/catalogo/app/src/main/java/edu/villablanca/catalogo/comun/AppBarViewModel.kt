package edu.villablanca.catalogo.comun

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class AppBarViewModel: ViewModel() {
    private val _titulo = MutableStateFlow("Inicio")
    val titulo = _titulo.asStateFlow()

    private val _uiState = MutableStateFlow(UIComponente("",""))
    val uiState = _uiState.asStateFlow()

    fun actualizarTitulo(nuevoTitulo: String) {
        _titulo.value = nuevoTitulo
    }

    fun actualizarCodigoFuente(fuente: String) {
        _uiState.value = _uiState.value.copy(codigo = fuente)

    }

}