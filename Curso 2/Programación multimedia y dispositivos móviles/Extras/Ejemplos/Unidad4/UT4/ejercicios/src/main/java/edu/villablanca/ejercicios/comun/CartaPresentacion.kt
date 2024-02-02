package edu.villablanca.ejercicios.comun

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.villablanca.ejercicios.R

@Composable
fun CartaPresentacion() {

//        Card(
//            modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .padding(16.dp),
//          //  colors= CardDefaults.cardColors()
//        ) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ){
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
                
            ) {
                Image(
                    painter = painterResource(id = R.drawable.llamame),
                    contentDescription = "Descripción de la imagen",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(60.dp) // Ajusta el tamaño según necesites
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = "Llámame")
                    Text(text = "abc@gmail.com")
                }
            }
        }

}
@Preview(widthDp = 400, heightDp = 800)
@Composable
fun vistaPreviaPresentacion(){
    CartaPresentacion()
}






