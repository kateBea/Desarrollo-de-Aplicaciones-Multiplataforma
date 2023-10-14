async function saludar() { 
    return "Hola mundo" 
} 

saludar().then((saludo) => { 
    let cadena = "***";    
    saludar().then((saludo) => { 
        console.log(cadena + saludo) 
    }) 
});

// JS extiende el ámbito de visibilidad de "cadena" a la función donde se va a usar
// pero no expone la visibilidad de la variable a ámbitos superiores, entonces
// no la podemos usar fuera de los corchetes entro los cuales se declara.