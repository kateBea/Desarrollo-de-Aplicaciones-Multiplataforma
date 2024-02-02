package edu.villablanca.bdatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.bdatos.ui.theme.DiceRollerTheme

/**
 * @author
 * Ejemplo de formulario CRUD para una base de datos
 */
class BDatos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bd = BDSim()
        bd.open()
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal(bd)
                }
            }
        }
    }
}


/**
 * Ventana de creacion
 * @param  bd Base de datos
 * @param  siguienteMenu  lambda para actualizar el estado de menu
 * @param  estado lambda para actualizar campo de estado en la pantalla principal
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCrear(bd: BDSim,
                  siguienteMenu: (String)-> Unit,
                  estado: (String) -> Unit){

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }

 //   var usuario by remember { mutableStateOf(Usuario()) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nombre,
            onValueChange = { nuevoNombre -> nombre = nuevoNombre },
            label = { Text("nombre") }
        )
        TextField(
            value = edad.toString(),
            onValueChange = { edad = it.toIntOrNull() ?: 0 },
            label = { Text("edad") }
        )

        TextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("correo") }
        )
        Button(onClick = {
            bd.create(Usuario(nombre,edad,correo))
            siguienteMenu("I")
            estado("Creado usuario: ${nombre}")
        }) {
            Text(text = "Añadir")
        }
    }
}



/**
 * Ventana  lectura con get, menos recomendable
 * @param  bd Base de datos
 * @param  siguienteMenu  lambda para actualizar el estado de menu
 * @param  estado lambda para actualizar campo de estado en la pantalla principal
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLeer(
    bd: BDSim,
    siguienteMenu: (String) -> Unit,
    estado: (String) -> Unit
) {
    var id by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("Nombre usuario") }
        )

        Button(onClick = {
            val res= bd.read(id)
            estado("Respuesta leer = $res")
            siguienteMenu("I")

        }) {
            Text(text = "Leer")
        }

    }

}




/**
 * Ventana  borrar
 * @param  bd Base de datos
 * @param  siguienteMenu  lambda para actualizar el estado de menu
 * @param  estado lambda para actualizar campo de estado en la pantalla principal
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaBorrar(
    bd: BDSim,
    siguienteMenu: (String) -> Unit,
    estado: (String) -> Unit
) {
    var id by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("Nombre para borrar") }
        )


        Button(onClick = {
            val res= bd.delete( id)

            estado("Respuesta leer = $res")
            siguienteMenu("I")

        }) {
            Text(text = "Borrar")
        }

    }

}


/**
 * Ventana  actualizar con get, menos recomendable
 * @param  bd Base de datos
 * @param  siguienteMenu  lambda para actualizar el estado de menu
 * @param  estado lambda para actualizar campo de estado en la pantalla principal
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaActualizar(
    bd: BDSim,
    siguienteMenu: (String) -> Unit,
    estado: (String) -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf(0) }

    var encontrado by remember { mutableStateOf(false) }

    //   var usuario by remember { mutableStateOf(Usuario()) }



    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ){
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            TextField(
                modifier = Modifier.weight(1f),
                value = nombre,
                enabled = true,
                onValueChange = { nuevoNombre -> nombre = nuevoNombre },
                label = { Text("nombre") }
            )
            Button(
                enabled = !encontrado,
                onClick = {

                    val  us = bd.read(nombre)
                    if(us != null) {
                        encontrado = true
                        edad = us.edad
                        correo = us.correo
                    }else {
                        nombre=""
                    }

                }) {
                Text(text = "Buscar")
            }
        }


        TextField(
            value = edad.toString(),
            enabled = encontrado,
            onValueChange = { edad = it.toIntOrNull() ?: 0 },
            label = { Text("edad") }
        )

        TextField(
            value = correo,
            enabled = encontrado,
            onValueChange = { correo = it },
            label = { Text("correo") }
        )
        Row {
            Button(
                enabled = encontrado,
                onClick = {
                bd.update(nombre,Usuario(nombre,edad,correo))
                siguienteMenu("I")
                estado("Creado usuario: ${nombre}")
            }) {
                Text(text = "Actualizar")
            }
            Button(onClick = {
                siguienteMenu("I")
            }) {
                Text(text = "Volver")
            }
        }

    }

}



/**
 * Ventana  muestra el menu.
 * @param onSelect lambda para actualizar el estado de la opcion elegida (elevacion de estados)
 *
 */
@Composable
fun MenuCard(onSelect: (String)-> Unit) {
    Column {
        Button(onClick = { onSelect("C") }) {
            Text(text = "Crear Usario")
        }
        Button(onClick = { onSelect("R") }) {
            Text(text = "(R) Leer")
        }
        Button(onClick = { onSelect("U") }) {
            Text(text = "(U) Actualizar")
        }
        Button(onClick = { onSelect("D") }) {
            Text(text = "(D) Borrar")
        }
    }
}




@Composable
fun OLText(texto: String){
    Box{
        Text(
            text = texto,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.5.sp,
                color = Color.Black // Color del contorno
            ),
            modifier = Modifier.align(Alignment.Center).border(2.dp, Color.Black)
        )
        Text(
            text = "Estado",
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp,
                color = Color.Red // Color del texto principal
            ),

            modifier = Modifier.align(Alignment.TopStart)
        )
    }
}
/**
 * Ventana  principal
 * @param  bd Base de datos
 * @param  modifier
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal( bd: BDSim , modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf<String>("") }
    var operacion by remember { mutableStateOf("I") }
    var estadoUltimo by remember {  mutableStateOf("ultimo estado") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text="Demo de formulario Base de Datos"
        )
        Spacer(modifier = Modifier.height(8.dp))

        // menu y operaciones
        when(operacion){
            "I" -> MenuCard(onSelect = { nueva: String -> operacion = nueva})

            "C" -> {
                PantallaCrear(bd = bd,{ nueva: String -> operacion = nueva} ){ estadoUltimo = it}

            }
            "R"  ->{
                PantallaLeer(bd , { nueva: String -> operacion = nueva} ){ estadoUltimo = it}

            }
            "U" -> {
                PantallaActualizar(bd , { nueva: String -> operacion = nueva} ){ estadoUltimo = it}
            }
            "D" -> {
                PantallaBorrar(bd , { nueva: String -> operacion = nueva} ){ estadoUltimo = it}
            }
            else -> println("Error")

        }


         OLText(texto = estadoUltimo,
            //modifier = Modifier.border(1.dp, Color.Red)
            )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
       // PantallaPrincipal()
    }
}