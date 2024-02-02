/*
 * Copyright (c) 2024. 
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *  
 *       https://www.apache.org/licenses/LICENSE-2.0
 *  
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 */

package edu.villablanca.catalogo.componentes

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.catalogo.R


private enum class PANTALLA{
    VERTICAL,
    GRID,
   // DIALOGO
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DemoLazyGrid(){

    val colores = List(20) { "Color ${it + 1}" }
    var pantalla by remember { mutableStateOf(PANTALLA.GRID) }
    var mensaje by remember { mutableStateOf("") }
    var mostrardialogo by remember { mutableStateOf(false) }

    when (pantalla) {
        PANTALLA.GRID->
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),

                    ) {
                    items(colores,
                        //key = { it } // el valor de la lista debe ser unico
                        //key = { it.id }) {
                        //        val rememberedValue = rememberSaveable {
                        //            Random.nextInt()
                        //        }

                    ) { color ->
                        Row(Modifier.animateItemPlacement(tween(durationMillis = 250))) {
                            EjemploCarta(color,
                                onSeleccionado = {
                                    mensaje = it
                                    Log.d("MIDEBUG","color= $color y selec=$it" )
                                    // pantalla = PANTALLA.DIALOGO
                                    mostrardialogo = true
                                })

                        }
                    }
                  }
        PANTALLA.VERTICAL ->{
            Text(text = "TODO Vertical")}
        //PANTALLA.DIALOGO ->{}
        else ->{
            Text(text = "TODO otros")}

    }// del when

        if (mostrardialogo){
            AlertDialog(
                onDismissRequest = { mostrardialogo = false },
                title = { Text("Confirmación") },
                text = { Text(text="Has pulsado =$mensaje") },
                confirmButton = {
                    Button(
                        onClick = {
                            mostrardialogo = false
                            /* pantalla = PANTALLA.GRID*/

                        }
                    ) {
                        Text("Entendido")
                    }
                },

                )
        }

}


@Composable
fun EjemploCarta(color: String, onSeleccionado: (String)-> Unit ={}){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
      //  elevation = 4.dp,

    ) {
        Column(
            modifier = Modifier.clickable(enabled = true,
                onClick = {
                    onSeleccionado(color)

                } )
        ) {

       
        Row(
           horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp, 60.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
                    .clickable(enabled = true, onClick = { Log.d("MIDEBUG", "EN La imagen") })
            ,
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.llamame),
                contentDescription = "Descripción de la imagen"
            )
            Text(
                text = "Texto de la Tarjeta",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 9.sp,
                textAlign = TextAlign.End
                //overflow = TextOverflow.Clip,
            )
        }
            Text(text = "otro texto",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                textAlign = TextAlign.Center
                )
        }
    }

}