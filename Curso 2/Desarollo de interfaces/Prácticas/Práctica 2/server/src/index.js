/**
 * Entrada principal a nuestro backend.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */


/* Imports */

import app from "./app.js";
import { connectDB } from "./db.js";

/* Constantes */
const LISTEN_PORT = 4000;


// Escuha en el puerto
app.listen(LISTEN_PORT);

console.log(`Servidor escuchando en el puerto ${LISTEN_PORT}`);

connectDB();