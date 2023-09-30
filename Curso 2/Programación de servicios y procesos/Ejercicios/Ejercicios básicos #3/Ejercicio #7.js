function Persona(nombre, apellido1, apellido2) {
    this.nombre = nombre.trim();
    const segundoApellido = (apellido2 != undefined && apellido2 != null) ? (" " + apellido2.trim()) : '';
    this.apellidos = apellido1.trim() + segundoApellido;

    this.apellidosNombre = () => { return this.apellidos + ", " + this.nombre; }
}

function tests() {
    if (process.argv.length < 4) {
        console.log("Número de argumentos inválido...");
        console.log("usage: node ejercicio7 nombre apellido1 [apellido2]");
        return;
    }

    const persona1 = new Persona(process.argv[2], process.argv[3], process.argv[4]);
    console.log("Persona: " + persona1.apellidosNombre());
}

tests()