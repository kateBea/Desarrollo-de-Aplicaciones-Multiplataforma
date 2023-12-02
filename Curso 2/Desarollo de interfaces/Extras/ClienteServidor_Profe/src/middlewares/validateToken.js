import jwt from 'jsonwebtoken';   //Librería de node para trabajar con los token
import { TOKEN_SECRET } from '../config.js';

export const authRequired = (req, res, next) => {     //función de paso, por eso le pasamos el next.
    const { token } = req.cookies;   //guardamos en la variable token el valor que nos llega desde el cliente en las cookies.

    if (!token)  //No existe token, entonces error
        return res.status(401).json({ mesage: "No token, autenticación rechazada" });


    jwt.verify(token, TOKEN_SECRET, (err, user) => { //comprobamos el token que nos envía el frontend. Nos va a generar un error o nos devolverá datos
        if (err) return res.status(403).json({ mesage: "Token inválido" });

        req.user = user;

        next();
    });

}