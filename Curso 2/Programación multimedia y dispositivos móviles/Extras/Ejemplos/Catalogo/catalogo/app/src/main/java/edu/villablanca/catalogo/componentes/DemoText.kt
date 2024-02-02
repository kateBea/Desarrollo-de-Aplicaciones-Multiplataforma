package edu.villablanca.catalogo.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DemoText(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "DemoText",
            fontFamily = FontFamily.SansSerif,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(400.dp))

        //Texto normal
        Text(text = "")
        Text(text = "Texto normal", fontSize = 20.sp)
        Text(text = "Hola mundo")
        Divider(color = Color.Black, thickness = 1.dp)

        //Fuente
        Text(text = "")
        Text(text = "Tipo de fuente", fontSize = 20.sp)
        Text(text = "Hola mundo", fontFamily = FontFamily.Serif)
        Text(text = "Hola mundo", fontFamily = FontFamily.SansSerif)
        Text(text = "Hola mundo", fontFamily = FontFamily.Cursive)
        Divider(color = Color.Black, thickness = 1.dp)

        //Texto a color
        Text(text = "")
        Text(text = "Color del texto", fontSize = 20.sp)
        Text(text ="Hola mundo", color = Color.Blue)
        Divider(color = Color.Black, thickness = 1.dp)


        //Tamaño texto
        Text(text = "")
        Text(text = "Tamaño del texto", fontSize = 20.sp)
        Text(text = "Hola mundo", fontSize = 30.sp)
        Divider(color = Color.Black, thickness = 1.dp)

        //Texto en cursiva
        Text(text = "")
        Text(text = "Texto en cursiva", fontSize = 20.sp)
        Text(text = "Hola mundo", fontStyle = FontStyle.Italic)
        Divider(color = Color.Black, thickness = 1.dp)

        //Texto en negrita
        Text(text = "")
        Text(text = "Texto en negrita", fontSize = 20.sp)
        Text(text = "Hola mundo", fontWeight = FontWeight.Bold)
        Divider(color = Color.Black, thickness = 1.dp)

        //Texto tachado
        Text(text = "")
        Text(text = "Texto tachado", fontSize = 20.sp)
        Text(
            text = "Hola mundo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Divider(color = Color.Black, thickness = 1.dp)

        //Subrayado
        Text(text = "")
        Text(text = "Texto subrayado", fontSize = 20.sp)
        Text(
            text = "Hola mundo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Divider(color = Color.Black, thickness = 1.dp)

        //Alineación del texto
        Text(text = "")
        Text(text = "Alineación del texto", fontSize = 20.sp)
        Text(text = "Hola mundo", textAlign = TextAlign.Right, modifier = Modifier.width(400.dp))
        Divider(color = Color.Black, thickness = 1.dp)

        //Sombra
        Text(text = "")
        Text(text = "Sombra del texto", fontSize = 20.sp)
        Text(
            text = "Hola mundo",
            style = TextStyle(
                fontSize = 24.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    offset = Offset(5.0f, 10.0f),
                    blurRadius = 3f
                )
            )
        )
        Divider(color = Color.Black, thickness = 1.dp)

        //Varios estilos en un texto
        Text(text = "")
        Text(text = "Varios estilos en un texto", fontSize = 20.sp)
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("H")
                }
                append("ola ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("M")
                }
                append("undo")
            }
        )
        Divider(color = Color.Black, thickness = 1.dp)

        //Varios estilos en los párrafos
        Text(text = "")
        Text(text = "Varios estilos en un párrafo", fontSize = 20.sp)
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Hola\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    ) {
                        append("Mundo\n")
                    }
                    append("Compose")
                }
            }
        )
        Divider(color = Color.Black, thickness = 1.dp)

        //Cantidad máxima de líneas
        Text(text = "")
        Text(text = "Cantidad máxima de líneas", fontSize = 20.sp)
        Text("Hola ".repeat(50), maxLines = 2)
        Divider(color = Color.Black, thickness = 1.dp)

        //Desbordamiento del texto
        Text(text = "")
        Text(text = "Desbordamiento del texto", fontSize = 20.sp)
        Text("Hola mundo ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
        Divider(color = Color.Black, thickness = 1.dp)

    }
}