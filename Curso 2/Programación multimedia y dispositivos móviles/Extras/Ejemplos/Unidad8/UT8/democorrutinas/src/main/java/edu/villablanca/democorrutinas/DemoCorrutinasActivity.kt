package edu.villablanca.democorrutinas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import edu.villablanca.democorrutinas.libros.LAViewModel
import edu.villablanca.democorrutinas.libros.PantallaLibrosAutores
import edu.villablanca.democorrutinas.ui.theme.Ut8Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Actividad principal
 * Probamos varios corrutinas.
 *
 * Recordar:
 * Dispatcher:
 *   - Main : hilo principal
 *   - Default : Calculos intensivos cpu
 *   - IO  : Entrada/Salida, ej retrofit
 *  
 */
val DCORRUTINAS="DCORRUTINAS"

class DemoCorrutinasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


          /*  GlobalScope.launch {
                val listResult = MarsApi.retrofitService.getPhotos()
                Log.d(DCORRUTINAS,listResult)
            }*/
            /*GlobalScope.launch(Dispatchers.Main) {
                val primos = FuncionIntensiva(20000000)
                Log.d(DCORRUTINAS,primos)
            }*/

        val esViewModel = SimularESViewMode()

        setContent {
            Ut8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   PantallaSimple(esViewModel)
                }
            }
        }
    }


    override fun onStop() {
        super.onStop()
        Log.d(DCORRUTINAS, "salimos con onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(DCORRUTINAS, "salimos con onDestroy")
    }
}


/**
 * Pantalla Ejemplo
 */
@Composable
fun PantallaSimple(
    vModel: SimularESViewMode,
    libroAutor: LAViewModel = LAViewModel()
    ){
    var mensaje by remember {mutableStateOf(1)}
    val ambitoCorrutina: CoroutineScope = rememberCoroutineScope()
    var primos:String   by remember {mutableStateOf("inicial")}
    var  entradaSalida = vModel.uiState.collectAsState()

    var entradaContinua = vModel.continuo.collectAsState()

    var pantallaLibros by remember{ mutableStateOf(false) }

    if(pantallaLibros){
        PantallaLibrosAutores(
                vm= libroAutor,
            {pantallaLibros = false}
            )
    } else {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(R.string.ejemplos_de_corrutinas))

            Button(onClick = {
                ambitoCorrutina.launch(Dispatchers.Main) {
                    withContext(Dispatchers.Default) {
                        primos = FuncionIntensiva(20000000)
                    }

                    // La siguiente instrucción no se ejecuta hasta que termine la corrutina anterior
                    Log.d(DCORRUTINAS, primos)
                }

            }) {
                Text(text = stringResource(R.string.corrutina_n_primos))
            }

            Button(onClick = {
                vModel.procesar()
            }) {
                Text(text = "Iniciar Simular E/S")
            }

            Text(
                text = entradaSalida.value.leido,
                modifier = Modifier.border(1.dp, Color.Red)
            )

            Divider()
            Button(onClick = {
                vModel.procesarContinuo()
            }) {
                Text(text = "Simular Entrada continua")
            }
            Text(
                text = entradaContinua.value,
                modifier = Modifier.border(1.dp, Color.Blue)
            )

            Divider()
            Button(onClick = { pantallaLibros = true }) {
                Text(text = "Pantalla Demo Libros")
            }
            Divider()
            Button(onClick = {
                mensaje++
            }) {
                Text(
                    text = "Prueba Pulsacion"
                )
            }
            Text(text = " Pulsado= $mensaje")
        }
    } // else
}




