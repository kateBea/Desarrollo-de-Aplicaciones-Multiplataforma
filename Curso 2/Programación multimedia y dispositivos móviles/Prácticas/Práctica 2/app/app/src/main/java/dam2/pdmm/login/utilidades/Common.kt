package dam2.pdmm.login.utilidades

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dam2.pdmm.login.R
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

@Composable
fun Boton(label: String, icon: Painter, descripcion: String = "NoDescription") {
    Button(
        onClick = { Log.d("Debug", "Presionado botón $descripcion") },
        modifier = Modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0x39, 0x62, 0xCD)),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(painter = icon,
                contentDescription = descripcion,
                modifier = Modifier.size(24.dp) /* Modifier.align(Alignment.CenterStart) does not work*/)

            Text(text = label,
                color = Color.White,
                textAlign = TextAlign.Center)

            // Para formatear el texto centrado
            // Con el icono fijo a la izquierda
            Text(text = "")
        }
    }
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
fun CampoContrasenia(isError: Boolean = false, onNewValue: (String) -> Unit = { }) {
    var passwordValue by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.padding(bottom = 5.dp, top = 5.dp),
        value = passwordValue,
        textStyle = TextStyle(fontSize = 20.sp),
        onValueChange = { passwordValue = it },
        maxLines = 1,
        label = { LabelCampos(valor = "Contraseña") },
        visualTransformation =
        if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                modifier = Modifier.padding(end = 10.dp),
                onClick = { passwordVisible = !passwordVisible }
            ) {
                val painter = if (passwordVisible) painterResource(id = R.drawable.notvisible)
                else painterResource(id = R.drawable.visible)

                Icon(
                    modifier = Modifier.
                    size(if (passwordVisible) 27.dp else 24.dp),
                    painter = painter,
                    contentDescription = "Es visible")
            }
        },
        isError = isError,
    )

    onNewValue(passwordValue)
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
fun CasillaSeleccion(label: String, onCheckedChange: (Boolean) -> Unit = {}) {
    var valor by rememberSaveable { mutableStateOf(false) }

    Row (
        modifier = Modifier.fillMaxWidth(0.5f),
        horizontalArrangement = Arrangement.Absolute.Left,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = valor, onCheckedChange = { valor = it })
        Text(
            modifier = Modifier,
            text = label,
            style = TextStyle(fontSize = 15.sp)
        )
    }

    onCheckedChange(valor)
}

@Preview(showBackground = true)
@Composable
fun Preview(composable: @Composable () -> Unit = {}) {
    composable()
}

data class IngredientePrecioCantidad(
    var nombreIngrediente: String? = null,
    var precioIngrediente: Float = 0.0f,
    var cantidadIngrediente: Int = 0,
    var seleccionado: Boolean = false
)