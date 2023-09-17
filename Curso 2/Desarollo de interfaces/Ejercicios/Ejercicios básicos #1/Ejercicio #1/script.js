var index = 0;

function changeBg() {
    const pathImg = prompt('Introduce el nombre de la imagen (debe estar en directorio de este fichero html)')
    document.write('<div><img src=' + '"' + pathImg + '"' + '></div>' +
        '<div><input type="button" value="Cambiar imagen" onclick="changeBg()"></div>')
    document.close()
}