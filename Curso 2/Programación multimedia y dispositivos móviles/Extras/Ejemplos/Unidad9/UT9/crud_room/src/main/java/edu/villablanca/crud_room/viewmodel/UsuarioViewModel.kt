package edu.villablanca.crud_room.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.villablanca.crud_room.entidad.Usuario
import edu.villablanca.crud_room.modelo.UsuarioDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel para el usuario
 * Conecta todas las operaciones del IO con operaciones en UsuarioDao
 *
 * @param dao  UsuarioDao para acceso a Room
 *
 * Se duplica con var usuarioState como demostración de dos formas
 * de mantener los estados (State y y StateFlow)
 *
 */
class UsuarioViewModel(val dao: UsuarioDao): ViewModel(){

    private val _elUsuario = MutableStateFlow(UsuarioState())
    val elUsuario : StateFlow<UsuarioState?> = _elUsuario
     var usuariosState by mutableStateOf(UsuarioState())
         private set

     init {
         viewModelScope.launch {
             dao.obtenerTodo().collectLatest {
                 usuariosState = usuariosState.copy(usuarios= it)
             }
         }
     }

    /**
     * UsuarioActual para comunicar entre ventanas
     */

    fun setUsuarioActual(us: Usuario){
        //_usuario.update { _usuario.copy(usuarioActual = us ) } =
        _elUsuario.value.usuarioActual = us
    }
    fun ponUsuarioActual(us: Usuario){

    }
    fun insertar(usuario: Usuario) = viewModelScope.launch {
        dao.insertar(usuario)
    }

    fun actualizar(us: Usuario) = viewModelScope.launch {
        Log.d("MIDEBUG", "---->USUARIO para actualizar = ${us.toString()}")
        dao.actualizar(us)
    }
    fun borrar(us:Usuario) = viewModelScope.launch {
        dao.borrar(us)
    }
 }
