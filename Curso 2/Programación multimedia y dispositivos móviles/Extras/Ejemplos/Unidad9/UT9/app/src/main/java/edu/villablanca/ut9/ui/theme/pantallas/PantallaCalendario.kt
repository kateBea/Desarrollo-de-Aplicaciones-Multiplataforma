package edu.villablanca.ut9.ui.theme.pantallas

import android.Manifest
import android.content.Context
import android.provider.CalendarContract
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale


/**
 * Muestra el
 *
 *  NECESITA PERMISOS EN TIEMPO DE EJECUCIÓN
 *
 *  @Nota : Se solicita permitos en ejecución la primera vez y ....
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PantallaCalendario(){

    val contexto = LocalContext.current


    // Permisos para contacto
    val calendarioPermissionState = rememberPermissionState(Manifest.permission.READ_CALENDAR)


    if (calendarioPermissionState.status.isGranted) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            
        ) {
            Text(text = "Eventos de Calendario")

                val listaEV = obtenerCalendario(contexto)
                ListarEventos(listaEV)
        }
    } else {
        // Pedimos permiso
        Column {
            val textToShow = if (calendarioPermissionState.status.shouldShowRationale) {
                // If the user has denied the permission but the rationale can be shown,
                // then gently explain why the app requires this permission

                "Necesitamos permisos para leer los contactos, por favor autorice"
            } else {
                // If it's the first time the user lands on this feature, or the user
                // doesn't want to be asked again for this permission, explain that the
                // permission is required
                "Se necesitan permisos para leer los contactos. Po favor, autorice lectura"

            }
            Text(textToShow)
            Button(onClick = { calendarioPermissionState.launchPermissionRequest() }) {
                Text("Request permission")
            }

        }
    } // de else
}

@Composable
fun ListarEventos(listaEV: List<EventoCalendario>) {
    var verDestalles by remember { mutableStateOf(false) }
    var elEventoId by remember { mutableStateOf("") }

    if (verDestalles){
        DetalleEvento(
            evId = elEventoId
        ){
            verDestalles= false
        }
    } else
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Espaciado horizontal entre ítems
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado vertical entre ítems,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),  ){
        items(listaEV){
            //Text(text="${it.id}, ${it.titulo}")
            CadaEvento(
                ev = it
            ) {
                elEventoId = it
                verDestalles = true
            }
        }
    }
}

@Composable
fun CadaEvento(ev: EventoCalendario,onSeleccionado: (String)-> Unit){
    Card(
        modifier = Modifier.clickable{ onSeleccionado(ev.id ?:"")},
        
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column {
            Row {
                Text(text = ev.id ?: "-")
                Text(text = ev.titulo ?: "-")
            }
            Divider(
                color = Color.Gray, // Color de la línea de separación
                thickness = 1.dp, // Grosor de la línea
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(text = ev.descripcion ?:"-",
                modifier = Modifier.padding(bottom = 8.dp)
                )
        }
    }
}

data class EventoCalendario(
    val id: String?=null,
    val titulo: String?=null,
    val descripcion: String? = null,
    val dtstart: String?=null,
    val dtend : String?=null,
    val duracion: String?=null,
    val status: String?= null,
    )
/**
 *
 * Referencia en https://developer.android.com/reference/kotlin/android/provider/CalendarContract
 * y https://developer.android.com/reference/kotlin/android/provider/CalendarContract.Events
 */
fun obtenerCalendario(contexto: Context): List<EventoCalendario>{

    val evLista = mutableListOf(EventoCalendario())
    val projection = arrayOf(
        CalendarContract.Events._ID,
        CalendarContract.Events.TITLE)

    val cursor = contexto.contentResolver.query(
        CalendarContract.Events.CONTENT_URI,
        projection,
        null,
        null,
        null
    )
    cursor?.use {
        val columnIndexId = cursor.getColumnIndex(CalendarContract.Events._ID)
        val columnIndexTitle = cursor.getColumnIndex(CalendarContract.Events.TITLE)
        val columnIndexDescripcion = cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION)

        while (cursor.moveToNext()) {
            val eventId = cursor.getString(columnIndexId)
            val title = cursor.getString(columnIndexTitle)

            var descripcion : String?  =null

            if(columnIndexDescripcion>=0) {
                descripcion = cursor.getString(columnIndexDescripcion)
            }
            // Aquí puedes usar 'eventId' y 'title' como necesites
            evLista.add(EventoCalendario(eventId,title, descripcion))
            Log.d("MIDEBUG", "id= $eventId m titulo=$title, start=${descripcion}")
        }
    }
    return evLista
}


/**
 * Detalles del evento
 * Ejemplo de consulta a un Proveedor de Contenidos
 *
 * @param evId Identificador del evento
 * @param onRetroceder Indica a la pantalla padre que ha terminado
 */
@Composable
fun DetalleEvento(evId: String, onRetroceder: ()-> Unit){
    val contexto = LocalContext.current

    val ev = obtenerDetalles(evId,contexto)
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        FilaEvento(etiqueta = "Id :", valor =evId )
        FilaEvento(etiqueta = "Titulo :", valor =ev.titulo  )
        FilaEvento(etiqueta = "Descripción :", valor =ev.descripcion )
        FilaEvento(etiqueta = "F. Inicio :", valor = ev.dtstart )
        FilaEvento(etiqueta = "F. Fin :", valor = ev.dtend )
        FilaEvento(etiqueta = "Status :", valor =ev.status )



        Button(onClick = onRetroceder) {
            Text(text = "Volver")
        }
    }
}

@Composable
fun FilaEvento(etiqueta: String, valor: String?){
    var nuevoValor by remember{mutableStateOf(valor ?:"")}
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        Text(
            text = etiqueta,
            modifier = Modifier.align(Alignment.CenterVertically)
                .weight(1f)

            )
        TextField(
            modifier = Modifier.weight(2f),
            value = nuevoValor,
            onValueChange = { nuevoValor=it}
            )
    }


}


fun obtenerDetalles(evId: String, contexto: Context) : EventoCalendario{

     var evento : EventoCalendario = EventoCalendario()

    val projection = arrayOf(
        CalendarContract.Events._ID,
        CalendarContract.Events.TITLE)


    val laQuery = "${CalendarContract.Events._ID} = ?"
    val losArgumentos = arrayOf(evId)

    val cursor = contexto.contentResolver.query(
        CalendarContract.Events.CONTENT_URI,
        projection,
        laQuery,
        losArgumentos,
        null
    )
    when (cursor?.count) {
        null -> {
            /*
             * Insert code here to handle the error. Be sure not to use the cursor!
             * You may want to call android.util.Log.e() to log this error.
             *
             */
            Log.d("MIDEBUG","error en la busqueda evento =$evId")
        }
        0 -> {
            /*
             * Insert code here to notify the user that the search was unsuccessful. This isn't
             * necessarily an error. You may want to offer the user the option to insert a new
             * row, or re-type the search term.
             */
            Log.d("MIDEBUG","no se encuentra evento =$evId")
        }
        else -> {

            cursor.use {
                // Importante situar el cursor en el registro respuesta
                if (cursor.moveToFirst()) {
                    val columnIndexTitle = cursor.getColumnIndex(CalendarContract.Events.TITLE)
                    val columnIndexDescripcion =
                        cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION)
                    // ya tenemos evId
                    evento = evento.copy(titulo = cursor.getString(columnIndexTitle))
                    if (columnIndexDescripcion >= 0) {
                        evento = evento.copy(descripcion = cursor.getString(columnIndexDescripcion))
                    }
                    var index = cursor.getColumnIndex(CalendarContract.Events.DTSTART)
                    if (index >=0){
                        evento = evento.copy(dtstart = cursor.getString((index)))
                    }
                    index = cursor.getColumnIndex(CalendarContract.Events.DTEND)
                    if (index >=0){
                        evento = evento.copy(dtend = cursor.getString((index)))
                    }

                    index = cursor.getColumnIndex(CalendarContract.Events.DURATION)
                    if (index >=0){
                        evento = evento.copy(duracion = cursor.getString((index)))
                    }
                    index = cursor.getColumnIndex(CalendarContract.Events.STATUS)
                    if (index >=0){
                        evento = evento.copy(status = cursor.getString((index)))
                    }

                } // if cursor
               
                
                
            }
        }
    } // de when


    return evento
}