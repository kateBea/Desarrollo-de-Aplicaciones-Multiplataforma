package edu.villablanca.misnotas.pantallas

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


/**
 *  Lista de notas
 *  Sin persistencia.
 */
@Composable
fun PantallasNotas(nueva: String){


        var textoActual by remember { mutableStateOf("") }
        val notas = remember { mutableStateListOf<String>(nueva) }
        var terminar by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            TextField(
                value = textoActual ,
                onValueChange = { textoActual = it },
                label = { Text("Escribe tu nota aquí") }

            )
            Button(
                onClick = {
                    notas.add(textoActual)
                    textoActual = ""
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Icon( Icons.Filled.List, contentDescription ="" )
                Text("Guardar Nota")
            }

            Column {
                
           
            notas.forEach { nota ->
                Row(
                   verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Star, contentDescription = "")
                    Text(nota, modifier = Modifier.padding(top = 8.dp))
                }

            }
            } // segundo column
            Button(onClick = { terminar = true }) {
                Text(text="Salir")

            }
        }
    if (terminar)
        (LocalContext.current as Activity).finish()
}