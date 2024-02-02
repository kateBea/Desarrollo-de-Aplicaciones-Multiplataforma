package edu.villablanca.ut3.pantallas

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp







/**
 * Ejemplo de Intent implicitos:
 *  - Foto
 *  - Correo
 */
@Composable
fun PantallaImplicitos(cabecera: String, onCerrar: ()-> Unit){
    var imagenBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var enviarCorreo by remember { mutableStateOf(false) }

    var otrosEjemplos by remember{ mutableStateOf(false) }

    /** No estamos en el metodo de Activity, no tenemos el
     * contexto, pero lo podemos obtener
     */
    val contexto = LocalContext.current

    /**
     * Aquí recibimos el resultado de la Activity de
     * sacar foto
     * El resultado en la variable de estado imagebitmap
     */
    val fotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { resultado ->
        // Maneja el resultado de la captura de imagen aquí
        val data = resultado.data
        val bitmap = data?.extras?.get("data") as? Bitmap
        bitmap?.let {
            imagenBitmap = it
        }
    }



   if( otrosEjemplos)
       PantallaMasImplicitos {otrosEjemplos=false}
    else {
       Column(
           modifier = Modifier.fillMaxWidth(0.8f),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.SpaceBetween
       ) {

           // partes fijas
           Text(
               text = "Intent implicitas",
               modifier = Modifier.fillMaxWidth(),
               textAlign = TextAlign.Center,
               fontSize = 24.sp,

               )
           Text(
               text = cabecera,
               modifier = Modifier.padding(horizontal = 8.dp),
               maxLines = 2,
           )

           // botones con las llamadas a nuea activity
           Button(
               onClick = {
                   val tomarFotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                   if (tomarFotoIntent.resolveActivity(contexto.packageManager) != null) {
                       fotoLauncher.launch(tomarFotoIntent)
                   }
               }
           ) {
               Text(text = "Sacar foto")
           }
           Button(onClick = { enviarCorreo = true }) {
               Text(text = "Correo prueba")
           }

           /**
            * Resyltado de las llamadas a las activities
            *
            */
           if (enviarCorreo) {
               PantallaEnviarCorreo(null)
               println("---> DEBUG enviar correo")
               enviarCorreo = false
           }


           Button(onClick = { otrosEjemplos = true }) {
               Text(text = "Mas ejemplos")
           }

           Button(onClick = onCerrar) {
               Text(text = "Salir y Cerrar")
           }
           /**
            * Cuando imageBitmap no sea nula la mostramos aquí.
            */
           imagenBitmap?.let { bitmap ->
               Image(
                   bitmap = bitmap.asImageBitmap(),
                   contentDescription = "Imagen Capturada",
                   modifier = Modifier.fillMaxWidth(0.9f),
                   contentScale = ContentScale.FillWidth
               )
           }
       } // column
   }  // else masEjemplos
}

@Composable
fun PantallaFoto(){

}


/**
 *  Enviar correo
 */

@Composable
fun PantallaEnviarCorreo(imageUri: Uri?){
    val context = LocalContext.current

   // Button(onClick = {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("angsuarez@outlook.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Correo UT3")
            putExtra(Intent.EXTRA_TEXT, "Es un ejemplo de envio de correo.")
            putExtra(Intent.EXTRA_STREAM, imageUri) // Adjunta la imagen
        }

        val chooser = Intent.createChooser(emailIntent, "Enviar correo con...")
        if (emailIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(chooser)
        }
 /*   }) {
        Text("Enviar Correo")
    }*/


}




