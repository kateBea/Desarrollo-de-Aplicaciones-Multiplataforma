import express from "express";
import morgan from "morgan";
import ruta from "./rutas/autor.routes.js";

// instanciamos nueva aplicación
const application = new express();

application.use(morgan("dev"));
application.use(express.json());
application.use(ruta);

export default application;

// const port = 4000;
// application.listen(port);
// console.log("Servidor abierto en puerto " + port);