// Se cierra la sesión del usuario

var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
    if(req.session.usuario) {
        req.session.destroy()
        res.render('logout')
    }
});

module.exports = router;
