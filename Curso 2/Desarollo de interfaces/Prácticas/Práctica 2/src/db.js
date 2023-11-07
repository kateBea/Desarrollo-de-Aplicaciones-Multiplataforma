/**
 * Establece una conexión con la base de datos mongo.
 * 
 * 6 nov 2023
 * Hugo Pelayo
 * Node ver: v18.8.0
 * */

import mongoose from "mongoose";

export const connectDB = async () =>  {
    // Conexión que deberíamos usar en caso de tener el atlas funcionando, sin embargo lo haremos con docker.
    // const connectionString = "mongodb+srv://myDatabaseUser:D1fficultP%40ssw0rd@cluster0.example.mongodb.net/?retryWrites=true&w=majority";

    // 27017 es el puerto por defecto que ofrece mongodb con docker
    const connectionString = "mongodb://localhost:27017/dam2";

    try {
        mongoose.connect(connectionString);
        console.log("Base de datos conectada con éxito.");
    }
    catch (error) {
        console.log(error);
    }
};
