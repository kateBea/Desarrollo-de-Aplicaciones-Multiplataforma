function centimetrosAPulgadas(valor) {
    // Cantidad de centímetros por pulgada
    const FACTOR_CONVERSION_CENT_A_PULG = 2.54;

    return valor / FACTOR_CONVERSION_CENT_A_PULG; 
}

const cent = 45.22;
console.log(cent + ' son ' + centimetrosAPulgadas(cent).toFixed(3) + ' pulgadas.')