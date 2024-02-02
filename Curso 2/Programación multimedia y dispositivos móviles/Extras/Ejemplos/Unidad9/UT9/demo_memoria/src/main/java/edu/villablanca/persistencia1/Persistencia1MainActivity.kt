package edu.villablanca.persistencia1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import edu.villablanca.persistencia1.ui.theme.UT9Theme

class Persistencia1MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtén el SharedPreferences
        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)

        // Usa getString para obtener el valor, el segundo parámetro es un valor por defecto
        val nombreUsuario = sharedPref.getString("nombreUsuario", "UsuarioDesconocido")


        setContent {
            UT9Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoMemoria(nombreUsuario ?: "No inicializado")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Obtén el SharedPreferences
        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)

        // Usa un editor para guardar tus datos


        with(sharedPref.edit()) {
            putString("nombreUsuario", "Rodrigo")
            apply()
        }
    }
}

@Composable
fun DemoMemoria(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    var textoMemoria by remember { mutableStateOf("") }
    var leidoMemoria by remember { mutableStateOf("") }

    var yaEscrito by remember { mutableStateOf(false) }
    var yaLeido by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "Demostraciones de almacenamiento en memoria")
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Preferencias compartidas:  $name!",
            modifier = modifier
        )
        Divider()
        Text(text = "Memoria Interna")

        OutlinedTextField(
            value = textoMemoria,
            onValueChange = { textoMemoria = it },
            label = { Text(text = "para el fichero") }
        )

        Button(
            onClick = {
                /* escribimos el fichero*/
                contexto.openFileOutput("DemoMem.txt", Context.MODE_PRIVATE).use {
                    it.write(textoMemoria.toByteArray())
                }
                yaEscrito = true
                /** También con texto:
                PrintWriter("miArchivo.txt").use { writer ->
                writer.println("Hola Jetpack Genius!")
                }
                 **/
            },
            enabled = !yaEscrito
        ) {
            Text(text = "Escribir")
        }
        Button(onClick = {

            leidoMemoria =
                contexto.openFileInput("DemoMem.txt").bufferedReader().use { it.readText() }
            yaLeido = true
        },
            enabled = !yaLeido

        ) {
            Text(text = "Leer fichero")
        }
        Text(text = "Leido: $leidoMemoria")

    }

}

