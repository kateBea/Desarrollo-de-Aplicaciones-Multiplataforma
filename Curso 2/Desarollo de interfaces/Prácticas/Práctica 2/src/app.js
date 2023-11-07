/**
 * Aplicación para inicializar el servidor.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */

import express from "express";
import morgan from "morgan";
import cookieParser from "cookie-parser";

import ruta from "./routes/author.routes.js";
import rutasTareas from "./routes/tasks.routes.js";

const app = new express();

// App uso los modulos
app.use(morgan("dev"));
app.use(express.json());

app.use(ruta);
app.use(rutasTareas);

app.use(cookieParser());

app.use("/api", ruta);

export default app;