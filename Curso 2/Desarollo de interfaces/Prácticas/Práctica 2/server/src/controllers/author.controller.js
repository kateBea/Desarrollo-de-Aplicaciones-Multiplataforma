/**
 * Define las funciones por cada ruta a nuestro servidor.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import bcrypt from "bcryptjs";
import usuario from "../models/user.model.js";
import { crearTokenAcceso } from "../libs/jwt.js";


/* Control de registro de nuevos usuarios */
export const register = async (req, res) => {
    // recogemos los datos del json
    const { email, password, username } = req.body;
    const encryptedPass = await bcrypt.hash(password, 10);
    
    try {
        const nuevoUsuario = new usuario({
            username,
            email,
            password: encryptedPass,
        });

        
        const usuarioSalvado = await nuevoUsuario.save();
        const token = await crearTokenAcceso({ id: usuarioSalvado._id });

        res.cookie("token", token);

        // Retroalimentación para indicar que los datos se guardaron correctamente
        res.json({
            message: "Usuario creado satisfactoriamente",
            id: nuevoUsuario._id,
            username: nuevoUsuario.username,
            email: nuevoUsuario.email,
            createdAt: nuevoUsuario.createdAt,
            updatedAt: nuevoUsuario.updatedAt,
        });
    }
    catch (error) {
        res.status(500).json({ message: error.message });
    }
};

/* Control de inicio de sesión para todo usuario */
export const login = async (req, res) => {
    const { email, password } = req.body;

    try {
        
        // Validamos el correo electrónico
        const usuarioEncontrado = await usuario.findOne({ email });
        if (!usuarioEncontrado) {
            return res.status(400).json({ message: "Usuario no encontrado"});
        }

        // Validamos la contraseña
        const coincidencia = await bcrypt.compare(password, usuarioEncontrado.password);
        if (!coincidencia) {
            return res.status(400).json({ message: "Contraseña incorrecta"});
        }

        const token = await crearTokenAcceso({ id: usuarioEncontrado._id });

        res.cookie("token", token);

        // Retroalimentación para indicar que los datos se guardaron correctamente
        res.json({
            message: "Usuario encontrado satisfactoriamente",
            id: usuarioEncontrado._id,
            username: usuarioEncontrado.username,
            email: usuarioEncontrado.email,
            createdAt: usuarioEncontrado.createdAt,
            updatedAt: usuarioEncontrado.updatedAt,
        });
    }
    catch(error) {
        res.status(500).json({ message: error.message });
    }

};

/* Control de cierre de sesión para todo usuario */
export const logout = async (req, res) => {
    res.cookie("token", "", {
        expires: new Date(0),
    });

    return res.sendStatus(200);
};

/* Accesso a perfil personal del usuario */
export const miPerfil = async (req, res) => {
    try {
        const usuarioEncontrado = await usuario.findById(req.user.id);

        if (!usuarioEncontrado) {
            return res.status(400).json({ message: "Usuario desconocido" });
        }

        return res.json({
            id: usuarioEncontrado._id,
            username: usuarioEncontrado.username,
            email: usuarioEncontrado.email,
            CreateAt: usuarioEncontrado.createdAt,
            UpdateAt: usuarioEncontrado.updatedAt,
        });
    } 
    catch (error) {
        return res.status(500).json({ message: "Error en el servidor" });
    }
};
  