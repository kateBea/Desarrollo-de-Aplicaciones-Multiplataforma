import mongoose from "mongoose";

export const connectDB = async () => {
    try {
        await mongoose.connect("mongodb://localhost/damdb");
        console.log("Base de datos conectada");
    } catch(error){
        console.log(error);
    }
};