package edu.villablanca.ejercicios.pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.ejercicios.comun.CartaPresentacion
import edu.villablanca.ejercicios.comun.PantallaFaceGoolgle
import edu.villablanca.ejercicios.viewmodel.LoginViewModel

/**
 *
 * Añadimos viewmodel y uistados
 */
@Composable
fun PantallaLogin( loginVM: LoginViewModel,
                   onLogin: () -> Unit = {},
                   onRegistrar: () -> Unit = {}
) {
    val loginUIState by loginVM.uistate.collectAsState()
    var passwordVisible by remember { mutableStateOf(false) }

   Column (
        modifier= Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight()
            .border(1.dp, Color.Red),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
   ){
       Text(
           text="Login \nBienvenido de nuevo",
           modifier= Modifier.fillMaxWidth(),
           textAlign = TextAlign.Center,
           fontSize = 24.sp,
           fontWeight = FontWeight.Bold
       )
       OutlinedTextField(
           value = loginUIState.nombre,
           onValueChange = { loginVM.actualizaNombre(it) },
           modifier = Modifier.fillMaxWidth(0.8f),
           label = { Text(text = "Su nombre/email" )},
           )
       OutlinedTextField(
           value = loginUIState.clave,
           onValueChange = { loginVM.actualizaClave(it) },
           modifier = Modifier.fillMaxWidth(0.8f),
           label = { Text(text = "Su clave de acceso" )},
           visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
           trailingIcon = {
               IconButton(onClick = { passwordVisible = !passwordVisible }) {
                   Icon(
                       imageVector = if (passwordVisible) Icons.Filled.AccountCircle else Icons.Filled.CheckCircle,
                       contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                   )
               }
           }
           )
       Text(
           text= "¿Olvido su clave -no implementado-?",
           color = Color.Blue
       )

       TextButton(
           onClick = onLogin,
           modifier = Modifier.fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0E64D2)),
           shape = RectangleShape
       ){
           Text(
               text = "Login",
               color = Color.White)
       }
       Row(
          // horizontalArrangement = Arrangement.SpaceBetween
       ) {
           Text(text = "No tiene cuenta")
           Text(
               text = "Alta usuario",
               modifier= Modifier
                   .padding(horizontal = 12.dp)
                   .clickable(onClick = { onRegistrar() }),
               color = Color.Blue,
               textAlign = TextAlign.End
           )


       }
       PantallaFaceGoolgle()
       CartaPresentacion()
   } //column primera

}