// Se solicita usuario y contraseña y se inicia la sesión
// asignando permisos al usuario.

var express = require('express');
var router = express.Router();
const perm = require('../permissions')

router.get('/', function(req, res, next) {
    if(req.session.usuario) {
        console.log('Sesión iniciada')
        res.redirect('/inicio')
    }
    res.render('login', {login_error: "none"});
});

router.post('/', function(req, res, next) {
    const usuario = req.body['usuario']
    const password = req.body['password']
    if(req.session.usuario) {
        res.redirect('/inicio')
    } if(usuario === 'admin' && password === 'admin') {
        // FIXME: Nunca usar contraseñas codificadas directamente
        // Se inicia la sesión
        req.session.usuario = usuario
        req.session.permission = perm.ADMIN
        res.redirect('/inicio')
    } if(usuario === 'user' && password === 'user') {
        // FIXME: Nunca usar contraseñas codificadas directamente
        // Se inicia la sesión
        req.session.usuario = usuario
        req.session.permission = perm.USER
        res.redirect('/inicio')
    } else {
        if(!usuario && !password)
            res.render('login', {login_error: "none"});
        else
            res.render('login', {login_error: "inline"});
    }
});

module.exports = router;
