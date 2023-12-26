import app from './app.js';
import { connectDB } from './db.js';

connectDB();
app.listen(4000);
console.log("Servidor abierto en puerto 4000");