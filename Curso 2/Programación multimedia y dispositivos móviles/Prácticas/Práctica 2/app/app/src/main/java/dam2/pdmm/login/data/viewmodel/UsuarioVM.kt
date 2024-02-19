package dam2.pdmm.login.data.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dam2.pdmm.login.data.modelo.Usuario
import dam2.pdmm.login.data.modelo.UsuarioRepository
import kotlinx.coroutines.launch

/**
 * Clase ViewModel que gestiona la lógica de presentación y la interacción con el repositorio de usuarios.
 *
 * @param repository El repositorio de usuarios que proporciona métodos para acceder y manipular
 *                    datos de usuarios en la base de datos.
 * */
class UsuarioVM(val repository: UsuarioRepository) : ViewModel() {

    /**
     * Contiene el contexto actual de los datos de la base de datos
     * que se van a necesitar en la interfaz.
     * */
    var usuariosState by mutableStateOf(UsuarioState())
        private set


    /**
     * Establece el usuario actual mediante el nombre de usuario y la contraseña proporcionados.
     *
     * @param username El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     * */
    fun setUsuarioActual(username: String, password: String) = viewModelScope.launch {
        usuariosState.usuarioActual = repository.obtenerUsuario(username, password)
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param usuario El objeto Usuario que se va a insertar.
     * */
    fun insertar(usuario: Usuario) = viewModelScope.launch {
        repository.insertar(usuario)
    }

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     *
     * @param usuario El objeto Usuario con la información actualizada.
     * */
    fun actualizar(usuario: Usuario) = viewModelScope.launch {
        val resultado = repository.actualizar(usuario)

        if (resultado > 0) {
            Log.d("DEBUG", "Se han modificado $resultado filas al actualizar $usuario")
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param usuario El objeto Usuario que se va a eliminar.
     * */
    fun borrar(usuario: Usuario) = viewModelScope.launch {
        repository.borrar(usuario)
    }
}
