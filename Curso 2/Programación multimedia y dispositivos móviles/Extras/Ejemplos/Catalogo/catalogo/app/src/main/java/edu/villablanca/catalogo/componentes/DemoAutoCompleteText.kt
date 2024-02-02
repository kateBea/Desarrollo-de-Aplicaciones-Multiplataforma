package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * En Jetpack Compose, el equivalente de AutoCompleteTextView de las vistas tradicionales de Android se puede crear utilizando una combinación de
 * TextField (o OutlinedTextField) para la entrada de texto y DropdownMenu para mostrar las sugerencias. Esta combinación te permite construir una
 * funcionalidad similar a la de AutoCompleteTextView.
 *
 *  cómo podrías implementarlo:
 *
 * TextField/OutlinedTextField: Para la entrada de texto. Aquí es donde el usuario escribirá su entrada.
 *
 * DropdownMenu: Para mostrar una lista de opciones o sugerencias que cambian basándose en la entrada del usuario.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoAutoCompleteText(){

    var sTexto by remember { mutableStateOf("") }
    var isListaSugerencias by remember { mutableStateOf(false) }
    var listaSugerencias = listOf("Hola", "mundo", "android", "kotlin", "villablanca")
    var sugerencias by remember { mutableStateOf(listaSugerencias) }

    Column {
        TextField(value = sTexto, onValueChange = {
            sTexto = it
            sugerencias = filtroListaSugerencias(it, listaSugerencias)
            isListaSugerencias = sugerencias.isNotEmpty()
        },
        label = { Text(text = "Escribir algo......") }
        )

        if (isListaSugerencias) {
            DropdownMenu(expanded = isListaSugerencias,
                onDismissRequest = { isListaSugerencias = false },
                modifier = Modifier
                    .fillMaxWidth()
                ) {
                sugerencias.forEach { s -> DropdownMenuItem(
                    text = { Text(text = s) },
                    onClick = {
                        sTexto = s
                        isListaSugerencias = false
                    }
                )
                }
            }
        }

        LaunchedEffect(isListaSugerencias) {
            if (isListaSugerencias) {
                sugerencias = filtroListaSugerencias(sTexto, listaSugerencias)
            }
        }

    }
}

fun filtroListaSugerencias(input: String, listaSugerencias: List<String>): List<String> {
    return listaSugerencias.filter {
        it.contains(input, ignoreCase = true)
    }
}
