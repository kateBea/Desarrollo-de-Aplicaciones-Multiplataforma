package edu.villablanca.crud_room.entidad

import androidx.room.Embedded
import androidx.room.Relation


/**
 * Observar el uso de las comas: ,
 */
data class UsuarioTarea(
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "id",
        entityColumn = "usuarioId"
    )
    val tarea: Tarea

)