package examen.hugopelayo.gui.recetapantallas


sealed class RutasReceta (var ruta: String) {
    object PantallaPrincipal : RutasReceta("pantalla_principal")
    object PantallaReceta : RutasReceta("pantalla_receta")
}