package dam2.pdmm.login.gui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dam2.pdmm.login.R
import dam2.pdmm.login.data.viewmodel.UsuarioVM
import dam2.pdmm.login.utilidades.Boton
import dam2.pdmm.login.utilidades.TextoCuerpo


/**
 * Encapsula todos los elementos gráficos
 * de la pantalla de selección de masa.
 *
 * @param navController NavController que nos permite navegar a otras pantallas de este contexto.
 * @param usuarioVM ViewModel con información sobre los usuarios.
 * */

// Porque se queja el puto IDE si no uso el padding values de la lambda final de scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

// Por algún motivo requiere features del experimental cuando Material3 se supone que ya era estable
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaPizzaPrincipal(navController: NavController, usuarioVM: UsuarioVM) {
    val currentContext = LocalContext.current

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Selección de masa") },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(currentContext, LoginActivity::class.java)
                        currentContext.startActivity(intent)
                    }) {
                        Icon(
                            Icons.Filled.Home,
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
                painter = painterResource(id = R.drawable.cuatroquesos),
                contentDescription = "Imagen principal"
            )

            TextoCuerpo(value = "Selecciona la masa")
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 10.dp, bottom = 10.dp),
                thickness = 2.dp
            )

            Boton(label = "Fina") {
                usuarioVM.usuariosState.tipoMasa = "Fina"
                navController.navigate("pantalla_pizza_ingredientes")
            }

            Boton(label = "Normal") {
                usuarioVM.usuariosState.tipoMasa = "Normal"
                navController.navigate("pantalla_pizza_ingredientes")
            }

            Boton(label = "Roll") {
                usuarioVM.usuariosState.tipoMasa = "Roll"
                navController.navigate("pantalla_pizza_ingredientes")
            }
        }
    }
}
