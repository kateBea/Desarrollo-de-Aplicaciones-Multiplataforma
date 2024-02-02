package edu.villablanca.democorrutinas

import androidx.compose.runtime.structuralEqualityPolicy
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private var contador=0
private const val ESPERA: Long=5000
suspend fun SimularES(peticion: String): String{

    delay(ESPERA) // Simula un delay de red
    contador++
    return "Datos para solicitud $peticion , cont=$contador"

}
