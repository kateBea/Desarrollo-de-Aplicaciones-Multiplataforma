package edu.villablanca.ut3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.ut3.ui.theme.UT3Theme

/**
 * DEMO de actividad que responde a varios intent
 *
 * ACCION_PREGUNTA devuelve un valor a la actividad llamante
 */
class PreguntaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var esSimple= false
        var esPregunta = false
        var laPregunta =""

     when(intent.action){
         Intent.ACTION_VIEW -> {
             // Manejar la acción de visualización (por ejemplo, abrir un enlace web)
             val uri = intent.data
             // Hacer algo con el URI
         }
         "com.ejemplo.ACCION_SIMPLE" -> {
             esSimple= true
         }
         "com.ejemplo.ACCION_PREGUNTA" -> {
             esPregunta = true
             laPregunta = intent.getStringExtra("PREGUNTA") ?: "falla pregunta"
         }
     }


        setContent {
            UT3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PantallaPregunta(esSimple,
                        esPregunta,
                        pregunta = laPregunta
                    ){
                        devolverResultado(it)
                    }
                }
            }
        }
    }

    fun devolverResultado(res: String){
        val ri = Intent()
        ri.putExtra("RESPUESTA", res)
        setResult(Activity.RESULT_OK, ri)
        finish()
    }
}


/**
 * Pantalla lanza la pegunta y recoge la respuesta
 */
@Composable
fun PantallaPregunta(simple: Boolean,
                     esPregunta: Boolean ,
                     pregunta: String ,
                     onRespuesta: (String)-> Unit
                     ) {

    var respuesta by remember { mutableStateOf("") }

    Column {
        Text(
            text = "Pregunta: $pregunta "
        )

        OutlinedTextField(
            value = respuesta,
            label = { Text(text = pregunta)},
            onValueChange = {respuesta = it},
            )
        Button(onClick = { onRespuesta(respuesta) } ) {
            Text(text = "Responder")
        }

    }

}
