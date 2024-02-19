package dam2.pdmm.login.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room.databaseBuilder
import dam2.pdmm.login.data.db.UsuarioDB
import dam2.pdmm.login.data.viewmodel.UsuarioVM

/**
 * Actividad principal que representa la pantalla de inicio de sesión de la aplicación.
 * */
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = databaseBuilder(
            this, UsuarioDB::class.java, "pizzeros")
            .fallbackToDestructiveMigration()
            .build()

        setContent {
            EntryPoint(UsuarioVM(database.usuarioRepository()))
        }
    }
}

/**
 * Representa el punto de entrada principal de la la actividad LoginActivity.
 * Gestiona la navegación entre las diferentes pantallas de la aplicación.
 *
 * @param usuarioVM ViewModel que proporciona la lógica de negocio y gestiona los datos de usuario.
 */
@Composable
fun EntryPoint(usuarioVM: UsuarioVM) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantalla_inicio"
    ) {
        composable("pantalla_inicio") {
            PantallaInicio(navController, usuarioVM)
        }

        composable("pantalla_registro") {
            PantallaRegistro(navController, usuarioVM)
        }
    }
}