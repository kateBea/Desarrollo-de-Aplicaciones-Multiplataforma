package edu.villablanca.catalogo.pantallas

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.villablanca.catalogo.R
import edu.villablanca.catalogo.componentes.DemoAutoCompleteText
import edu.villablanca.catalogo.componentes.DemoBasicTextField
import edu.villablanca.catalogo.componentes.DemoButton
import edu.villablanca.catalogo.componentes.DemoCanvas
import edu.villablanca.catalogo.componentes.DemoCard
import edu.villablanca.catalogo.componentes.DemoCheckBox
import edu.villablanca.catalogo.componentes.DemoChip
import edu.villablanca.catalogo.componentes.DemoDialog
import edu.villablanca.catalogo.componentes.DemoIconButton
import edu.villablanca.catalogo.componentes.DemoImage
import edu.villablanca.catalogo.componentes.DemoLazyGrid
import edu.villablanca.catalogo.componentes.DemoMenus
import edu.villablanca.catalogo.componentes.DemoProgressBar
import edu.villablanca.catalogo.componentes.DemoRadioButton
import edu.villablanca.catalogo.componentes.DemoRatingBox
import edu.villablanca.catalogo.componentes.DemoSlider
import edu.villablanca.catalogo.componentes.DemoSnackBar
import edu.villablanca.catalogo.componentes.DemoSwitch
import edu.villablanca.catalogo.componentes.DemoText
import edu.villablanca.catalogo.componentes.DemoTextField
import edu.villablanca.catalogo.comun.AppBarViewModel
import edu.villablanca.catalogo.navegacion.Destino




 data class  DemoComponente(
    val ruta: String,
    val funcion: @Composable () -> Unit,
     val fuente: String

)

internal val losComponentes = listOf<DemoComponente>(
    DemoComponente("Texto", { DemoText() }, "DemoText.kt"),
    DemoComponente("Texto Entrada", { DemoTextField() }, "DemoTextField.kt"),
    DemoComponente("Boton", { DemoButton()}, "DemoButton.kt"),
    DemoComponente("CheckBox", { DemoCheckBox()}, "DemoCheckBox.kt"),
    DemoComponente("Switch", { DemoSwitch() }, "DemoSwitch.kt"),
    DemoComponente("Texto autocompletado", { DemoAutoCompleteText() }, "DemoAutoCompleteText.kt"),
    DemoComponente("Texto Basico Entrada", { DemoBasicTextField() }, "DemoBasicTextField.kt"),
    DemoComponente("Gráficos Canvas", { DemoCanvas() }, "DemoCanvas.kt"),
    DemoComponente("Card", { DemoCard() }, "DemoCard.kt"),
    DemoComponente("Chip", { DemoChip() }, "DemoChip.kt"),
    DemoComponente("Check Box", { DemoCheckBox() }, "DemoCheckBox.kt"),

    DemoComponente("Dialogos ", { DemoDialog() }, "DemoDialog.kt"),
    DemoComponente("Botón Icono", { DemoIconButton() }, "DemoIconButton.kt"),
    DemoComponente("Imagenes", { DemoImage() }, "DemoImagen.kt"),
    DemoComponente("Menus", { DemoMenus() }, "DemoMenus.kt"),
    DemoComponente("Progress Bar", { DemoProgressBar() }, "DemoProgressBar.kt"),
    DemoComponente("Radio Button", { DemoRadioButton() }, "DemoRadioButton.kt"),
    DemoComponente("Rating Box", { DemoRatingBox() }, "DemoRatingBox.kt"),
    DemoComponente("Slider", { DemoSlider() }, "DemoSlider.kt"),
    DemoComponente("Snack Bar", { DemoSnackBar() }, "DemoSnackBar.kt"),
    DemoComponente("Lazy Grid", {DemoLazyGrid()}, "DemoLazyGrid.kt")
)
/**
 * Pantalla principal con scaffold y navegación.
 * La listda de componentes se encuetna en PantallaLista
 *
 * @param context:  Contexto de la Activity. Podríamos obtenerlo localmente
 *  con LocalContext.current
 */

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaPrincipal(context: Context, modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val appBarViewModel: AppBarViewModel = viewModel()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MiTopAppBar(appBarViewModel = appBarViewModel, navController = navController) }
    ) { paddingValues ->
        NavHost(navController = navController,
            startDestination = Destino.PLista.ruta,
            modifier= Modifier
                .fillMaxWidth()
                .padding(paddingValues)
            ) {
            composable(Destino.PLista.ruta) {
                appBarViewModel.actualizarTitulo("Demo Componentes")
                appBarViewModel.actualizarCodigoFuente("")
                PantallaLista(losComponentes, navController = navController) }
            composable(Destino.PCodigoFuente.ruta)   {
                 PantallaCodigoFuente(appBarViewModel,navController)}

            losComponentes.forEach { comp ->

                composable(comp.ruta) {
                    appBarViewModel.actualizarTitulo(comp.ruta)
                    appBarViewModel.actualizarCodigoFuente(comp.fuente)
                    comp.funcion.invoke() }
        }


        }
    } // de scaffikd
}


/**
 *   Barra de app superior
 *   Incluye el enlace al código fuente usando appBarViewModel
 *
 *
 *   @param appBarViewModel ViewModel
 *   @param navController
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopAppBar(appBarViewModel: AppBarViewModel, navController: NavController) {
    val titulo = appBarViewModel.titulo.collectAsState()
    val uiState = appBarViewModel.uiState.collectAsState()

    TopAppBar(
        title = { Text(text = titulo.value ) },
        navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.atras))
                }
        } , //
        actions ={
            if (uiState.value.codigo =="") {
                Text(text = "--")
            } else {
                IconButton(onClick = { navController.navigate(Destino.PCodigoFuente.ruta) }) {

                    Icon(Icons.Filled.Edit, contentDescription = stringResource(R.string.codigo))
                }
            }
        }


    )
}