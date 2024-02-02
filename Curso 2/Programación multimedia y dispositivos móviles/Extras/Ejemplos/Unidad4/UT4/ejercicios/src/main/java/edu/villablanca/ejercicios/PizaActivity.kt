package edu.villablanca.ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.villablanca.ejercicios.pantallas.PantallaInicio
import edu.villablanca.ejercicios.pantallas.PedidoApp
import edu.villablanca.ejercicios.ui.theme.UT4Theme
import edu.villablanca.ejercicios.viewmodel.PedidoViewModel

/**
 *
 *
 *
 * Añadimos la recuperación de los extras cuando se inicia desde Login
 *
 */
class PizaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pedidoVM = PedidoViewModel()
        var nombre = intent.getStringExtra("nombre")
        var telefono = intent.getStringExtra("telefono")

        pedidoVM.setCliente(nombre, telefono)
        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 //   PantallaInicio(pedidoVM)
                    PedidoApp(pedidoVM=pedidoVM)
                }
            }
        }
    }
}



