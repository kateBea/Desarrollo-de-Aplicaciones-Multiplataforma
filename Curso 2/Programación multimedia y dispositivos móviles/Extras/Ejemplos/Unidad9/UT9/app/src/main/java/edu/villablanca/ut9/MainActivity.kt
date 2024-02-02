package edu.villablanca.ut9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.villablanca.ut9.ui.theme.UT9Theme
import edu.villablanca.ut9.ui.theme.pantallas.PantallaCalendario

/**
 * Demostraciones
 * Demo Uso Centent Provider de Contactos
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            UT9Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   // PantallaListaContactos()
                    PantallaCalendario()
                }
            }
        }
    }
}
