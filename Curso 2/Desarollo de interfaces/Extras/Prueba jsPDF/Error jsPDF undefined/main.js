function crearPDF() {
    const doc = new jsPDF();

    let img = new Image();
    img.src = "./img2.png";

    doc.addImage(img, "PNG", 10, 10, 100, 100);
    doc.text(10, 25, "Segundo de DAM");

    doc.save("Doraemon.pdf");
}