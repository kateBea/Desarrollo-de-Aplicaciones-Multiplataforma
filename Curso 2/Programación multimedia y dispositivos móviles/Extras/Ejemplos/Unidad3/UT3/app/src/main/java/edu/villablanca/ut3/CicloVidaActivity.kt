package edu.villablanca.ut3

import android.R.*
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.ut3.pantallas.PantallaPrincipal
import edu.villablanca.ut3.ui.theme.UT3Theme


class CicloVidaActivity : ComponentActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d(TAG, "onCreate() llamado")
    setContent {
        UT3Theme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                PantallaCiclo {finish()}

            }
        }
    }
}



    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() llamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() llamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() llamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() llamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() llamado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() llamado")
    }

    companion object {
        private const val TAG = "DemoCiclo"
    }
}

@Composable
fun PantallaCiclo(onSalir: () -> Unit) {
Column(
    modifier = Modifier.fillMaxWidth(0.9f),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
) {
    Text(text = "DEMO CICLO DE VIDA",
        fontSize = 24.sp,
        textAlign = TextAlign.Center
        )
    Button(onClick = onSalir) {
        Text(text = "Cerrar y salir")
    }
    Text(
        text = "Para seguir el ciclo de vida, abrid logcat y filtrar el LOG  por \"tag:DemoCiclo\" ",
        modifier = Modifier.fillMaxWidth(0.8f),

    )
    Image(
        painter = painterResource( R.drawable.demociclo),
        contentDescription = "filtro en logcat"
    )
    Divider()
    Image(
        painter = painterResource(id = R.drawable.activity_ciclo),
        contentDescription = "Grafico ciclo de vida Activity",
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Red),
        contentScale = ContentScale.Crop
    )
}
}