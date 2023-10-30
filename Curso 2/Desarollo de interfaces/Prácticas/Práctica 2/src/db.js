import mongoose from "mongoose";

export const connectDB = async() => {
    try {
        const connectionString = "mongodb://localhost/dam2";
        mongoose.connect(connectionString);

        console.log("Establecida conexión con base de datos Mongo");
    } 
    catch (error) {
        console.error(error);
    }
};