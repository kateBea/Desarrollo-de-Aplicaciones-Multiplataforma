package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
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
import edu.villablanca.catalogo.R


@Composable
@Preview
fun DemoCard(){
    LazyColumn (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        item {
            MiCarta(R.drawable.kotlin, "Kotlin Logo", "Kotlin", "Kotlin is...")
        }
        item {
            MiCarta(R.drawable.java, "Java Logo", "Java", "Java is...")
        }
        item {
            MiCarta(R.drawable.js, "JavaScript Logo", "JavaScript", "JavaScript is...")
        }
        item {
            MiCarta(R.drawable.python, "Python Logo", "Python", "Python is...")
        }
        item {
            MiCarta(R.drawable.c, "C Logo", "C", "C is...")
        }
        item {
            MiCarta(R.drawable.cs, "C# Logo", "C#", "C# is...")
        }
    }
}

@Composable
fun MiCarta(drawable: Int, imageDescription: String, title: String, description: String){
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = Modifier
            .size(425.dp, 250.dp)
            .padding(75.dp)
        ,
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = 600.dp),
        border = BorderStroke(1.dp, Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = drawable),
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .padding(10.dp),
                contentDescription = imageDescription,
                contentScale = ContentScale.FillHeight
            )
            Column(verticalArrangement = Arrangement.Top) {
                Text(text = title, color = Color.Black)
                Text(text = description, color = Color.Gray)
            }
        }
    }
}