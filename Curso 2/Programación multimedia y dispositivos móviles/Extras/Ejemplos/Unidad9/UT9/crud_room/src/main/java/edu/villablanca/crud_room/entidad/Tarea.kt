package edu.villablanca.crud_room.entidad

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val descripcion: String ="",

    // para la relacion uno-uno
    val usuarioId: Long,
)
