function visualizarDatos() {
    const gasolinaIsChecked = document.getElementById("gasolina-id").checked;
    const dieselIsChecked = document.getElementById("diesel-id").checked;

    if (gasolinaIsChecked == true) {
        alert("Gasolina is checked");
    }
}

function parseDatos() {
    let usuario = document.getElementById("usuario-input").value;
    let passwrd = document.getElementById("password-input").value;

    if (usuario === '' && passwrd === '') {
        alert('Los campos de Usuario y Contraseña son obligatorios');
        return;
    }
    else if (usuario === '') {
        alert('El campo de Usuario es obligatorio');
        return;
    }
    else if (passwrd === '') {
        alert('El campo de Contraseña es obligatorio');
        return;
    }

    alert('El usuario es: [ ' + usuario + ' ] y la pass: [ ' + passwrd + ' ]');
}