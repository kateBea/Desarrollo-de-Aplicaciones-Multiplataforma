package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.catalogo.R

@Preview
@Composable
fun DemoRatingBox() {
    RatingBarConTitulo()
}

@Composable
fun RatingBarConTitulo() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "¿Satisfacción con el proceso de compra?", style = TextStyle(
                fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black
            ), modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        RatingBarComposable()
    }
}

@Composable
fun RatingBarComposable() {
    var rating by remember { mutableIntStateOf(0) }
    var mostrarDialog by remember { mutableStateOf(false) }

    val filledStar = painterResource(id = R.drawable.star)
    val outlinedStar = painterResource(id = R.drawable.star_outline)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(5) { index ->
            val painter = if (index < rating) filledStar else outlinedStar

            Image(painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(65.dp)
                    .clickable {
                        rating = index + 1
                        mostrarDialog = true
                    }
                    .padding(4.dp))
        }
    }

    if (mostrarDialog) {
        DialogRatingBar(puntuacion = rating, alCerrar = { mostrarDialog = false })
    }
}

@Composable
fun DialogRatingBar(puntuacion: Int, alCerrar: () -> Unit) {
    AlertDialog(onDismissRequest = alCerrar, title = { Text(text = "Puntuación") }, text = {
        Text(text = "Has dado una puntuación de $puntuacion estrellas.")
    }, confirmButton = {})
}
