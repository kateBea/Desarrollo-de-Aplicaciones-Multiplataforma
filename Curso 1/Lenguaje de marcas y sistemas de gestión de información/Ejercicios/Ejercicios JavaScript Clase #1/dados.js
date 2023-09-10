function init(){
    saldo = 50;
    salida_saldo = document.getElementById("s_saldo");
    salida_saldo.innerHTML= saldo;
  
}
function comprobarDado(){
    let n_jugado = parseInt(document.getElementById("e_jugado").value);
    if (n_jugado > 6 || n_jugado <1){
        alert("Solo permitido entre 0 y 6");
        document.getElementById("e_jugado").value ="";
    }
}
function dados() {
    let apuesta = parseInt(document.getElementById("e_apuesta").value);
    let n_jugado = parseInt(document.getElementById("e_jugado").value);

    // comprobar no apuesta más del saldo
    if (saldo - apuesta <0){
        alert("No tienes saldo suficiente")
        document.getElementById("e_apuesta").value = saldo;
        salida_saldo.innerHTML = saldo;
        document.getElementById("e_jugado").value
        return; 
    }

    let dado_jugado = Math.floor( Math.random() * 5) +1;

    if (dado_jugado == n_jugado){
        //gana
        saldo += apuesta;
        salida_saldo.innerHTML = saldo;

        if( saldo >= 200){
            alert("Has ganado..Tienes más de 200 €, fin de juego ")
        } else
            alert("Has ganado....");

    }else {
        //pierde
        saldo -= apuesta;
        var str ="HAS PERDIDO. salió el = " + dado_jugado;
        if (saldo <=0){
        
            alert( str +".  FIN DEL JUEGO. NO TINES SALDO");
            document.getElementById("elBoton").disabled = true;
        } else
            alert( str);
    }

    salida_saldo.innerHTML = saldo;

}