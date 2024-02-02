package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DemoMenus() {
    var expandido by remember { mutableStateOf(false) }
    val opciones = listOf("Op1", "Op2", "Op3", "Op4")
    var textoSeleccionado by remember { mutableStateOf("") }
    var tamanoTexto by remember { mutableStateOf(Size.Zero) }

    val icono = if (expandido)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = textoSeleccionado,
            onValueChange = { textoSeleccionado = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    tamanoTexto = coordinates.size.toSize()
                },
            label = { Text("OPCIONES") },
            trailingIcon = {
                Icon(icono, "contentDescription",
                    Modifier
                        .clickable { expandido = !expandido }
                )
            }
        )
        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false },
            modifier = Modifier

                .width(with(LocalDensity.current) {
                    tamanoTexto.width.toDp()
                })


        ) {
            opciones.forEach { label ->
                val textoOpcion = remember { label }
                DropdownMenuItem(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .offset(y = 16.dp),
                    text = { Text(textoOpcion) },
                    onClick = {
                        textoSeleccionado = textoOpcion
                        expandido = false
                    })
            }
        }
    }
}
