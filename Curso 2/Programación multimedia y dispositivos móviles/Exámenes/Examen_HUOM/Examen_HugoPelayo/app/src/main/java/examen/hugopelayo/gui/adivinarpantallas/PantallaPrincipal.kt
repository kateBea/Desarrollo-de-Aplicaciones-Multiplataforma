package examen.hugopelayo.gui.adivinarpantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import examen.hugopelayo.utilidades.Boton
import examen.hugopelayo.utilidades.CampoEntrada
import examen.hugopelayo.utilidades.SmallTextError
import examen.hugopelayo.utilidades.SmallTextValid
import examen.hugopelayo.utilidades.TextoBienvenida
import java.lang.Exception
import java.time.LocalDate
import kotlin.random.Random

var numSecreto: Int = -1

@Composable
fun PantallaPrincipalAdivinar(navController: NavController) {
    var esValido by rememberSaveable { mutableStateOf(true) }
    var errorTexto by  rememberSaveable { mutableStateOf("") }

    var min by rememberSaveable { mutableStateOf("") }
    var max by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextoBienvenida(contenido = "Introduce límites")
        CampoEntrada(label = "Valor mínimo") { min = it}
        CampoEntrada(label = "Valor máximo") { max = it}

        if (!esValido) {
            SmallTextError(error = errorTexto)
        }

        Boton(label = "Iniciar partida") {

            // validar entrada
            var minInt: Int? = min.toIntOrNull()
            var maxInt: Int? = max.toIntOrNull()

            if ((minInt != null).and(maxInt != null)) {
                numSecreto = Random(LocalDate.now().toEpochDay()).
                    nextInt(minInt!!, maxInt!!)

                navController.navigate(RutasAdivinar.PantallaJuego.ruta)
            } else {
                errorTexto = "Entrada inválida"
                esValido = false
            }
        }
    }
}

@Composable
fun PantallaLeerValores(navController: NavController) {
    var openDialog by rememberSaveable { mutableStateOf(false) }
    var valorIntroducido by rememberSaveable { mutableStateOf("") }
    var valorIntroducidoInt by rememberSaveable { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextoBienvenida(contenido = "Adivina el número secreto")
        CampoEntrada(label = "Introduce un valor") { valorIntroducido = it }

        Boton(label = "Comprobar") {
            openDialog = true
        }

        if (openDialog) {
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    openDialog = false
                },
                title = {
                    TextoBienvenida("Resultado")
                },
                text = {

                    if (valorIntroducido.toIntOrNull() != null) {
                        SmallTextError(error = "Entrada inválida")
                    } else {
                        
                        val valor = valorIntroducido.toInt()
                        
                        if (valor.compareTo(numSecreto) == 0) {
                            SmallTextValid(error = "Has adivinado el número")
                        } else {
                            var menor = valor > numSecreto

                            SmallTextError(error = "Has fallado. ${if (menor) "Más pequeño" else "Más grande"}")
                        }
                    }
                    
                    Text("Here is a text")
                },
                confirmButton = {
                    Boton(label = "Intentar") { openDialog = false }
                },
                dismissButton = {
                    Boton(label = "Terminar") { openDialog = false }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(func: @Composable () -> Unit = {}) {
    PantallaLeerValores(rememberNavController())
}