import jwt from "jsonwebtoken";
import { TOKEN_SECRET_KEY  } from "../config.js";

export const autorizacionRequerida = (req, res, next) => {

    const { token } = req.cookiers;

    if (!token) {
        return res.status(401).json({message: "No autorizado"});
    }

    jwt.verify(token, TOKEN_SECRET_KEY, (err, user) => {
        if (err) {
            return res.status(401).json({message: "Token inválido"});
            req.user = user;
            next();
        }
    });
};