package edu.villablanca.catalogo.componentes

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import edu.villablanca.catalogo.R

/**
 * Composable function demonstrating the usage of the MyImage composable along
 * with additional description texts. It displays an image of Pikachu within a
 * Card, accompanied by a gradient overlay and title text.
 */
@Composable
fun DemoImage(){
    val painter = painterResource(id = R.drawable.pika_pika)
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

/**
 * Composable function to display an image within a Card with rounded corners,
 * along with a gradient overlay for better readability of the bottom description.
 * The image is placed inside a Box to allow stacking additional content on top.
 *
 * @param painter The Painter representing the image to be displayed.
 * @param modifier Modifier for customizing the appearance and layout of the MyImage composable.
 * @param desc A string describing the content of the image for accessibility purposes.
 * @param title The title text displayed at the bottom of the image.
 */
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

/**
 * Composable that displays description text.
 *
 * @param contents contents to be displayed.
 * */
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

/**
 * Composable for preview debugging
 * */
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    // List of composable to preview
}