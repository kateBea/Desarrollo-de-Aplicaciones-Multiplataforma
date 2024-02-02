package edu.villablanca.ut4.vm.modelo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class SensorVM: ViewModel() {
    var empezado by mutableStateOf(false)

    // flows
    private val  _temperatura = MutableStateFlow(0f)
    val temperaturaFlujoEstado = _temperatura.asStateFlow()

    fun empezar(){
        empezado = false
        viewModelScope.launch {
            while(true) {
                val numero = Random.nextFloat()
                if(empezado)
                    _temperatura.emit(numero)
                delay(1000)
            }
        }

    }
    fun onConmutar(){
        empezado = !empezado
    }
}