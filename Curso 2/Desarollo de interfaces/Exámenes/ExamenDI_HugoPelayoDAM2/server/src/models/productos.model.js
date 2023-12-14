/**
 * Define el modelo de datos para los productos
 * que vamos a almacenar en nuestra base de datos.
 * Necesario para mongo saber el tipo de dato que vamos
 * a almacenar.
 * 
 * 4 dec 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */

import mongoose from "mongoose";

const productSchema = new mongoose.Schema({
    // Definición de los campos para el modelo de productos
    // Este esquema define el modelo de datos para los
    // productos que vamos a guardar en nuestra base de datos Mongo
    nombre: {
        type: String,
        required: true,
        trim: true,
    },
    precio: {
        type: Number,
        required: true,
    },
    descripcion: {
        type: String,
        required: true,
        trim: true,
    },
    date: {
        type: String,
        default: Date.now
    },
}, {
    timestamps: true, // Habilita los campos createdAt y updatedAt automáticamente.
});

const Producto = mongoose.model("Producto", productSchema);

export default Producto;
