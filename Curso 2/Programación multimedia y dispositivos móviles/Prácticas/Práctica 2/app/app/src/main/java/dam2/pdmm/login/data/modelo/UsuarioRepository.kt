package dam2.pdmm.login.data.modelo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * Interfaz que define métodos para acceder y manipular datos de usuarios en la base de datos.
 *
 * Esta interfaz utiliza anotaciones de Room para definir consultas SQL y operaciones CRUD
 * (Create, Read, Update, Delete) sobre la tabla de usuarios.
 * */
@Dao
interface UsuarioRepository {

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param us El objeto Usuario que se va a insertar.
     * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(us: Usuario)

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     *
     * @param us El objeto Usuario con la información actualizada.
     * @return El número de filas actualizadas en la base de datos.
     * */
    @Update
    suspend fun actualizar(us: Usuario): Int

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param us El objeto Usuario que se va a eliminar.
     * */
    @Delete
    suspend fun borrar(us: Usuario)

    /**
     * Obtiene un usuario de la base de datos basado en su nombre de usuario y contraseña.
     *
     * @param username El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     * @return El objeto Usuario correspondiente al nombre de usuario y contraseña proporcionados,
     *         o null si no se encuentra ningún usuario con esas credenciales.
     * */
    @Query("SELECT * FROM Usuario WHERE username = :username AND password = :password")
    suspend fun obtenerUsuario(username: String, password: String): Usuario?

    /**
     * Obtiene todos los usuarios almacenados en la base de datos.
     *
     * @return Una lista de todos los usuarios almacenados en la base de datos.
     * */
    @Query("SELECT * FROM Usuario")
    suspend fun obtenerTodo(): List<Usuario>
}