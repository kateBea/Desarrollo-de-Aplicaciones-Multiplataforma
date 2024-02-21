package examen.hugopelayo.gui.adivinarpantallas

sealed class RutasAdivinar(var ruta: String) {

    object PantallaPrincipal : RutasAdivinar("pantalla_principal")
    object PantallaJuego : RutasAdivinar("pantalla_juego")

}