package edu.villablanca.catalogo.pantallas

import android.content.Context
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.villablanca.catalogo.comun.AppBarViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

// Base de url en github con el codigo fuente
const val URL_BASE="https://raw.githubusercontent.com/Villablanca-dam/catalogo/master/app/src/main/java/edu/villablanca/catalogo/componentes/"
/**
 * Pantalla para mostar el código fuente de los ejemplos.
 * Para mejorar la lectura eliminamos los import
 *
 * @param navController
 * @param detailItem Código fuente
 *
 * RECORDAR DAR PERMISOS: <uses-permission android:name="android.permission.INTERNET" />
 *
 */
@Composable
fun PantallaCodigoFuente( vm: AppBarViewModel,navController: NavController, detailItem: String="") {
    var contexto = LocalContext.current
    var textToShow by remember { mutableStateOf("Cargando...") }

   // --> ver por que no funciona la siguiente sentencia
    // val vm: AppBarViewModel = viewModel()
    val uiState = vm.uiState.collectAsState()



    var url = URL_BASE + uiState.value.codigo //  ejemplo "DemoText.kt"

  Log.d("DFUENTE", url)
    /*

        fun loadFileContent(contexto: Context, fileName: String): String {
            return try {
                contexto.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (e: IOException) {
                "Error al cargar el archivo : $fileName"
            }
        }

        textToShow = loadFileContent(contexto, "Demo${detailItem}.kt")
    */


  //  var contenido by remember { mutableStateOf("Cargando...") }

    LaunchedEffect(key1 = Unit) {
        textToShow = leerArchivoDeInternet(url)
    }

   // Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            contentAlignment = Alignment.Center //Alignment.CenterStart

        ) {
            Text(text = textToShow.split("\n") // Divide el texto en líneas
                .filterNot { line -> line.startsWith("import") } // Elimina las líneas que empiezan con "import"
                .filterNot { line -> line.startsWith("package") }
                .joinToString("\n"),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp,Color.Black)
                    .padding(all=10.dp),

                color = Color.Blue
            )
        }

   // }
}



suspend fun leerArchivoDeInternet(url: String): String {
    val cliente = HttpClient()
    return withContext(Dispatchers.IO) {
        try {
            val respuesta: HttpResponse = cliente.get(url)
            if (respuesta.status.value == 200) {
                respuesta.body() // devuelto

            } else {
                "Error: ${respuesta.status.value}"
            }
        } catch (e: Exception) {
            "Error: ${e.localizedMessage}"
        } finally {
            cliente.close()
        }
    }
}