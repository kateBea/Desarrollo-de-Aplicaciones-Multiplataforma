var username;
var email;
var password;
var terminosChecked;
var adsChecked;
var registrado;


function registrar() {
    username = document.getElementById("username").value;
    email = document.getElementById("email").value;
    password = document.getElementById("password").value;

    const repeatedPass = document.getElementById("repeat-pass").value;

    terminosChecked = document.getElementById("terminos-priv").checked;
    adsChecked = document.getElementById("publicidad").checked;

    // DEBUG
    console.log("Usuario:             " + username);
    console.log("Email:               " + email);
    console.log("Contraseña:          " + password);
    console.log("Contraseña repetida: " + repeatedPass);

    console.log("Aceptado términos y condiciones: " + terminosChecked);
    console.log("Publicidad por correos: " + adsChecked);

    if (!terminosChecked) {
        alert("Es imprescindible marcar la casilla de términos y condiciones");
        return;
    }

    registrado = true;
    alert("Se ha dado de alta al usuario " + username);
}

function serializar() {
    if (!registrado) {
        alert("Debe registrarse primero");
        return;
    }

    const doc = new jsPDF();

    doc.text(10, 10, "Datos de registro");

    doc.autoTable({
        theme: 'plain',         // Tema de la tabla (plain, striped, grid)
        styles: {
            fontSize: 12,       // Estilos para la tabla
            font: 'helvetica',  // Fuente de la tabla
            lineWidth: 0.2,     // Grosor de las líneas
        },
        head: [['Campo', 'Valor']],
        body: [
            ["Usuario", username],
            ["Email", email],
            ["Password", password],
        ],
    });

    doc.save('Registro.pdf');
}