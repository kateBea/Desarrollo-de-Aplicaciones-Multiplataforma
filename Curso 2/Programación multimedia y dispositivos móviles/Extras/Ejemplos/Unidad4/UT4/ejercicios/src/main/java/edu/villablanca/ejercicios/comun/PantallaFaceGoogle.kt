package edu.villablanca.ejercicios.comun

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.villablanca.ejercicios.R

@Composable

fun PantallaFaceGoolgle(){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Divisor()

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(8f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0E64D2)),

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Esto separa los elementos al máximo
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook_icon32),
                    contentDescription = "",
                    modifier = Modifier

                        .padding(end = 12.dp)
                        .height(24.dp)
                        .aspectRatio(1f),
                    // alignment = Alignment.BottomCenter,
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    text = "Login con Facebook",
                    color = Color.White
                )
            }
        }// row
        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = RoundedCornerShape(8f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0E64D2)),

            ) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_google),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .height(24.dp)
                        .aspectRatio(1f),
                    // alignment = Alignment.BottomCenter,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Login con Google",
                    color = Color.White
                )
            }

    }
}

@Composable
fun Divisor(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
        Text(
            text = "o bien",
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
        )
    }
}

@Preview
@Composable
fun vistaPrevia(){
    PantallaFaceGoolgle()
}