package edu.villablanca.ejercicios.viewmodel

import androidx.lifecycle.ViewModel

import edu.villablanca.ejercicios.modelo.Usuario
import edu.villablanca.ejercicios.uistates.LoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uistate = MutableStateFlow(LoginUIState())
    val uistate: StateFlow<LoginUIState> = _uistate.asStateFlow()

    val usuarios = mutableListOf(Usuario(nombre = "Pepe", clave = "super"))

    /**
     * Si es registro se comprueba que no exista uno igual
     */

    fun actualizaNombre(nom: String) {
        _uistate.update { valor ->
            valor.copy(nombre = nom)
        }
    }

    /**
     * En registro poner alguna regla para la clave
     */
    fun actualizaClave(clave: String) {
        _uistate.update {
            it.copy(clave = clave)
        }
    }

    /**
     * Comrpobar formato de correo
     */
    fun actualizaCorreo( correo : String) {
        _uistate.update {
            it.copy(correo = correo)
        }
    }
    fun actualizarTelefono( telefono: String) {
        _uistate.update {
            it.copy(telefono = telefono)
        }
    }



    //Comprueba que el usuario en _uistate esté autorizado en la lista usuarios
    // Para esta prueba la lista tiene siempre un unusuaio
    // llamado desde pantallaLogin
    fun usuarioValido() {
        val ok = usuarios.any { it.nombre == _uistate.value.nombre && it.clave == _uistate.value.clave }
      //  val ok = usuarios[0].usuarioAutorizado(_uistate.value.nombre, _uistate.value.clave)

        _uistate.update {
            it.copy(
                usuarioAutenticado = ok,
                errorAutenticacion = !ok,
                )
        }
    }
    fun resetLogin(){
        _uistate.update {
            it.copy(
                nombre="",
                clave = "",
                usuarioAutenticado = false,
                errorAutenticacion = false,

            )
        }
    }

    /**
     * Añade el usuario ya comprobado
     */
    fun nuevoUsuario(){
        usuarios.add(
            Usuario(
                nombre = _uistate.value.nombre,
            clave = _uistate.value.clave,
            correo = _uistate.value.correo,
            numeroTelefono = _uistate.value.telefono
        ))
    }

}

