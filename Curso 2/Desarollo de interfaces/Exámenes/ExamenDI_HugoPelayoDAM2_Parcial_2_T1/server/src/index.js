/**
 * Entrada principal a nuestro backend.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */


import app from "./app.js";
import { connectDB } from "./db.js";


const LISTEN_PORT = 4000;


app.listen(LISTEN_PORT);
console.log(`Servidor escuchando en el puerto ${LISTEN_PORT}`);
connectDB();