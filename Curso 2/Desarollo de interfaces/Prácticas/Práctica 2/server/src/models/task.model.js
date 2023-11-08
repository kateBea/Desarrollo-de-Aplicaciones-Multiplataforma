import mongoose from "mongoose";

const taskSchema = new mongoose.Schema({
    // Definición de los campos para el modelo de tareas
    title: {
        type: String,
        required: true,
        trim: true,
    },
    description: {
        type: String,
        required: true,
        trim: true,
    },
    date: {
        type: String,
        default: Date.now
    },
    user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: "user",
        required: true,
    },
    
}, {
    timestamps: true, // Habilita los campos createdAt y updatedAt automáticamente.
});

const Task = mongoose.model("Task", taskSchema);

export default Task;
