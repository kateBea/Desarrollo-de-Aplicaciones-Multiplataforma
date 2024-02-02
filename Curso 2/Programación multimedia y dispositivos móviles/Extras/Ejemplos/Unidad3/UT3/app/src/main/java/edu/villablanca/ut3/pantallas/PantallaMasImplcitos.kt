package edu.villablanca.ut3.pantallas

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.actions.NoteIntents
import java.util.Calendar

enum class PANTALASIMPLICIT {
    PRIMERA,
    ALARMA
}

@Composable
fun PantallaMasImplicitos(onBack: () -> Unit) {
    var pantalla by remember { mutableStateOf(PANTALASIMPLICIT.PRIMERA) }
    var yaAlarma by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "OTROS EJEMPLOS IMPLICIT INTET")

        TestWeb()

        TestNota()

        Button(
            onClick = { pantalla = PANTALASIMPLICIT.ALARMA },
            enabled = yaAlarma == false
        ) {
            Text(text = "Alarma (1 min)")
        }

        Button(onClick = onBack) {
            Text(text = "Volver")
        }

        // Ejecutamos
        when (pantalla) {
            PANTALASIMPLICIT.PRIMERA -> {}
            PANTALASIMPLICIT.ALARMA -> TestAlarma {
                pantalla = PANTALASIMPLICIT.PRIMERA
                yaAlarma = true
            }
        }
    }
}



@Composable
fun TestWeb(){
    val contexto = LocalContext.current

    var verPagina by  remember{ mutableStateOf(false) }
    val webpage: Uri = Uri.parse("http://www.github.com/")

    val intent = Intent(Intent.ACTION_VIEW,webpage )

    Column(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Button(onClick = { verPagina = true }
        ) {
            Text(text = "Abrir página web")
        }
    }

    if (verPagina) {
        LaunchedEffect("Clave_de_alarma") {

          //  startActivity(contexto, intent, null)
            if (intent.resolveActivity(contexto.packageManager) != null) {
                startActivity(contexto, intent, null)
                Log.d("PWEB", "Enviado intent WEB")
            } else{
                Log.d("PWEB", "NO HAY ACTIVIDAD PARA WEB")
            }
        } // Launch...
    }
}
/**
 * Para NoteIntents.ACTION_CREATE_NOTE necesita la dependencia
 */

@Composable
fun TestNota() {
    val ACTION_CREATE_NOTE = "com.google.android.keep.intent.action.CREATE_NOTE"
    var insertarNota by remember { mutableStateOf(false) }


    val tema = "Pruebas con Intents"
    val mensaje = "Nota de pruebas para iniciar Activity de notas"
    val contexto = LocalContext.current

    val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
        putExtra(NoteIntents.EXTRA_NAME, tema)
        putExtra(NoteIntents.EXTRA_TEXT, mensaje)
    }

    Column(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )
    {
        Button(onClick = { insertarNota = true }
        ) {
            Text(text = "Insertar nota")
        }
    }

    if (insertarNota) {
        LaunchedEffect("Clave_de_alarma") {
            try {
                startActivity(contexto, intent, null)
            } catch ( e: ActivityNotFoundException) {
                // Manejar la excepción aquí
               Log.d("DNOTAS" ,"No se encontró una aplicación compatible")
            }
            /**
            if (intent.resolveActivity(contexto.packageManager) != null) {
                startActivity(contexto, intent, null)
                Log.d("DNOTAS", "Enviado intent")
            } else{
                Log.d("DNOTAS", "NO HAY ACTIVIDAD PARA NOTAS")
            }
            **/
        } // Launch...
    }
}

/**
 * RECORDAD: permiso <uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
 */
@Composable
fun TestAlarma(onfin: () -> Unit) {
    val contexto = LocalContext.current
    // Obteniendo la hora y minutos actuales
    val calendar = Calendar.getInstance().apply {
        add(Calendar.MINUTE, 1) // Añadir un minuto a la hora actual
    }
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minutes = calendar.get(Calendar.MINUTE)
    val message = "Test Alarma"

    /**
     * Al usar la clave_de_alarma se consigue que solamente se ejecute el LaunchedEffect
     * en la composición, evitanto que se ejecute en cada recomposicion
     * LaunchedEffect no inicia en si una corrutina (pero podría). Se utiliza para
     * iniciar/lanzar efectos secundarios.
     * Incluye una Scope de corrutina
     */
    LaunchedEffect("Clave_de_alarma") {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(contexto.packageManager) != null) {
            startActivity(contexto, intent, null)
            Log.d("Alarma", "Intent de alarma enviado")
        } else {
            Log.d("Alarma", "No hay actividad para manejar el intent de alarma")
        }
        onfin()
    }


}