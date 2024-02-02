package edu.villablanca.ut4.navi.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.ut4.vm.ui.pantallas.PantallaPrincipal
import edu.villablanca.ut4.navi.ui.pantallas.Pantalla1
import edu.villablanca.ut4.navi.ui.pantallas.Pantalla2


/**
 * En esta función crea la navegación entre ventanas
 *
 */
@Composable
fun NavGraph(){
    var nc = rememberNavController()

    NavHost(navController = nc, startDestination = Destinos.PantallaUno.ruta ){
        composable(Destinos.PantallaPrincipal.ruta){
            PantallaPrincipal (
                onNavegar = { nc.navigate( Destinos.PantallaPrincipal.ruta )  }
            )
        }
        // En Pantalla1 pasamos la lambda para el boton de enviar
        // La ruta destino lleva un parámetro como le indicamos de Destino
        //Por ejemplo se introducimos en Pantalla1 el texto "Pepe"
        // la ruta es "Pantalla2/Pepe"
        composable(Destinos.PantallaUno.ruta){
            Pantalla1(
                onNavegar = {
                    nc.navigate(Destinos.PantallaDos.crearRuta(it))}
            )
        }
        // A diferencia del composable anterior, en este Destinos.PantallaDos.ruta le estamo
        // dicieno que contiene un parámetro que se extrae en la primera sentencia.
        // El parámetro se identifica con "newText" como indicamos en Destinos

        composable(Destinos.PantallaDos.ruta){ nvse ->
            var nuevoTexto = nvse.arguments?.getString("newText")
            Pantalla2(nuevoTexto!!)
        }
    }
}