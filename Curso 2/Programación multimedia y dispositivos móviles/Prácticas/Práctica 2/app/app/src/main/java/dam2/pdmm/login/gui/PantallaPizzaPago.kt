package dam2.pdmm.login.gui

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dam2.pdmm.login.data.viewmodel.UsuarioVM
import dam2.pdmm.login.utilidades.Boton
import dam2.pdmm.login.utilidades.TextoCuerpo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de pago de pedido.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */

// Porque se queja IDE si no uso el padding values de la lambda final de scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

// Por algún motivo requiere features del experimental cuando Material3 se supone que ya era estable
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaPizzaPago(navController: NavController, usuarioVM: UsuarioVM) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Finalizar pago") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("pantalla_pizza_ingredientes") }
                    ) {
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

            var subtotal = 0.0f

            for (item in usuarioVM.usuariosState.ingredientesElegidos) {
                subtotal += item.precioIngrediente
            }

            MostrarSubtotal(subtotal + usuarioVM.usuariosState.precioMasa)

            TextoCuerpo(value = "Detalles de compra")
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )

            Column (
                modifier = Modifier.fillMaxWidth(0.5f),
                verticalArrangement = Arrangement.SpaceBetween

            ) {
                for (ingrediente in usuarioVM.usuariosState.ingredientesElegidos) {
                    Spacer(modifier = Modifier.size(5.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextoCuerpo("${ingrediente.nombreIngrediente}: ")
                        TextoCuerpo("€${ingrediente.precioIngrediente}")
                    }
                }

                Spacer(modifier = Modifier.size(5.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoCuerpo("Masa (${usuarioVM.usuariosState.tipoMasa}): ")
                    TextoCuerpo("€${usuarioVM.usuariosState.precioMasa}")
                }
            }

            Spacer(modifier = Modifier.size(10.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )

            Spacer(modifier = Modifier.size(10.dp))
            TextoCuerpo(value = "Detalles de cliente")
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )

            Column (
                modifier = Modifier.fillMaxWidth(0.7f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoCuerpo("Nombre: ")
                    TextoCuerpo("${usuarioVM.usuariosState.usuarioActual?.username}")
                }

                Spacer(modifier = Modifier.size(5.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoCuerpo("Email: ")
                    TextoCuerpo(value = "${usuarioVM.usuariosState.usuarioActual?.email}")
                }

                Spacer(modifier = Modifier.size(5.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoCuerpo("Teléfono: ")
                    TextoCuerpo(value = "${usuarioVM.usuariosState.usuarioActual?.phoneNumber}")
                }
            }

            var pagoFinalizado by rememberSaveable { mutableStateOf(false) }

            // Asumimos que el current context es nuestra actividad Pizza
            val currentContext = LocalContext.current
            val coroutineScope = rememberCoroutineScope()

            Spacer(modifier = Modifier.size(5.dp))
            Boton(label = "Pagar") {
                val activity = (currentContext as? ComponentActivity)

                coroutineScope.launch {
                    pagoFinalizado = true
                    delay(3000)
                    activity?.finish()
                }
            }

            if (pagoFinalizado) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Pago en proceso",
                        style = TextStyle(color = Color.Green, fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
    }
}

/**
 * Utilidad de la pantalla de pago que muestra
 * el total a pagar por el pedido.
 *
 * @param subtotal Valor total a pagar
 * */
@Composable
fun MostrarSubtotal(subtotal: Float) {
    val entera = subtotal.toInt()
    val decimal = abs(((entera - subtotal) * 100).toInt())

    Row (
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "€",
            style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
        )

        Text(
            text = "$entera",
            style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
        )

        Text(
            text = "'",
            style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
        )

        Text(
            text = "$decimal",
            style = TextStyle(fontSize = 50.sp, fontWeight = FontWeight.Bold)
        )
    }
}