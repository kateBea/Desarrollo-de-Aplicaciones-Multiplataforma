const express = require('express');

const app = express();

const path = require('path');
app.use('/static', express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
    res.send('Hola mundo')
});

app.get('/formulario', (req, res) => {
    const nombre = req.query['nombre'];

    const respuesta = `
        <!doctype html>
        <meta charset='utf-8'>
        <p>Hola ${nombre} </p>
    `;

    res.send(respuesta);
});

app.listen(8080);