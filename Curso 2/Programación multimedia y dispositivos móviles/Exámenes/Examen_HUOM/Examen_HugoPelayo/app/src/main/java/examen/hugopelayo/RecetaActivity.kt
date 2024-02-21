package examen.hugopelayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import examen.hugopelayo.data.recetas.RecetaVM
import examen.hugopelayo.gui.recetapantallas.PantallaPrincipalRecetas
import examen.hugopelayo.gui.recetapantallas.PantallasReceta
import examen.hugopelayo.gui.recetapantallas.RutasReceta

class RecetaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val recetaVM = viewModel<RecetaVM>()

            NavHost(
                navController = navController,
                startDestination = RutasReceta.PantallaPrincipal.ruta
            ) {
                composable(RutasReceta.PantallaPrincipal.ruta) {
                    PantallaPrincipalRecetas(navController)
                }

                composable(RutasReceta.PantallaReceta.ruta) {
                    PantallasReceta(navController, recetaVM)

                }
            }
        }
    }
}