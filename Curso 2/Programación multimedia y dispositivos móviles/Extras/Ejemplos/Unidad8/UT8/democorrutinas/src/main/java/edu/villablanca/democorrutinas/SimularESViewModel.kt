package edu.villablanca.democorrutinas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class EsUiState(
    val leido: String=""
)

/**
 * Recomendaciones a seguri:
 *  1. Lanzar las corrutinas en las vistas.
 *  2. Inyectar el Dispatcher en lugar de insertarlo en el codigo de las funciones
 */
class SimularESViewMode(
    private val elDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel(){
    private val _uiState = MutableStateFlow(EsUiState())
    val uiState = _uiState.asStateFlow()

    private val _continuo = MutableStateFlow("")
    val continuo = _continuo.asStateFlow()

    fun procesar(){
        viewModelScope.launch(elDispatcher) {
            val x = SimularES("Uno")
            _uiState.update { _uiState.value.copy(leido=x) }
        }
    }

    /**
     * Emite una lectura cada x segundos
     */
    fun procesarContinuo(){
        viewModelScope.launch {
            while(true){
                val x = SimularES("Continuo")
                // la función anterior incluye la espera
                _continuo.emit(x)
            }
        }
    }
}