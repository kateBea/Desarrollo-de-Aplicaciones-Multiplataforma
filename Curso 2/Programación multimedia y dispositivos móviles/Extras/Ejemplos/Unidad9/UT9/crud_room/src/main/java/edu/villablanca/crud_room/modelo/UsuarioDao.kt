package edu.villablanca.crud_room.modelo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import edu.villablanca.crud_room.entidad.Usuario
import edu.villablanca.crud_room.entidad.UsuarioTarea
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(us: Usuario): Long

    @Update
    suspend fun actualizar(us: Usuario)

    @Delete
    suspend fun borrar(us: Usuario)

    @Query("SELECT * from usuario WHERE id = :id")
    fun obtenerUsuario(id: Long): Flow<Usuario>
    @Query("SELECT * FROM usuario")
    fun obtenerTodo(): Flow<List<Usuario>>

    // Relaciones
    @Transaction
    @Query("SELECT * FROM Usuario")
    fun obtenerTodosUsuarioTarea(): List<UsuarioTarea>

    @Transaction
    @Query("SELECT * FROM Usuario WHERE id = :userId")
    fun getUsuarioConTarea(userId: Long): UsuarioTarea
}