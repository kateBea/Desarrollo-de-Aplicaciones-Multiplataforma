import bcrypt from "bcryptjs";
import usuario from "../modelos/user.model.js";
import userModel from "../modelos/user.model.js";
import { crearTokenAcceso } from "../librerias/jwt.js";

export const login = async (req, res) => {
    const { email, password } = req.body;

    try {
        const usuarioEncontrado = await usuario.findOne({email});
        
        if (!usuarioEncontrado) {
            return res.status(400).json({message: "Usuario no encontrado"});
        }

        const coincidencia = await bcrypt.compare(password, usuarioEncontrado.password);

        if (!coincidencia) {
            return res.status(400).json({message: "Contraseña incorrecta"});
        }

        const token = await crearTokenAcceso({id: usuarioEncontrado._id});

        res.cookie("token", token);
        res.json({
            message:    "Usuario encontrado satisfactoriamente",
            id:         usuarioEncontrado._id,
            username:   usuarioEncontrado.username,
            email:      usuarioEncontrado.email,
            createdAt:  usuarioEncontrado.createdAt,
            updatedAt:  usuarioEncontrado.updatedAt
        });
    } 
    catch (error) {
        res.status(500).json({ message: error.message });
    }
}

export const logout = async (req, res) => {
    res.cookie("token", "", {
        expires: new Date(0),
    });

    return res.sendStatus(200);
}

export const register = async (req, res) => {
    const { email, password, username } = req.body;

    const passwordHash = await bcrypt.hash(password, 10);

    try {
        const nuevoUsuario = new usuario({
            username,
            email,
            password: passwordHash,
        });    

        const usuarioSlvado = await nuevoUsuario.save();

        const token = await crearTokenAcceso({id: usuarioSlvado._id});

        res.cookie("token", token);
        res.json({
            message:    "Usuario creado satisfactoriamente",
            id:         nuevoUsuario._id,
            username:   nuevoUsuario.username,
            email:      nuevoUsuario.email,
            password:   nuevoUsuario.password,
            createdAt:  nuevoUsuario.createdAt,
            updatedAt:  nuevoUsuario.updatedAt
        });
    } 
    catch (error) {
        res.status(500).json({ message: error.message });
    }
};

export const miperfil = async (req, res) => {
    constusuarioEncontrado = awaitusuario.findById(req.user.id);

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