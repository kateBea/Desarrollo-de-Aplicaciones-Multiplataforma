package edu.villablanca.ut4.navi.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Muestra en campo de entrada que luego se mostrará en Pantalla2
 * @param onNavegar: lambda con la acción al pulsar el botón
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla1( onNavegar: (String)-> Unit){

    var miValor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Pantalla 1",
            fontSize = 30.sp
            )
        Divider()
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription ="" )


        OutlinedTextField(
            value = miValor,
            label={ Text(text = "Dame algo")},
            onValueChange ={
               miValor = it
            } )

        Button(onClick = { onNavegar( miValor) }) {
            Text(text = "enviar")
        }
    }
}