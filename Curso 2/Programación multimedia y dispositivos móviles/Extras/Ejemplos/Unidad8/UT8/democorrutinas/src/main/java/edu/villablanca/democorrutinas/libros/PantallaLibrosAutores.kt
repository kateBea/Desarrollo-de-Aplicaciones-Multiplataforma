package edu.villablanca.democorrutinas.libros

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * Demostración del uso de corrutinas para obtener varios datos simultaneamente.
 *
 * En esta demostración las corrutinas se han puesto en la capa de datos (LibrosAutores) que simulan
 * la petición a un repositorio (red o base de datos).
 * Puesto que la función "cargarLibrosAutores" es una función de suspensión, necesitamos
 * usar "launchedEffect"
 *
 * Por otro lado LaunchedEffect dentro de una lambda de un evento de clic, lo cual no es correcto.
 * LaunchedEffect está diseñado para ser utilizado directamente dentro del cuerpo de un Composable
 * y no dentro de un manejador de eventos como onClick. La solución es utilizar una variable local
 * de estado y " LaunchedEffect(cargarLibrosAutores)" solo se invoca cuando la variable es true
 *
 * El viewModel conecta los datos con el IU.
 *
 *
 * @param LAViewModel ViewModel con LibrosAutoresEntity
 * @param onVolver : lambda para regresar a la pantalla principal y avisar que se terminó
 */
@Composable
fun PantallaLibrosAutores(
    vm: LAViewModel,
    onVolver: ()-> Unit
    ){
    val las: State<LibrosAutoresEntity> = vm.librosautores.collectAsState()
    var cargarLibrosAutores by remember { mutableStateOf(false) }

    // Observar el cambio de la variable cargarLibrosAutores para lanzar la corrutina
    LaunchedEffect(cargarLibrosAutores) {
        if (cargarLibrosAutores) {
            vm.obtenerLibrosAutoeres()
            cargarLibrosAutores = false
        }
    }

    
    Column {
        Text(text = "Demostración de peticiones simultáneas con async")
        Button(onClick = {cargarLibrosAutores= true}) {
            Text(text = "Pedir libros y autores")
        }

        Text(
            text = " Lista Libros: ${las.value.libros} \n Lista autores: ${las.value.autores}" ,
            modifier = Modifier.border(1.dp, Color.Blue)
        )

        Button(onClick =  onVolver) {
            Text(text = "Volver")
        }

    }
}