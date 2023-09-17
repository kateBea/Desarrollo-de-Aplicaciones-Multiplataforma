
{
    let nombre = prompt("Nombre: ");
    let apellido = prompt("Apellido: ");

    document.writeln('<p>', "Tu nombre es: ", nombre, '</p>');
    document.writeln("Tu apellido es: ", apellido);
}

function getInput() {
    let nombre = prompt("Nombre: ");
    let apellido = prompt("Apellido: ");

    alert("Nombre es: " + nombre + ' ' + apellido);
}

