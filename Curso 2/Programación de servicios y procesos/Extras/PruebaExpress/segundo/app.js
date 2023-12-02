const express = require('express');
const bcryptjs = require("bcryptjs");

const app = express();

const path = require('path');

app.use(express.urlencoded({
    extended: true
}));

app.use('/static', express.static(path.join(__dirname, 'public')));


app.get('/', (req, res) => {
    res.send(`
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Entry point</title>
        </head>
    
        <body>
            <p1>Hi</p1>
            </form>
        </body>
    </html>
    `)
});

app.get('/formulario', (req, res) => {
    const nombre = req.query['nombre'];
    const pass = req.query['password'];

    const respuesta = `
        <!doctype html>
        <meta charset='utf-8'>
        <p>Tu nombre es ${nombre} y la contraseña ${pass}</p>
    `;

    res.send(respuesta);
});

app.post('/formulario', (req, res) => {
    const nombre = req.body['nombre'];
    const pass = req.body['password'];

    const respuesta = `
        <!doctype html>
        <meta charset='utf-8'>
        <p>Tu nombre es ${nombre} y la contraseña ${pass}</p>
    `;

    res.send(respuesta);
});

app.listen(8080);