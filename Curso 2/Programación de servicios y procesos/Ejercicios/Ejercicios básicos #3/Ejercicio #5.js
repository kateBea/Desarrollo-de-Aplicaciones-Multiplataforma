function tests() {
    const strOriginal = "\tSiempre encuentra una razón para sonreír.\nHoy es un buen día para ser feliz. \n"

    console.log("Cadena original (el mal formato es intencionado): \n'" + strOriginal + "'");

    // Eliminar espacios en los extremos
    console.log("String::trim()\n" + strOriginal.trim());
    console.log("-------------------------------------");

    // Separar por un separador
    console.log("String::split() (separamos por espacions) \n");
    const lista = strOriginal.split(" ");
    for (let index = 0; index < lista.length; ++index) {
        console.log("String at index " + (index) + ": '" + lista[index] + "'");
    }
    console.log("-------------------------------------");

    // Comprobar si una cadena empieza por otra
    console.log("String::startsWith() (trimmed)\n" + strOriginal.trim());
    console.log("String::startsWith('Siempre encuentra'): " + strOriginal.trim().startsWith("Siempre encuentra"))
    console.log("-------------------------------------");

    // Comprobar si una cadena termina por otra
    console.log("String::endsWith() (trimmed)\n" + strOriginal.trim());
    console.log("String::endsWith('ser felix'): " + strOriginal.trim().endsWith("ser felix"))

    console.log("-------------------------------------");
}

tests()