package edu.villablanca.ejercicios.uistates

data class LoginUIState(
    val nombre: String ="",
    val clave: String="",
    val correo: String="",
    val telefono: String="",
    val usuarioAutenticado: Boolean  = false,
    val errorAutenticacion: Boolean = false,
)
