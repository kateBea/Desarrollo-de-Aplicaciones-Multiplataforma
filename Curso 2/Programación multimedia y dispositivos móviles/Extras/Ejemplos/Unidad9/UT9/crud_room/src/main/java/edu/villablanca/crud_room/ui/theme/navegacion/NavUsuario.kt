package edu.villablanca.crud_room.ui.theme.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.crud_room.ui.pantallas.PantallaAgregar
import edu.villablanca.crud_room.ui.theme.pantallas.PantallaEditar
import edu.villablanca.crud_room.ui.theme.pantallas.PantallaInicio
import edu.villablanca.crud_room.viewmodel.UsuarioViewModel


/**
 * Rutas para las ventantas
 */
enum class Destinos(val ruta: String) {
    INICIO("INICIO"),
    AGREGAR("AGREGAR"),
    EDITAR("EDITAR")
}

/**
 * Navegación
 * @param usuarioViewModel compartimos explicitamente el viewmodel entre pantallas
 */
@Composable
fun NavUsuario(usuarioViewModel: UsuarioViewModel) {
    val controlNav = rememberNavController()
    NavHost(navController = controlNav, startDestination = Destinos.INICIO.ruta) {
        composable(Destinos.INICIO.ruta) {
            PantallaInicio(controlNav, usuarioViewModel)
        }
        composable(Destinos.AGREGAR.ruta) {
            PantallaAgregar(controlNav, usuarioViewModel)
        }
        composable(Destinos.EDITAR.ruta) {
            PantallaEditar(controlNav, usuarioViewModel)
        }
    }
}

