function greet(event) {
    alert("Hola Eventos");
}

var ev = document.getElementById("boton").addEventListener("mouseover", greet, false);