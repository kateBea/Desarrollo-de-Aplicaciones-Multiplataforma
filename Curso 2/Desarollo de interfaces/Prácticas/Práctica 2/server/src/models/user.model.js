/**
 * Define modelos de datos para verificar los datos
 * con que trabaja el backend.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */

import mongoose from "mongoose";

const modeloUsuario = new mongoose.Schema({
    // Definición de los campos ( esquema de datos ) con
    // trabajamos con las operaciones CRUD

    // Nombre de usuario
    username: {
        type: String,
        require: true,
        trim: true,
    },
    // Email del usuario ( único por usuario )
    email: {
        type: String,
        require: true,
        trim: true,
        unique: true
    },
    // Contraseña del usuario
    password: {
        type: String,
        require: true,
    },

}, {
    timestamps: true,
});

export default mongoose.model("usuario", modeloUsuario);