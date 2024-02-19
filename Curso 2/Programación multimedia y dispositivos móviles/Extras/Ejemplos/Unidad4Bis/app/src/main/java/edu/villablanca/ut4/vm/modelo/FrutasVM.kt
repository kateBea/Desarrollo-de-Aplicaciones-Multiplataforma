package edu.villablanca.ut4.vm.modelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 *  ViewModel para una lista de frutas.
 *  Actualiza el IU en la corrutina de la funcion onBotonPulsado
 *  Recibe evento de IU al usar onBotonPulsado como lambda de boton en la pantall
 *
 *  Mantenemos privado _mensajeFlujoEtado
 */
class FrutasVM: ViewModel() {
    private val laLista= listOf<String>("Pera","Naranja","Ciruela","Manzana")
    private val _mensajeFlujoEstado = MutableStateFlow("")
    val mensajeFlujoEstado =  _mensajeFlujoEstado.asStateFlow()

    /**
     * Emite un único mensajes de forma aleatoria elegido de laLista
     * Usamos una corrutina
     */
    fun onBotonPulsado(){
        viewModelScope.launch {
            repeat(10) {
                val fruta = laLista.random()
                _mensajeFlujoEstado.emit("("+ it + ")" + fruta)
                delay(1000)
            }
        }

    }
}