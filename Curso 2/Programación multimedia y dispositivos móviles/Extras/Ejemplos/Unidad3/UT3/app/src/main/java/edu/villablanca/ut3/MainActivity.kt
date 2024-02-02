package edu.villablanca.ut3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.villablanca.ut3.pantallas.PantallaPrincipal
import edu.villablanca.ut3.ui.theme.UT3Theme

class MainActivity : ComponentActivity() {
    private lateinit var resultadoLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Para la respuesta de PreguntaActivity
         */
        resultadoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Manejar el resultado
                val data: Intent? = result.data
                Log.d("DPREGUNTA", data?.getStringExtra("RESPUESTA") ?: "sin respuesta")

            }
        }
        setContent {
            UT3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  PantallaPrincipal(resultadoLauncher) {finish()}

                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("DMain","MainActivity entra en pausa")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DMain","MainActivity entra en stop")
    }
}
