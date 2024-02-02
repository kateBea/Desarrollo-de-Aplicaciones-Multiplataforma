package edu.villablanca.invitacion

/**
 * @author
 * @fecha:
 * @version:
 * Descripción:
 *   Ventana con tres partes: Un mensaje fijo, un campo de entrada y un botón
 *
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import edu.villablanca.invitacion.ui.theme.DiceRollerTheme

/**
 * Activity
 */
class InvitacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Invitacion("Feliz Cumpleaños","Droid")
                }
            }
        }
    }
}

/**
 * @param  mensaje texto con la felicitación
 * @param deFirma: quien felicita
 *    El botón borra el mensaje
 */    
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Invitacion(mensaje: String, deFirma: String, modifier: Modifier = Modifier) {
    var segundaLinea by remember { mutableStateOf(deFirma) }

    var tam by remember { mutableStateOf(20) }

    Column {
        Text(
            text = mensaje,
            modifier = modifier,
            fontSize = tam.sp,   // Tambien sirve para cambiar otros valores
            lineHeight = 116.sp

        )
        Text(
            text= segundaLinea,
            fontSize = 36.sp
        )
        TextField(value = segundaLinea , onValueChange = {leido -> segundaLinea = leido} )
        Button(onClick = { tam=100 }) {
            Text(text = "enviar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InvitacionPreview() {
    DiceRollerTheme {
        Invitacion("Feliz Cumpleaños","Droid")
    }
}