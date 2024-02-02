package edu.villablanca.crud_room.entidad

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id :Long =0,

    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="correo")
    val correo: String
)