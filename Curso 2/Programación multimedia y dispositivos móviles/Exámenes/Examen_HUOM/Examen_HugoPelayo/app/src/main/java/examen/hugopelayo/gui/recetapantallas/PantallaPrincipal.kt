package examen.hugopelayo.gui.recetapantallas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import examen.hugopelayo.data.recetas.RecetaVM
import examen.hugopelayo.data.recetas.listaRecetas
import examen.hugopelayo.utilidades.RecetaCard

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaPrincipalRecetas(
    navController: NavController,
    recetaVM: RecetaVM = viewModel()
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Selección de receta") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(RutasReceta.PantallaPrincipal.ruta) }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Pantalla inicial"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0.43f, 0.47f, 0.98f, 1f)
                ))
        }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Lista de recetas
            for (receta in listaRecetas) {
                RecetaCard(
                    painter = painterResource(id = receta.imagen),
                    nombreReceta = receta.titulo,
                    tiempoMins = receta.duracion
                ) {
                    recetaVM.setRecetaActual(receta)
                    navController.navigate(RutasReceta.PantallaReceta.ruta)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(func: @Composable () -> Unit = {}) {
    PantallaPrincipalRecetas(rememberNavController())
}