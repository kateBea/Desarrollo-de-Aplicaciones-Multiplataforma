package examen.hugopelayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import examen.hugopelayo.gui.adivinarpantallas.PantallaLeerValores
import examen.hugopelayo.gui.adivinarpantallas.PantallaPrincipalAdivinar
import examen.hugopelayo.gui.adivinarpantallas.RutasAdivinar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = RutasAdivinar.PantallaPrincipal.ruta
            ) {
                composable(RutasAdivinar.PantallaPrincipal.ruta) {
                    PantallaPrincipalAdivinar(navController)
                }

                composable(RutasAdivinar.PantallaJuego.ruta) {
                    PantallaLeerValores(navController)
                }
            }
        }
    }
}