package org.ventas.pizzamaanager.interfaz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ventas.pizzamaanager.interfaz.PantallaInicio


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Lista de composables para preview
}