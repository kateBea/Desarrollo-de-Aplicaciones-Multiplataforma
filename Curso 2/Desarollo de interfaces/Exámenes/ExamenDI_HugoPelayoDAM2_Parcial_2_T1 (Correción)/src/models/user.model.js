import mongoose from "mongoose";

const modeloUsuario = new mongoose.Schema({
    pieza: {
        type: String,
        require: true,
        trim: true,
    },
    precio: {
        type: String,
        require: true,
        trim: true,
    },
    descripcion: {
        type: String,
        require: true,
        trim: true,
    }
}, { timestamps: true });

export default mongoose.model("usuario", modeloUsuario);

