package org.practice.imagecrad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.pika_pika2)
            val description = "Yellow, mouse-like creature with electrical abilities"
            val title = "Pikachu"

            val modifier = Modifier

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.LightGray),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                MyImage(painter, modifier, desc = description, title = title)
                DescriptionTexts(description)
            }
        }
    }
}

@Composable
fun MyImage(
    painter: Painter,
    modifier: Modifier = Modifier,
    desc: String = "Card",
    title: String = "None"
) {
    Card (
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .background(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
    ) {
        // Box is used to stack objects one on top of another
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                modifier = modifier,
                contentDescription = desc,
                contentScale = ContentScale.Crop
            )

            // This box is used to apply a gradient so the bottom description is readable
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            // Transition form the list of color listed below
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300.0f
                        )
                    ),
            ) {

            }

            // This box content goes right on top of our image
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    // sp units are preferred for android as they scale with user font size
                    style = TextStyle(color = Color.White, fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif)
                )
            }
        }
    }
}

@Composable
fun DescriptionTexts(contents: String) {
    Text(
        text = contents,
        modifier = Modifier
            .padding(top = 5.dp),
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    // List of composable to preview
}