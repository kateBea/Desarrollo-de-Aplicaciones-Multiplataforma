function operadores() {
    let a = 12;
    let b = 2;

    c = a + b++;
    document.write("Postincremento. c = ", c);

    c = a + ++b;
    document.write("Preincremento. c = ", c);
}

operadores()