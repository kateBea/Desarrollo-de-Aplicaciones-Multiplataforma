package edu.villablanca.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tapete()
                }
            }
        }
    }



}
class Dado(private val numLados: Int){
    fun rueda(): Int{
        return (1..numLados).random()
    }
}

fun ruedaDado(nLados: Int): Int {
    return Dado(nLados).rueda()
}

@Composable
fun Tapete(modifier: Modifier = Modifier) {
    var dado by remember {
        mutableStateOf(1)
    }
    Column(
        modifier = modifier
            .border(1.dp, Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
//        Text(
//            text = dado.value,
//            modifier = modifier
//                .border(2.dp, Color.Red)
//                .padding(24.dp, 24.dp),
//            fontSize = 36.sp
//        )

        Image (
            painter = painterResource(id = getImagenDado(dado)),
            contentDescription = null,
            modifier = Modifier.size(200.dp) ,
            contentScale = ContentScale.Fit
        )
        Button(onClick = {println("boton pulsado"); dado= ruedaDado(6)}) {
            Icon(imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
            Text(stringResource(R.string.lanza))
        }
    }


}

@Composable
fun getImagenDado(diceValue: Int): Int {
    return when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_1
    }
}



@Preview(showBackground = true,
    widthDp = 200,
    heightDp = 400)
@Composable
fun TapetePreview() {
    DiceRollerTheme {
        Tapete()
    }
}