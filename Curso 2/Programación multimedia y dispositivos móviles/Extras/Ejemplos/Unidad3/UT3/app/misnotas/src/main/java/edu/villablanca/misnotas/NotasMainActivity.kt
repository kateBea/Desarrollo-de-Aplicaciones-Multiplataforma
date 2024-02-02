package edu.villablanca.misnotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.actions.NoteIntents
import edu.villablanca.misnotas.pantallas.PantallasNotas
import edu.villablanca.misnotas.ui.theme.UT3Theme

class NotasMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // no usamos EXTRANAME
        val nuevaNota = intent.getStringExtra(NoteIntents.EXTRA_TEXT) ?: "nada"


        setContent {
            UT3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallasNotas(nuevaNota)
                }
            }
        }
    }
}

