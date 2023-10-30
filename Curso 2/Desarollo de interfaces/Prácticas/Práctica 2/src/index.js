import application from "./application.js";
import { connectDB } from "./db.js";

const port = 4000;
application.listen(port);
console.log(`Servidor abierto en puerto ${port}`);

connectDB();