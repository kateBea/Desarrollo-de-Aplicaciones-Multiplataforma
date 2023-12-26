/**
 * Define las rutas de control de acceso al perfil del usuario.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import jwt from "jsonwebtoken";
import { TOKEN_SECRET_KEY } from "../config.js";

export const autorizacionRequerida = (req, res, next) => {
    const { token } = req.cookies;

    if (!token) {
        return res.status(401).json({ message: "Acesso no autorizado " });
    }

    jwt.verify(token, TOKEN_SECRET_KEY, (err, user) => {
        if (err) {
            return res.status(403).json({ message: "Token no válido" });
        }

        req.user = user;
        
        next();
    });
}