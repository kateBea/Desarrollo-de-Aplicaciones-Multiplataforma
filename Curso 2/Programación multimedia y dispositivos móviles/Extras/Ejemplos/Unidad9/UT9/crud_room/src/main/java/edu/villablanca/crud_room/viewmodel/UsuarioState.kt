package edu.villablanca.crud_room.viewmodel

import edu.villablanca.crud_room.entidad.Usuario
import edu.villablanca.crud_room.entidad.UsuarioTarea

/**
 * Datps para el viewModel
 * @param  usuarios : Lista con todos los usuarios
 * @param usuarioActual : usuario seleccionado en pantallaInicio
 */
data class UsuarioState(
    val usuarios: List<Usuario> = emptyList(),
    var usuarioActual : Usuario? = null,
    var usuarioTareaActual: UsuarioTarea?=null

)
