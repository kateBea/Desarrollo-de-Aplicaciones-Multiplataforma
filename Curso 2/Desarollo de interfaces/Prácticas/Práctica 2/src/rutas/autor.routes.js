import { Router } from "express";
import { login, register, logout, miperfil } from "../controladores/autor.controlador.js";
import { autorizacionRequerida } from "../seguridad/verificacionRuta.js";

const ruta = new Router();

ruta.post('/register', register);
ruta.post('/login', login);
ruta.post('/logout', logout);

ruta.get('/miPerfil', autorizacionRequerida, miperfil);

export default ruta;