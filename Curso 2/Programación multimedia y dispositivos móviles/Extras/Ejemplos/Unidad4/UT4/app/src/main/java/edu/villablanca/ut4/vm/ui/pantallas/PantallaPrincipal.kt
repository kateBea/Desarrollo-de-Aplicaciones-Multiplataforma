package edu.villablanca.ut4.vm.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Pantalla principal
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(onNavegar: ()->Unit, modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "PantallaPrincipal",
            modifier = modifier
        )
        Row {
            Button(onClick = { onNavegar() }) {
                Text(text = "ir p1")
            }
        }
    }

}