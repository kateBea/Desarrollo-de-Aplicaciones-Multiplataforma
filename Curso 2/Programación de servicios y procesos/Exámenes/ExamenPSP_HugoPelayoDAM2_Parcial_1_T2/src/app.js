const Express = require("express");
const Logger = require("morgan");
const Path = require("path");
const Ejs = require("ejs");
const CookieParser = require("cookie-parser");
const ExpressSession = require("express-session");
const Jwt = require("jsonwebtoken")

const PORT = 8080;
const JWT_PASSWORD = "adjadjVAS+";

const DB = {
    usuarios: [
        // usuarios son de la forma:
        // { user: "valor", pass: "valor" },
        { user: "pepe", pass: "12345" },
        { user: "lolo", pass: "12345" },
    ],

    entradas: [
        // entradas son de la forma:
        // { id: 1, titulo: "valor", contenido: "valor", autor: "valor" },
    ]
};

var contadorIdEntrada = 0;

// Inicializar servidor
const application = Express();


// Para uso de plantillas
application.set("views", Path.join(__dirname, "views"));
application.set("view engine", "ejs");

// Uso de logger
application.use(Logger("common"));

// Habilitar cookies
application.use(CookieParser());

// Activar peticiones POST
application.use(Express.urlencoded({ extended: true }));

// Para uso de sesiones
const TIEMPO_VIDA_COOKIE = 5 * 1000; // 1 min
application.use(
    ExpressSession({
        secret: "12345", 
        cookie: { maxAge: TIEMPO_VIDA_COOKIE }, 
        saveUninitialized: false,
        resave: false
    })
);


// Entrada principal
application.get("/inicio", (req, res) => {
    const VAL = 
    `
    <p>TITULO</p>
    <p>Escrito por AUTOR</p>
    <p>Id entrada IDENT</p>
    <p>CONTENIDO</p><br>
    `;

    let str = "";
    for (let index = 0; index < DB.entradas.length; ++index) {
        const entrada = str.replace("TITULO", DB.entradas[index].titulo)
            .replace("AUTOR", DB.entradas[index].autor)
            .replace("IDENT", DB.entradas[index].id)
            .replace("CONTENIDO", DB.entradas[index].contenido);

        str += entrada;
        
    }

    res.render("blog", { cuerpo: str });
});


function UserExists(username, password) {
    if (username == undefined || password == undefined) {
        return false;
    }

    for (let index = 0; index < DB.usuarios.length; ++index) {
        if (username === DB.usuarios[index].user &&
            password === DB.usuarios[index].pass) 
        {
            return true;
        }
    }

    return false;
}

// Autentificación
application.get("/acceso", (req, res) => {
    res.render("acceso");
});


// Gestión
application.post("/gestion", (req, res) => {
    const user = req.body["username"];
    const pass = req.body["password"];

    /*
    if(req.cookies) {
        console.log("hay token");
        const token = req.cookies['token'];

        if(token) {
            // Se comprueba que el token es válido
            const datos = Jwt.verify(token, JWT_PASSWORD, {algorithm: 'HS256'});

            if(datos) {
                // Sesión iniciada
                res.render("gestion");
            } else {
                res.render("accesoDenegado");
            }
        }
    }*/

    console.log(user + " " + pass);
    const result = UserExists(user, pass);
    console.log(result);

    if (!result) {
        res.render("accesoDenegado");
    } else {
        // usuario autentificado
        const token = Jwt.sign({ usuario: user }, JWT_PASSWORD, {algorithm: 'HS256', expiresIn: 60});
        
        res.cookie('token', token)
        res.render("gestion");
    }});

// Nueva
application.get("/nueva", (req, res) => {
    res.render("nuevaEntrada");
});

// Borrar
application.get("/borrar", (req, res) => {
    res.render("borrar");
});

// Cerrar
application.get("/cerrar", (req, res) => {        
    res.cookie('cierre', "cierre", { maxAge: 0 });
    res.render("cerrar");
});


console.log(`Servidor escuchando en puerto ${PORT}`);
application.listen(PORT);