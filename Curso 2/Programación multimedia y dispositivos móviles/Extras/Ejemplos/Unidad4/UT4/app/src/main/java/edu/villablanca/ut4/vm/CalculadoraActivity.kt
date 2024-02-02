package edu.villablanca.ut4.vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.input.key.Key.Companion.Calculator
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.ut4.vm.ui.theme.UT4Theme

/**
 * Con estos tutoriales:
 * https://www.droidcon.com/2021/11/19/viewmodels-using-compose-mutablestateflows-or-mutablestates/
 * 
 */
class CalculadoraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaCalculadora()
                }
            }
        }
    }
}


/**
 *  Estados
 */

class CalculatorState {

    var v1 by mutableStateOf("0")
    var v2 by mutableStateOf("0")

    val result get() = sum(v1, v2)
    private fun sum(o1: String, o2: String): String = try {
        (v1.toInt() + v2.toInt()).toString()
    } catch (e: NumberFormatException) {
        "Error conversion numero  🙁"
    }

}


@Composable
fun Calculadora(state: CalculatorState) {
    Column {
        TextField(value = state.v1, onValueChange = { state.v1 = it })
        TextField(value = state.v2, onValueChange = { state.v2 = it })
        Text(text = state.result)
    }
}


@Composable
fun PantallaCalculadora() {
    val state = remember { CalculatorState() }

    Calculadora(state = state)
}