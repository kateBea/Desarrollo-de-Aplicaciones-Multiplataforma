package org.ventas.pizzamaanager.interfaz

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.ventas.pizzamaanager.R

@Composable
fun PantallaInicio() {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Header()
        Body()
        Footer()
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
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
        modifier = Modifier,
    ) {
        Boton("Login", descripcion = "Login")
        Boton("Login con Meta", painterResource(id = R.drawable.logometa),descripcion = "Login con Meta")
        Boton("Login con Google", painterResource(id = R.drawable.logogoogle),descripcion = "Login con Google")
    }
}

@Composable
fun TextoBienvenida(contenido: String) {
    val mod = Modifier
    
    Text(text = contenido, textAlign = TextAlign.Center)
}

@Composable
fun Boton(label: String, icon: Painter, descripcion: String = "NoDescription") {
    Button(
        onClick = { Log.d("Debug", "Presionado botón $descripcion") },
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0x39, 0x62, 0xCD))
    ) {
        Icon(painter = icon,
            contentDescription = descripcion,
            modifier = Modifier.size(24.dp) /* Modifier.align(Alignment.CenterStart) does not work*/)

        Text(text = label,
            color = Color.White,
            textAlign = TextAlign.Center)
    }
}

@Composable
fun Boton(label: String, descripcion: String = "NoDescription") {
    Button(
        onClick = { Log.d("Debug", "Presionado botón $descripcion") },
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0x39, 0x62, 0xCD))
    ) {
        Text(text = label, color = Color.White, textAlign = TextAlign.Center)
    }
}