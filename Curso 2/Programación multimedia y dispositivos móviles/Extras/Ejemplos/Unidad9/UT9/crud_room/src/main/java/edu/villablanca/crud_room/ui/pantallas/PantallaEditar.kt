package edu.villablanca.crud_room.ui.theme.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import edu.villablanca.crud_room.R
import edu.villablanca.crud_room.entidad.Usuario
import edu.villablanca.crud_room.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collect

/**
 * Parntalla para editar el usuario
 * @param  controlNav Navitagation para volver
 * @param  usuarioViewModel
 */
@Composable
fun PantallaEditar(controlNav: NavController, usuarioViewModel: UsuarioViewModel) {

    val usActual by usuarioViewModel.elUsuario.collectAsState()
    // No queremos guardar el usuario hasta que esten todos los camos
    var nombre by remember { mutableStateOf(usActual?.usuarioActual?.nombre ?:"" ) }

    var correo by remember { mutableStateOf(usActual?.usuarioActual?.correo ?:"" ) }

    Column(
        modifier = Modifier.fillMaxWidth(0.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = usActual?.usuarioActual?.nombre ?: stringResource(R.string.desconocido) )
        OutlinedTextField(
            value =nombre ,
            onValueChange = {nombre = it},
            label = { Text(text = stringResource(R.string.nombre))},
            )
        OutlinedTextField(
            value =correo,
            onValueChange = {correo = it},
            label = { Text(text = stringResource(R.string.correo))}
        )
        Button(onClick = {
            var usModificado: Usuario = Usuario(nombre = "error", correo = "error")

            if (usActual != null) {
                usModificado = usActual!!.usuarioActual?.copy(nombre = nombre, correo = correo) ?: usModificado
            }
            usuarioViewModel.actualizar(usModificado)
            controlNav.popBackStack()
        }) {
            Text(text= stringResource(R.string.guardar))
        }
    }
}