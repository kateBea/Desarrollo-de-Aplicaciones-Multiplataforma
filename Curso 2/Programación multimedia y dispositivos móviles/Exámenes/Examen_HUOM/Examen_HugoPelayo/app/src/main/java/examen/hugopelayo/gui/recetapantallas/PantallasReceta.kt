package examen.hugopelayo.gui.recetapantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import examen.hugopelayo.data.recetas.RecetaState
import examen.hugopelayo.data.recetas.RecetaVM
import examen.hugopelayo.utilidades.CardRecetaScreen
import examen.hugopelayo.utilidades.TextoBienvenida
import examen.hugopelayo.utilidades.TextoCuerpo

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallasReceta(navController: NavController, recetaVM: RecetaVM = viewModel()) {
    // Seleccionar receta actual (estamos seguros de que hay receta seleccionada)
    val recetaState: RecetaState? = recetaVM.receta.collectAsState().value
    val receta = recetaState!!.recetaActual

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Información de receta") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(RutasReceta.PantallaPrincipal.ruta) }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Pantalla inicial"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0.43f, 0.47f, 0.98f, 1f)))
        }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .fillMaxHeight(0.2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextoBienvenida(receta!!.titulo)
                CardRecetaScreen(painter = painterResource(id = receta.imagen))
            }

            Column (
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                TextoCuerpo(value = "Duración")
                Text(
                    text = "${receta!!.duracion} minutos",
                    style = TextStyle(
                        color = Color(0.43f, 0.47f, 0.98f, 1f)))

                Spacer(modifier = Modifier.height(5.dp))
                TextoCuerpo(value = "Ingredientes")
                Text(
                    text = receta.ingredientes,
                    style = TextStyle(
                        color = Color(0.43f, 0.47f, 0.98f, 1f)))

                Spacer(modifier = Modifier.height(5.dp))
                TextoCuerpo(value = "Pasos")
                Text(
                    text = receta.pasos,
                    style = TextStyle(
                        color = Color(0.43f, 0.47f, 0.98f, 1f)))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallasRecetaPrev(func: @Composable () -> Unit = {}) {
    PantallasReceta(rememberNavController())
}