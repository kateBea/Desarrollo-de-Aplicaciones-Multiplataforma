/**
 * Define las funciones por cada 
 * ruta a nuestro servidor. Tenemos definidas las
 * rutas a las cuales puede hacer peticiones nuestro frontend
 * para poder registrar productos o consultar la lista 
 * de productos actuales en nuestra base de datos.
 * 
 * 4 dec 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */

import ProductoModel from "../models/productos.model.js";

export const registroProductos = async (req, res) => {
    // recogemos los datos del json
    const { nombre, precio, descripcion } = req.body;

    // Depuración
    console.log(`Nombre ${nombre}\nCantidad: ${precio}\nDesc: ${descripcion}`);
    
    try {
        // creamos un nuevo producto a partir del modelo predefinido
        const nuevoProducto = new ProductoModel({
            nombre: nombre,
            precio: parseFloat(precio),
            descripcion: descripcion,
        });

        // guardamos el modelo y esperamos a que se serialicen los cambios
        const productoSalvado = await nuevoProducto.save();

        // Retroalimentación para indicar que los datos se guardaron correctamente
        res.json({
            message: "Producto creado satisfactoriamente",
            id: nuevoProducto._id,
            nombre: nuevoProducto.nombre,
            precio: nuevoProducto.precio,
            descripcion: nuevoProducto.descripcion,
            createdAt: nuevoProducto.createdAt,
            updatedAt: nuevoProducto.updatedAt,
        });
    }
    catch (error) {
        console.error(`Error al procesar registro de producto ${error.message}`);
        res.status(500).json({ message: error.message });
    }
};

export const consultaProductos = async (req, res) => {
    // realmente no debería enviar nada para esto el cliente
    // simplemente le vamos a enviar una lista 
    // con todos los productoa actualemnte registrados
    const results = await ProductoModel.find({});
    
    try {
        console.log(results);

        // results es una lista con todos los productos 
        // actualmente registrados en nuestra DB mongo
        res.json({ results });
    }
    catch(error) {
        res.status(500).json({ message: error.message });
    }

};