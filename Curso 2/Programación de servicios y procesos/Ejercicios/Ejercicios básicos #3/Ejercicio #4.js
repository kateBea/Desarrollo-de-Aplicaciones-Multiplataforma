function Rectangulo(ancho, alto) {
    this.ancho = ancho;
    this.alto = alto;

    this.area = () => { return this.ancho * this.alto; }
    this.perimetro = () => { return (2 * this.ancho) + (2 * this.alto); }
}

function tests() {
    const rect = new Rectangulo(4.2, 9.2);
    console.log("Area es: " + rect.area().toFixed(3) + " y perímetro es: " + rect.perimetro().toFixed(3));
}

tests();