package edu.villablanca.ejercicios.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.ejercicios.R
import edu.villablanca.ejercicios.data.PizaDatos.ingredientes
import edu.villablanca.ejercicios.uistates.PedidoUIState
import edu.villablanca.ejercicios.viewmodel.PedidoViewModel

const val ETIQUETA= "PIZZA"
/**
 *  Para elegir el numero de ingredintes y cuales
 *  Simplificado a un selector multiple que permite solo 2,3 o 4 ingredientes.
 *
 *  Si permitimos que de Resuen -> Ingredientes se mantenga la selección debemo
 *  incluir los ingredientes seleccionados.
 *
 */
@Composable
fun PantallaIngredientes(
    losIngredietes: List<String>,
    pedidoVM: PedidoViewModel,
    pedidoUIState: PedidoUIState,
    onSiguiente: ()->Unit
    ){



    Column {
        Text(text = "Número de ingredientes: ${pedidoUIState.num_ingredientes}")
        Column {
            losIngredietes.forEach{  ingrediente ->
                Row(
                 /*   modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .weight(1f, false),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                   */ verticalAlignment = Alignment.CenterVertically
                ) {
                   // si usamos esta local, no recuperamos el estdado
                    // con el paso atras var estaSeleccionado by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = pedidoUIState.estaSeleccionado(ingrediente),
                        onCheckedChange ={
                            // pedidoUIState = it
                            if (it)
                               pedidoVM.addSeleccionado(ingrediente)
                            else
                                pedidoVM.quitarSeleccionado(ingrediente)
                        })
                    Text(text = ingrediente)
                } //row
            } // losing
            Button(
                onClick ={
                    Log.d(ETIQUETA,"ingredientes num, ${pedidoUIState.num_ingredientes}")
                    onSiguiente()}
            ) {
                Text(text = "Siguiente (pagar)")
            }

        }
    }
}

@Preview
@Composable
fun vistaIngredientes(){
    /*PantallaIngredientes(
        listOf("Queso","Jamon"),
        pedidoVM = PedidoViewModel(),
        {}
    )*/
}