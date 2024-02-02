package edu.villablanca.ejercicios.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.villablanca.ejercicios.uistates.PedidoUIState
import edu.villablanca.ejercicios.viewmodel.PedidoViewModel

@Composable
fun PantallaResumenCompra(
    pedidoUIState: PedidoUIState,
    onPagar: ()-> Unit,
) {
    Log.d(ETIQUTA, "resumen: ${pedidoUIState.num_ingredientes}")
    Column(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(start = 24.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Resumen de compra")
        Text(text = "Num Ingredientes: ${pedidoUIState.num_ingredientes}")
        Text(text = "Tipo de masa    : ${pedidoUIState.masa}")
        Text(text = "Precio final    : ${pedidoUIState.precio}")
        Text(text = "Cliente: ${pedidoUIState.cliente} ")
        Button(onClick = onPagar) {
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Pagar")
                Icon( Icons.Filled.Payment , contentDescription = "pagar")
            }

        }

    }
    
}

@Preview
@Composable
fun vpResumen() {
    //PantallaResumenCompra(pedidoUIState = PedidoUIState())
}