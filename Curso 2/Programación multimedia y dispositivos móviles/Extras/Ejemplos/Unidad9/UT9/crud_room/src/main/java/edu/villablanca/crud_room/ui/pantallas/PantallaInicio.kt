package edu.villablanca.crud_room.ui.theme.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.villablanca.crud_room.R
import edu.villablanca.crud_room.ui.theme.navegacion.Destinos
import edu.villablanca.crud_room.viewmodel.UsuarioViewModel
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/**
 * Lista con todos los usuarios. Cada usuario tiene dos botones: editar y borrar
 *
 * @param  controlNav para saltar a nuevas pantallas
 * @param usuarioViewModel que  conecta IU con Room
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInicio(controlNav: NavController, usuarioViewModel: UsuarioViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(R.string.inicio))
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        contentColor = Color.LightGray,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { controlNav.navigate(Destinos.AGREGAR.ruta) },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(R.string.agregar))
            }
        }
    ) {
        Contenido(it, controlNav, usuarioViewModel)
    }
}

@Composable
fun Contenido(
    pad: PaddingValues,
    controlNav: NavController,
    usuarioViewModel: UsuarioViewModel
) {
    val usuarioState = usuarioViewModel.usuariosState

    val usActual by usuarioViewModel.elUsuario.collectAsState()

    var confirmar by remember{ mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(pad)

    ) {
        LazyColumn() {
            items(usuarioState.usuarios){
                Card(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 16.dp
                    ),

                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = it.nombre)
                            Text(text= it.correo)
                        }
                        IconButton(
                            onClick = {
                                // Añadir estado para pasar a la ventana
                                usuarioViewModel.setUsuarioActual(it)
                                controlNav.navigate(Destinos.EDITAR.ruta)
                            }) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = stringResource(
                                R.string.editar
                            ) )
                        }
                        IconButton(
                            onClick = {
                                confirmar = true
                                usuarioViewModel.setUsuarioActual(it)
                               // usuarioViewModel.borrar(it)

                            }) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = stringResource(
                                R.string.borrar
                            ) )
                        }
                    }

                }
            }

        }
    } // de column
    if(confirmar){
        AlertDialog(
            onDismissRequest = { confirmar = false},
            confirmButton = {
                Button(
                    onClick = {
                        if (usActual != null )
                            usuarioViewModel.borrar( usActual!!.usuarioActual!!  )
                        confirmar = false }
                ) {
                    // No hacemos nada
                    Text("Si")
                }
            },
            title = { Text(stringResource(R.string.confirmacion)) },
            text = { Text("¿Seguro que deseas borrar el registro \n ${usActual!!.usuarioActual}?") },


            dismissButton = {
                Button(
                    onClick = { confirmar = false }
                ) {
                    // No hacemos nada
                    Text("No")
                }
            }
            )

    } //if
}