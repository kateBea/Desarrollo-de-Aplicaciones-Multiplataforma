function changeBg() {
    // leer de prompt
    const userChosenImg = prompt('Nombre de imagen');

    // Crear strings
    const button = '<div><input type="button" value="Cambiar imagen" onclick="changeBg()"></div>';
    const imgPart1 = '<div><img src="';
    const imgPart2 = '.png"></div>';

    document.write(imgPart1 + userChosenImg + imgPart2 + button);
    document.close();
}