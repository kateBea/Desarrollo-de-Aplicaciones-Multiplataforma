package edu.villablanca.ut9.ui.theme.pantallas

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.*

/**
 *
 *  1 - Permisos en tiempo real
 *
 *  Revisar https://google.github.io/accompanist/permissions/
 *  Documentacion: https://google.github.io/accompanist/permissions/
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PantallaListaContactos() {
    val contexto = LocalContext.current


    // Permisos para contacto
    val contactosPermissionState = rememberPermissionState(android.Manifest.permission.READ_CONTACTS)


    if (contactosPermissionState.status.isGranted) {
    // Tenemos permiso
        
        Column {
            Text("Concedidos Permisos para leer contactos ")
            val contactos = getContactList(contexto)
            ContactList(contactList = contactos)
        }
       
    } else {
        // Pedimos permiso
        Column {
            val textToShow = if (contactosPermissionState.status.shouldShowRationale) {
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
            Button(onClick = { contactosPermissionState.launchPermissionRequest() }) {
                Text("Request permission")
            }
        }
    }
}


/**
 * Obtine la lista de contactos
 */
fun getContactList(context: Context): List<String> {
    val contactList = mutableListOf<String>()

    val cursor = context.contentResolver.query(
        ContactsContract.Contacts.CONTENT_URI,
        null,
       null,
        null,
    null
    )

    when (cursor?.count){
        null ->{}
        0 -> {}
        else -> {
            // hay resultados, que pueden ser null
            // sabemos que el cursor no es null
            cursor.let {
                while (it.moveToNext()) {
                    val indice = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)
                    if (indice >=0){
                        val name = it.getString(indice)
                        Log.d("MIDEBUG","$indice -> $name")
                        if (name !=null)
                            contactList.add(name)
                    }

                }
                it.close()
            }
        }
    }


    return contactList
}
@Composable
fun ContactList(contactList: List<String>) {
    LazyColumn {
        items(contactList){contacto ->
            Text(contacto)
        }

    }
}

