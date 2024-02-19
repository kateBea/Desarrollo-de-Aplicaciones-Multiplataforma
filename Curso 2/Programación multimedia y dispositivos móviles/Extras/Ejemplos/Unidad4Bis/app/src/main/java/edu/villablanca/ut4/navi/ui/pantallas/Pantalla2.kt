package edu.villablanca.ut4.navi.ui.pantallas

/**
 *  Pantalla2
 *  Muesta una imagen descargada de Internet:
 *
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import edu.villablanca.ut4.R

@Composable
fun Pantalla2(texto: String ) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "segunda pantalla",
            fontSize = 30.sp)

        Divider()
        Text(text = "Esto viene de uno: $texto")
        Image(
            painter = painterResource(id = R.drawable.andro_p) ,
            contentDescription = "Super Android",
            contentScale = ContentScale.FillBounds
            )

    }
}