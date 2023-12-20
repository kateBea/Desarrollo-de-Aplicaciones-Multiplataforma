const Express = require("express");
const FileSystem = require("fs");
const Logger = require("morgan");
const Path = require("path");
const Ejs = require("ejs");

const PORT = 8080;

const application = Express();
const basicForm = FileSystem.readFileSync("./assets/basicForm.html", { encoding: "utf8"});

// para uso de plantillas
application.set("views", Path.join(__dirname, "views"));
application.set("view engine", "ejs");

application.use(Logger("common"));

// activar peticiones POST
application.use(Express.urlencoded({ extended: true }));

// Middlewares
application.use((req, res, next) => {
    console.log("Middleware 1");

    console.log(`Visitando ruta ${req.url}`);

    // Si no llamamos a next o lo llamamos con un string
    // no se pasa al siguiente middleware en la cadena.
    next();
});

application.use((req, res, next) => {
    console.log("Middleware 2");

    console.log(`Visitando ruta ${req.url}`);

    next();
});

// Middleware que se ejecuta sólo cuando se visita cierta ruta
// No es necesario aceptar primero peticiones a esa ruta, pero sí
// si queremos atender peticiones si se accede a esa ruta, el mensaje
// de este middleware se imprime por consola incluso si no atendemos peticiones a /hola
application.use("/hola", (req, res, next) => {
    console.log("Middleware 3 - Hola"); 
    next();
});

application.get("/", (req, res) => {
    res.send(basicForm);
});

application.post("/saludo", (req, res) => {
    const nombre = req.body["nombre"];

    const respuesta = 
        `<!doctype html>        
        <meta charset='utf-8'>        
        <p>Hola ${nombre} </p>`; 
    
    res.send(respuesta);
});

console.log(`Servidor escuchando en puerto ${PORT}`);
application.listen(PORT);