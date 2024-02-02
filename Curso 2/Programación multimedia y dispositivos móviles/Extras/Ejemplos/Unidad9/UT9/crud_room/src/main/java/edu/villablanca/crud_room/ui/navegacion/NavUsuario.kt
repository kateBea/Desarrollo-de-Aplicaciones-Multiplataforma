package edu.villablanca.crud_room.ui.navegacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.crud_room.ui.pantallas.PantallaAgregar
import edu.villablanca.crud_room.ui.theme.pantallas.PantallaEditar
import edu.villablanca.crud_room.ui.theme.pantallas.PantallaInicio
import edu.villablanca.crud_room.viewmodel.UsuarioViewModel


enum class Destinos(val ruta: String) {
    INICIO("INICIO"),
    AGREGAR("AGREGAR"),
    EDITAR("EDITAR")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavUsuario(usuarioViewModel: UsuarioViewModel) {
    val controlNav = rememberNavController()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "CRUDDEMO") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        contentColor = Color.LightGray,

        ) {

        Column(
            modifier = androidx.compose.ui.Modifier.padding(it)

        ){
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
}
}

