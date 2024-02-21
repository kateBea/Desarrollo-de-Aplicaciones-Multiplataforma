package examen.hugopelayo.utilidades

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import examen.hugopelayo.R
import kotlinx.coroutines.DelicateCoroutinesApi

@Composable
fun TextoBienvenida(contenido: String) {
    val mod = Modifier

    Text(
        modifier = mod,
        text = contenido,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun Boton(label: String, descripcion: String = "NoDescription", onClick: () -> Unit = {}) {
    Button(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth(0.7f),
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0x39, 0x62, 0xCD))
    ) {
        Text(text = label, color = Color.White, textAlign = TextAlign.Center)
    }
}

@Composable
fun CampoEntrada(label: String, isError: Boolean = false, onNewValue: (String) -> Unit = { }) {
    var campoEntradaValue by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
        value = campoEntradaValue,
        onValueChange = { campoEntradaValue = it },
        maxLines = 1,
        label = { LabelCampos(valor = label) },
        textStyle = TextStyle(fontSize = 20.sp),
        isError = isError,
    )

    onNewValue(campoEntradaValue)
}

@Composable
fun LabelCampos(valor: String) {
    Text(
        text = valor,
        style = TextStyle(
            color = Color(0.0f, 0.0f, 0.0f, 0.5f),
            fontSize = 17.sp
        )
    )
}

@Composable
fun TextoCuerpo(value: String) {

    Text(modifier = Modifier,
        text = value,
        style = TextStyle(fontSize = 20.sp)
    )
}

@Composable
fun SmallTextError(error: String) {
    Text(
        modifier = Modifier,
        text = error,
        style = TextStyle(color = Color.Red)
    )
}

@Composable
fun SmallTextValid(error: String) {
    Text(
        modifier = Modifier,
        text = error,
        style = TextStyle(color = Color.Green, fontWeight = FontWeight.SemiBold)
    )
}

@Composable
fun RecetaCard(painter: Painter, nombreReceta: String, tiempoMins: Int, descripcion: String = "Sin descripción", onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(enabled = true, onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(modifier = Modifier.size(64.dp), painter = painter, contentDescription = descripcion)
                Text(text = nombreReceta)
            }

            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = "$tiempoMins mins"
            )
        }
    }
}

@Composable
fun CardRecetaScreen(painter: Painter) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Image(modifier = Modifier, painter = painter, contentDescription = "Imagen receta")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(func: @Composable () -> Unit = {}) {
    CardRecetaScreen(painterResource(id = R.drawable.burger))
}

