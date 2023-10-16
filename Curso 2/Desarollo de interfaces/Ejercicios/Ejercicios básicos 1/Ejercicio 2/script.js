/**
 * Se llama cuando se hace clic sobre botón cambiar imagen
 * */
function changeBg() {
    // Read prompt
    const userChosenImg = prompt('Nombre de imagen');

    // Relative image path
    const imagePath = userChosenImg + '.png';

    let imgItem = document.getElementById("img-bg")
    imgItem.setAttribute("src", imagePath)
}