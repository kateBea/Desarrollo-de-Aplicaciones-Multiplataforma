package edu.villablanca.ejercicios.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.villablanca.ejercicios.R
import edu.villablanca.ejercicios.uistates.PedidoUIState
import edu.villablanca.ejercicios.viewmodel.PedidoViewModel

/**
 * @param  pedidoVM  viewmodel para los pedidos
 *  @param onSeleccionado (String)-> Unit devuelve el tipo de masa
 *  Hay dos caminos compatibles para guardar el tipo de masa seleccionado:
 *    1. Actualizar el uistate
 *    2. Devolver el valor y que  PedidoApp lo actualice
 */
@Composable
fun PantallaInicio(
    pedidoVM: PedidoViewModel,
    onSeleccionado: (String)-> Unit,
) {
    // no es necesaria porque pasamos a la siguiente pantalla
     val pedidoEstado by pedidoVM.uiState.collectAsState(PedidoUIState())

    Column(
        modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = "Cliente: ${pedidoEstado.cliente} , tfn = ${pedidoEstado.telefono}")
        Divider()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Image(
            painter = painterResource(id = R.drawable.piza),
            contentDescription ="",
            modifier = Modifier.size(200.dp),
            )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Text(text = "Pide tu Piza",
        style =  MaterialTheme.typography.headlineSmall
            )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
    // Seleccionar tipo de masa
        PTipoMasa {
            onSeleccionado(it)
            pedidoVM.setMasa(it)
        }
    }
}

@Composable
fun PTipoMasa(onElegido: ( String)->Unit){
    val fina = stringResource(R.string.fina)
    val normal = stringResource(R.string.normal)
    val gruesa = stringResource(R.string.gruesa)

    Button(onClick = { onElegido(fina) } ) {
        Text(text = fina)
    }
    Button(onClick = {  onElegido(normal) }) {
        Text(text = normal)
    }
    Button(onClick = {  onElegido(gruesa) }) {
        Text(text = gruesa )
    }

}