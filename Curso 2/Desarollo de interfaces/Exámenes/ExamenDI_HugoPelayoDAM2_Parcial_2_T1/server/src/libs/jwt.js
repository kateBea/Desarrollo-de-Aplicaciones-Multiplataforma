/**
 * Define tokens de intercomunicación.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import jwt from "jsonwebtoken";
import { TOKEN_SECRET_KEY } from "../config.js";

export function crearTokenAcceso(payload) {
    return new Promise((resolve, reject) => {
        jwt.sign(
            payload,
            TOKEN_SECRET_KEY,
            {
                expiresIn: "1d",
            },
            (err, token) => {
                if (err) {
                    reject(err);
                }

                // si no hay error nos devuelve 
                // el token ya codificado
                resolve(token);
            }
        )
    });
};

