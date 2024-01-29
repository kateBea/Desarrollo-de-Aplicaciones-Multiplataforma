package org.ventas.pizzamaanager

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PantallaInicio() {
    Column {
        Header()
        Body()
        Footer()
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier
    ) {
        TextoBienvenida(contenido = "Login")
        TextoBienvenida(contenido = "Bienvenido de nuevo")
    }
}

@Composable
fun Body() {

}

@Composable
fun Footer() {
    Column(
        modifier = Modifier
    ) {
        Boton(descripcion = "Login")
        Boton(descripcion = "Login con Meta")
        Boton(descripcion = "Login con Google")
    }
}

@Composable
fun TextoBienvenida(contenido: String) {
    val mod = Modifier
    
    Text(text = contenido)
}

@Composable
fun Boton(descripcion: String) {
    Button(
        onClick = { Log.d("Debug", "Presionado botón $descripcion") },
        modifier = Modifier
    ) {

    }
}