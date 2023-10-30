import mongoose from "mongoose";

const modeloUsuario = new mongoose.Schema({
    username: {
        type: String,   // Campo username de tipo string
        require: true,
        trim: true,
    },
    email: {
        type: String,   // Campo email de tipo string
        require: true,
        trim: true,
        unique: true,
    },
    password: {
        type: String,    // Campo password de tipo string 
        require: true,  
    }
}, {
    timestamps: true,
});

export default mongoose.model("usuario", modeloUsuario);