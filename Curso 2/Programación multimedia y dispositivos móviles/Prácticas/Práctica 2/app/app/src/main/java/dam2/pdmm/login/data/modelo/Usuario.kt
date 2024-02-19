package dam2.pdmm.login.data.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Clase que representa a un usuario en la base de datos.
 *
 * Esta clase define la estructura de la tabla de usuarios en la base de datos Room.
 * Cada instancia de esta clase corresponde a una entrada en la tabla de usuarios.
 */
@Entity
class Usuario {
    /**
     * Identificador único del usuario, utilizado como clave primaria en la base de datos.
     * */
    @PrimaryKey
    var username: String = ""

    /**
     * Contraseña del usuario.
     * */
    @ColumnInfo(name = "password")
    var password: String = ""

    /**
     * Dirección de correo electrónico del usuario.
     * */
    @ColumnInfo(name = "email")
    var email: String = ""

    /**
     * Número de teléfono del usuario.
     * */
    @ColumnInfo(name = "phone_number")
    var phoneNumber: String = ""
}