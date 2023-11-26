 
package edu.villablanca.felicitacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.felicitacion.ui.theme.FelicitacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FelicitacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal()
                }
            }
        }
    }
}


@Composable
fun Eje() {
    Text(
        text = "Felicidades",

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(modifier: Modifier= Modifier) {
   var miTexto by remember{ mutableStateOf("")}

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Eje()
        TextField(value =  miTexto , onValueChange = {
        })

        Text(text = miTexto )
        Button(onClick = { miTexto = "Cualquier valor" }) {
            Text(text = "pulsa")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FelicitacionTheme {
        PantallaPrincipal()
    }
}
