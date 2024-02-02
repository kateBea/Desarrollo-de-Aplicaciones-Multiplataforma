package edu.villablanca.ejercicios.modelo

class Usuario(var nombre: String,
    var clave: String,
    var correo: String ="",
    var numeroTelefono: String=""
    ) {

    fun usuarioAutorizado(nom: String, pass: String): Boolean{
        return if (nombre == nom && clave == pass) true else false
    }
}