package edu.villablanca.ut3.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaB(mensaje: String?, onSalir: ()-> Unit){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "ACTIVITY B",
            fontSize = 24.sp,
        )
        Text(
            text = "Texto recibido :  $mensaje",
            modifier = Modifier.fillMaxWidth(0.8f)
                .padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
            )
        Button(onClick =onSalir) {
            Text(text="Back")
        }
    }
}