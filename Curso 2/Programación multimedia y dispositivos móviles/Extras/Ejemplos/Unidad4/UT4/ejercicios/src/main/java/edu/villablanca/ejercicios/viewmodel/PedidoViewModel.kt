package edu.villablanca.ejercicios.viewmodel

import androidx.lifecycle.ViewModel
import edu.villablanca.ejercicios.data.PizaDatos.ingredientes
import edu.villablanca.ejercicios.uistates.PedidoUIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

const val PRECIO_BASE = 6.0f

const val PRECIO_INGREDINTE  = 0.7f

class PedidoViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PedidoUIState())
    val uiState: StateFlow<PedidoUIState> = _uiState.asStateFlow()

    fun setNumeroIngredientes(n: Int){
        _uiState.update {pedidoActual ->
            pedidoActual.copy(num_ingredientes = n)
        }
    }

    fun setMasa( tipoMasa: String) {
        _uiState.update { it.copy(masa = tipoMasa) }
    }

    fun addSeleccionado(ingrediente: String) {
        _uiState.update{
            var ing : MutableSet<String> = it.ingredientes.toMutableSet()
            ing.add(ingrediente)
            it.copy(ingredientes = ing , num_ingredientes = it.num_ingredientes + 1)
           }

    }

    fun quitarSeleccionado(ingrediente: String) {
        _uiState.update{
            var ing : MutableSet<String> = it.ingredientes.toMutableSet()
            ing.remove(ingrediente)
            it.copy(ingredientes = ing,  num_ingredientes = it.num_ingredientes - 1)
        }   // es el recurso, ver como soluconar
    }

    /**
     * Borra todas las selecciones
     */
    fun reset(){
        _uiState.value = PedidoUIState()
    }

    /**
     * Calcula el precio de la piza;
     *  Precio base
     *  mas numero de ingredintes por precio ingrediente
     */
    fun calcularPrecio(){
        _uiState.update {
            it.copy(precio = (PRECIO_BASE + PRECIO_INGREDINTE * it.num_ingredientes .toFloat() ).toString()  )
        }
    }

    fun setCliente(nombre: String?, telefono: String?) {

        _uiState.update {
            it.copy(cliente = nombre ?: "",telefono=telefono ?:"")
        }
    }
}