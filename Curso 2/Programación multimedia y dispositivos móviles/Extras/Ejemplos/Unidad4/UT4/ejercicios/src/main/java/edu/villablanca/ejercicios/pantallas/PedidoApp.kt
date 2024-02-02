package edu.villablanca.ejercicios.pantallas

/**
 *
 * --------------------------------------------------------------------------------
 * Centramos la navegacion en este ficheor
 */
import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.villablanca.ejercicios.R
import edu.villablanca.ejercicios.data.PizaDatos
import edu.villablanca.ejercicios.uistates.PedidoUIState

import edu.villablanca.ejercicios.viewmodel.PedidoViewModel

const val ETIQUTA="PIZZA"

/**
 *  Enum de pantallas
 */
enum class Pantallas(@StringRes val titulo: Int){
    Inicio(titulo = R.string.app_name),
    Ingredientes(titulo=R.string.elige_ingredientes),
    Resumen(R.string.resumen_compra)

}
/**
 *  Composable para la navegacion
 *  En una primera versió no incluye login
 *
 *  Al retroceder podemos recordar o no la seleccion
 */
@Composable
fun PedidoApp(
    pedidoVM: PedidoViewModel = PedidoViewModel(),
    navController: NavHostController = rememberNavController()

){
    // El método currentBackStackEntryAsState nos devuelve la ultima entrada del
    // stack (pila) de navegación y lo convierte en estado observable con by
    // La ultima entrada del stack es la pantalla actual
    //
    val topPila by navController.currentBackStackEntryAsState()

    /**
     * valueOf para todos los enum : pasa de un String al enum correspondiente. Si no coincide
     * el string con ninguno  se lanza excepción IllegalArgumentException
     * Observar que pantallaActual no se declara como observable pero si topPila
     */
    val pantallaActual =  Pantallas.valueOf( topPila?.destination?.route ?: Pantallas.Inicio.name)

   /* PantallaIngredientes(
        losIngredietes =  PizaDatos.ingredientes.map { id  -> stringResource(id = id) },
        pedidoVM = pedidoVM,
        { Log.d(ETIQUTA,"siguiente ")}
        )
*/

    //---> [TODO] REVISAR SNAKBAR

    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold (
        topBar = {
            BarraAppSuperior(
                pantallaActual=pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                navegarAtras = { navController.navigateUp()},
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ){pad ->
        // Observamos el esdtado
        val uiState by pedidoVM.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(pad),   // ojo padding aqui es una funcion
        ){
                composable(route =Pantallas.Inicio.name){
                    PantallaInicio(
                        pedidoVM = pedidoVM,
                        onSeleccionado =  {
                            Log.d(ETIQUTA,"elecigo =$it")
                            navController.navigate(Pantallas.Ingredientes.name)
                        })
                    // ya tenemos la selección , siguiente ingredientes:

             }
            composable(route= Pantallas.Ingredientes.name){
                PantallaIngredientes(
                    losIngredietes = PizaDatos.ingredientes.map{  id-> stringResource(id = id)},
                    pedidoVM = pedidoVM ,
                    pedidoUIState = uiState,
                    onSiguiente = {
                        Log.d(ETIQUTA,"APP RESUMEN= ${uiState.num_ingredientes}")
                        navController.navigate(Pantallas.Resumen.name)
                })
            }
            composable(route= Pantallas.Resumen.name){
                Log.d(ETIQUTA,"APP RESUMEN ANTES= ${uiState.num_ingredientes}")
                pedidoVM.calcularPrecio()
                PantallaResumenCompra(pedidoUIState = uiState,
                    onPagar={
                        // futura ventana de caja
                        //por ahora reset
                        pedidoVM.reset()
                        navController.popBackStack(Pantallas.Inicio.name, inclusive = false)  //  vuelve pantalla inicial sin memoria
                    })

            }
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraAppSuperior(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    navegarAtras: ()->Unit
    ){
   TopAppBar(
       title = { Text(text = stringResource(id = pantallaActual.titulo)) },

       colors = TopAppBarDefaults.mediumTopAppBarColors(
           containerColor = MaterialTheme.colorScheme.primaryContainer
       ),
       navigationIcon = {
           if (puedeNavegarAtras) {
               IconButton(onClick = navegarAtras) {
                   Icon(
                       imageVector = Icons.Filled.ArrowBack,
                       contentDescription = stringResource(R.string.back_button)
                   )
               }
           }
       }, // navugationIcon

   )
}