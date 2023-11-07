/**
 * Configuración de rutas del servidor.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v21.0.0
 * */

import { Router } from "express";
import { login, register, logout, miPerfil } from "../controllers/author.controller.js";
import { autorizacionRequerida } from "../middlewares/validate.token.js";

const ruta = Router();

ruta.post("/register", register);
ruta.post("/login", login);
ruta.post("/logout", logout);

ruta.get("/miPerfil", autorizacionRequerida, miPerfil);

export default ruta;