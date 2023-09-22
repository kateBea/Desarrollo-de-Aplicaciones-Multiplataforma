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

    document.close();

    document.write(
        `
        <link rel="stylesheet" href="styles.css" type="text/css">

        <form>
            <div>
                <input type="text" value="Usuario" disabled="disabled">
                <input size="50" type="Usuario">
            </div>
            
            <span>
            <div>
                <input type="radio" id="3-uertas" name="puertas">3 Puertas
                <input type="checkbox" id="gasolina-id" name="gasolina">Gasolina<br/>
            </div>

            <div>
                <input type="radio" id="5 Puertas" name="puertas">5 Puertas
                <input type="checkbox" id="diesel-id" name="diesel">Diesel
            </div>
            </span>
            <span>
                <h1>Precio: </h1>
            </span>

            <div>
            <textarea disabled="disabled"></textarea>
            </div>

            <div>
                <div><button onclick="visualizarDatos()">Visualizar</button></div>
            </div>
        </form>
        `
    );
}