package dam2.pdmm.login.gui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dam2.pdmm.login.R
import dam2.pdmm.login.data.LISTA_COMPLETA_DE_INGREDIENTES
import dam2.pdmm.login.data.viewmodel.UsuarioVM
import dam2.pdmm.login.utilidades.Boton
import dam2.pdmm.login.utilidades.IngredientePrecioCantidad
import dam2.pdmm.login.utilidades.CasillaSeleccion
import dam2.pdmm.login.utilidades.TextoCuerpo


/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de selección de ingredientes.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */

// Porque se queja el puto IDE si no uso el padding values de la lambda final de scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

// Por algún motivo requiere features del experimental cuando Material3 se supone que ya era estable
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaPizzaIngredientes(navController: NavController, usuarioVM: UsuarioVM) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Selección de ingredientes") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("pantalla_pizza_principal") }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Menú"
                        )
                    }
                })
        }) {

        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.
                size(256.dp),
                painter = painterResource(id = R.drawable.pizzaingredients),
                contentDescription = "Imagen principal"
            )

            TextoCuerpo(value = "Selecciona los ingredientes")
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )


            for (ingrediente in LISTA_COMPLETA_DE_INGREDIENTES) {
                CasillaSeleccion(label = ingrediente) {
                    if (it) {
                        val precioIngrediente = 0.5f
                        val cantidadIngrediente = 1

                        usuarioVM.usuariosState.setIngredientesElegido(
                            IngredientePrecioCantidad(ingrediente, precioIngrediente, cantidadIngrediente)
                        )
                    } else {
                        usuarioVM.usuariosState.removeIngredienteElegido(ingrediente)
                    }
                }
            }
            
            Boton(label = "Finaliza compra") {
                navController.navigate("pantalla_pizza_pago")
            }
        }
    }
}