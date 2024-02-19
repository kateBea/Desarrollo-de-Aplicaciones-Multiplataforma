package edu.villablanca.ut4.navi.ui.navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * La dirección de cada ventana se mantiene en esta clase.
 * @param ruta : dirección de la ventana
 */
sealed class Destinos(
    val ruta: String,
    val titulo: String,
    val icono: ImageVector
){
    object PantallaPrincipal: Destinos("PantallaPrincipal","Pantalla principal", Icons.Filled.AccountBox)
    object PantallaUno : Destinos("Pantalla1","Entrada", Icons.Filled.Home)
    object PantallaDos : Destinos("Pantalla2/{newText}", "Segunda pantalla", Icons.Filled.Settings){
        fun crearRuta(nuevoTexto: String ) ="Pantalla2/$nuevoTexto"
    }

}
