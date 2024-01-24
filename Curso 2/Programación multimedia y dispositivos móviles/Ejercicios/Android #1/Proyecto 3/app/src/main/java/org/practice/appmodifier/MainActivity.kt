package org.practice.appmodifier

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxHeight(1.0f)
                    .fillMaxWidth(1.0f)
                    .padding(horizontal = 20.dp, vertical = 20.dp)
                    .border(4.dp, Color.LightGray, shape = RectangleShape)
            ) {
                MyText("Hugo Pelayo")
                MyText("Desarrollo de Aplicaciones Multiplataforma")
                MyText("IES Villablanca")
            }
        }
    }
}

@Composable
fun MyText(contents: String,
           modifier: Modifier = Modifier
               .padding(horizontal = 20.dp, vertical = 20.dp)
               .clickable { Log.d("Debug","Clicking $contents") },
           wantTopSpace: Boolean = true) {
    if (wantTopSpace) {
        Spacer(modifier = Modifier.height(5.dp))
    }
    
    Text(text = contents,
        modifier = modifier,
        fontSize = 5.em,
        fontFamily = FontFamily.SansSerif)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // List of composable you want to preview here
}