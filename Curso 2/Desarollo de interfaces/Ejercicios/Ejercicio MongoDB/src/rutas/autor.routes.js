import { Router } from "express";
import { login, register, logout } from "../controladores/autor.controlador.js";

const ruta = Router();

ruta.post("/register", register);
ruta.post("/login", login);
ruta.post("/logout", logout);

export default ruta;
