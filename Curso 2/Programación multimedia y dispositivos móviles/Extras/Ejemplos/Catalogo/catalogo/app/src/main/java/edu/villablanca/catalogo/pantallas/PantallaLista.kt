package edu.villablanca.catalogo.pantallas


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.comun.AppBarViewModel
import edu.villablanca.catalogo.navegacion.Destino


/**
 *
 * Pantalla con la lista de componentes
 * @param  navController
 */
@Composable
fun PantallaLista(listaComp: List<DemoComponente> ,
                  navController: NavController) {


    /**
     * Obtiene la instancia para este contexto de AppBarViewModel o crea
     * una si no existe
     */

    val appViewModel: AppBarViewModel = viewModel()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // item { Text(text = "Estoy en la PantallaLista") }

        items(listaComp) { destino ->
            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                onClick =  {

                    navController.navigate(destino.ruta)
                }
            ) {
                Text(
                    text =" ${destino.ruta}",
                )
            }


        }
    }
}