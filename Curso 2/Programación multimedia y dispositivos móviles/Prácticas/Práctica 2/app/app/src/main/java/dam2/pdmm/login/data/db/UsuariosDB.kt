package dam2.pdmm.login.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dam2.pdmm.login.data.modelo.Usuario
import dam2.pdmm.login.data.modelo.UsuarioRepository

/**
 * Clase abstracta que representa la base de datos principal para la gestión de usuarios.
 *
 * Esta clase extiende RoomDatabase, que es la biblioteca de persistencia de datos en Android
 * que proporciona una capa sobre SQLite para interactuar con la base de datos.
 * */
@Database(
    entities = [Usuario::class],
    version = 4,
    exportSchema = false
)
abstract class UsuarioDB : RoomDatabase() {

    /**
     * Método abstracto que devuelve el objeto UsuarioRepository. Que nos permite
     * comunicarnos con la base de datos.
     *
     * @return Instancia de UsuarioRepository para interactuar con la entidad Usuario en la base de datos.
     * */
    abstract fun usuarioRepository(): UsuarioRepository
}