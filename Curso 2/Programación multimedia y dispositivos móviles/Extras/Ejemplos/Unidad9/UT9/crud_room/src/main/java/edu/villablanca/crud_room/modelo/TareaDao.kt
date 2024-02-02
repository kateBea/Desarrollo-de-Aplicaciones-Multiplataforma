package edu.villablanca.crud_room.modelo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import edu.villablanca.crud_room.entidad.Tarea
import edu.villablanca.crud_room.entidad.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
 interface TareaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun insertar(tarea: Tarea)

     @Update
     suspend fun actualizar(tarea: Tarea)

     @Delete
     suspend fun borrar(tarea: Tarea)


    @Query("SELECT * from tarea WHERE id = :id")
    fun obtenerTarea(id: Long): Flow<Tarea>
    @Query("SELECT * FROM tarea")
    fun obtenerTodo(): Flow<List<Tarea>>

}