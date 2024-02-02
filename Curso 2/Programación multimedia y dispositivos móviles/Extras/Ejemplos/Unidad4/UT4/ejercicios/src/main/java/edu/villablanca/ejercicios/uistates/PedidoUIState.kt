package edu.villablanca.ejercicios.uistates

import edu.villablanca.ejercicios.data.PizaDatos.ingredientes

data class PedidoUIState(
    val cliente: String="",
    val telefono: String="",
    val num_ingredientes: Int =0,
    val ingredientes: MutableSet<String> = mutableSetOf(""),
    val masa: String ="",
    val precio: String=""
) {
    /**
     * Comprueba si está en la lista de ingredientes
     */
    fun estaSeleccionado(ingrediente: String): Boolean {
        return ingredientes.contains(ingrediente)
    }
}
