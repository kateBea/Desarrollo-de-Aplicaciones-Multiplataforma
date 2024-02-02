package edu.villablanca.crud_room.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import edu.villablanca.crud_room.entidad.Tarea
import edu.villablanca.crud_room.entidad.Usuario
import edu.villablanca.crud_room.modelo.TareaDao
import edu.villablanca.crud_room.modelo.UsuarioDao

@Database(
    entities = [Usuario::class, Tarea::class],
    version = 4,
    exportSchema = false
    )
abstract class BaseDatos : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    abstract fun tareaDao(): TareaDao
}