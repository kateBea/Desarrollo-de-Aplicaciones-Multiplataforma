package edu.villablanca.ut3.pantallas

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

import edu.villablanca.ut3.Actividad_B
import edu.villablanca.ut3.Actividad_C
import edu.villablanca.ut3.CicloVidaActivity
import edu.villablanca.ut3.PreguntaActivity


/**
 * La función composable no tiene el contexto. Para obtenerlo suamos LocalContext
 * La variable contexto debe tener ambito de funcion (no de la lambda)
 * Observar que startActivity es un meotod de Context
 */
@Composable
fun PantallaPrincipal(resultadoLauncher: ActivityResultLauncher<Intent>,
                      onCerrar: () -> Unit
) {
    val contexto = LocalContext.current
    var intencionB = Intent(contexto, Actividad_B::class.java)
    var intencionC = Intent(contexto, Actividad_C::class.java)
    var intencionCiclo = Intent(contexto, CicloVidaActivity::class.java)



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "DEMOSTRACION ACTIVITY",
            fontSize = 24.sp,
        )
        Button(
            onClick = {
                intencionB.putExtra("descripcion", "ejemplo intent explicita  con bundle")
                contexto.startActivity(intencionB)
            }
        ){
            Text(text = "Iniciar Actividad B")
        }

        Button(
            onClick = {
                var intencionPregunta = Intent( "com.ejemplo.ACCION_PREGUNTA" ).apply {
                    putExtra("PREGUNTA","¿Cual es tu color favorito?")
                   // resultadoLauncher.launch(this)
                }
                resultadoLauncher.launch(intencionPregunta)
           }
        ) {
            Text(text = "Actividad Pregunta/Respuesta")
        }
        Button(
            onClick = {
                contexto.startActivity(intencionC)
            }
        ){
            Text(text = "Actividad demo Implicit Intent")
        }
        Button(
            onClick = {
                contexto.startActivity(intencionCiclo)
            }
        ){
            Text(text = "Actividad demo de ciclo de vida de Activity")
        }
    }
}