package edu.villablanca.ut3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.villablanca.ut3.pantallas.PantallaImplicitos
import edu.villablanca.ut3.ui.theme.UT3Theme

/**
 *  Para terminar con la actividad usando un boton de compose se
 *  necesita la función  "finish()" que está en el contexto de Activity
 *  pero no los composables.
 *  Utilizamos una función lambda que nos devuelve la pulsación
 *
 */
class Actividad_C : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaImplicitos("Dos ejemplos de Intent Implicit para el correo y tomar una foto") { finish() }
                }
            }
        }
    }
}


