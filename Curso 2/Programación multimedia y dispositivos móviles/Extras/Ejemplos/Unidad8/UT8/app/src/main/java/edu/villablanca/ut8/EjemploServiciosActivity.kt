package edu.villablanca.ut8

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.ut8.servicios.ServicioLog
import edu.villablanca.ut8.ui.theme.Ut8Theme

class EjemploServiciosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ut8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaServicio()
                }
            }
        }
    }
}

@Composable
fun PantallaServicio(){
    val contexto = LocalContext.current
    val intencion = Intent(contexto, ServicioLog::class.java)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(text = "Ejemplos de Servicios definidos por el usuario")
        Button(onClick = {

            contexto.startService(intencion)
        }) {
            Text(text = "Iniciar Servicio")
        }

        Button(onClick = {
        contexto.stopService(intencion)
        }) {
            Text(text = "Finalizar Servicio")
        }
    }
}