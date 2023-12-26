/**
 * Define las rutas para las operaciones CRUD
 * sobre productos en nuestra Base de datos.
 * 
 * 4 dec 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import { Router } from "express";
import { createSchema } from "../schemas/product.schema.js";
import { validateSchema } from "../middlewares/validator.middleware.js";
import { registroProductos, consultaProductos } from "../controllers/products.controller.js";

const router = new Router();

// petición para obtener la lista de productos en la DB
router.get("/productos", consultaProductos);

// validamos el esquema antes de registrar el producto, una vez validado
// el modelo de datos que pasamos, registramos el producto
router.post("/registro", validateSchema(createSchema), registroProductos);

export default router;