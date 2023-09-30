const LETRAS_DNI = Array.from("TRWAGMYFPDXBNJZSQVHLCKE");

function esDNI(dni, letra) {
    if (letra.length != 1) {
        console.log("Es necesario una letra");
        return false;
    }

    // se asume que el DNI es correcto, por tanto, la letra es el último carácter
    let numeroDNI = parseInt(dni.substring(0, dni.length - 1));

    console.log("\nDNI: " + dni);
    console.log("Letra de parámetro: " + letra);
    console.log("Número de DNI parseado: " + numeroDNI);
    console.log("Letra de DNI que corresponde: " + LETRAS_DNI[(numeroDNI % 23)]);
    console.log("----------------------------------")

    return LETRAS_DNI[(numeroDNI % 23)] == letra; 
}

function run() {
    const letra = "U";
    const dniTest = "123427789Y";

    console.log("Corresponde letra " + letra + " a DNI? " + esDNI(dniTest, letra));
}



// Export elements
exports.LETRAS_DNI = LETRAS_DNI
exports.esDNI = esDNI