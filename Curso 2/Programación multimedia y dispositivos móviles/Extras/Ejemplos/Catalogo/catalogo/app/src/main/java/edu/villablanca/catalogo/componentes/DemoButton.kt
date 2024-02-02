package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DemoButton(){
    Column(
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Botón normal")
        }
        FilledTonalButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )) {
            Text("Botón relleno")
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Gray
            ),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Text("Botón con contorno")
        }
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 30.dp
            )
        ) {
            Text("Botón con relieve")
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()

        ) {
            Text(
                text="Botón con texto",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                color = Color.Gray
            )
        }
    }

}

@Composable
fun DesignPage() {
    Column (
        modifier= Modifier
            .background(color = Color.White)
            .padding(10.dp)
            .fillMaxWidth()
    ){
        Text(
            text = "Ejemplo Botones",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        )
        Text(text = "4 estilos de botones personalizados: ")
        DemoButton()
    }
}

@Composable
@Preview
fun BotonPreview () {
    DesignPage()
}