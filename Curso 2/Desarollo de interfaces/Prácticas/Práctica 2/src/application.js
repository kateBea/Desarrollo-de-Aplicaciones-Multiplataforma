import express from "express";
import morgan from "morgan";
import cookieParser from "cookie-parser";
import ruta from "./rutas/autor.routes.js";

const application = new express();

application.use(morgan("dev"));
application.use(express.json());
application.use(cookieParser())
application.use("/api", ruta);

export default application;