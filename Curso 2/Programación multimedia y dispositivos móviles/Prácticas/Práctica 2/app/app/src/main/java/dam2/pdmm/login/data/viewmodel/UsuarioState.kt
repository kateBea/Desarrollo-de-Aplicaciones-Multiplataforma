package dam2.pdmm.login.data.viewmodel

import dam2.pdmm.login.data.modelo.Usuario
import dam2.pdmm.login.utilidades.IngredientePrecioCantidad

/**
 * Clase de estado que representa el estado actual del usuario en la aplicación de pedidos de pizza.
 *
 * Esta clase almacena información como el usuario actual, el tipo de masa seleccionado, los ingredientes
 * elegidos y su cantidad, así como el precio de la masa.
 *
 * @param usuarioActual El usuario actual que ha iniciado sesión en la aplicación.
 * @param tipoMasa El tipo de masa seleccionado para la pizza.
 * @param precioMasa El precio base de la masa de la pizza.
 * @param ingredientesElegidos La lista de ingredientes seleccionados para la pizza, junto con su precio y cantidad.
 * */
data class UsuarioState(
    var usuarioActual: Usuario? = null,
    var tipoMasa: String? = null,
    val precioMasa: Float = 5.0f, // Por ahora todas las masas tienen el mismo precio
    var ingredientesElegidos: MutableList<IngredientePrecioCantidad> = mutableListOf()
) {
    /**
     * Agrega un ingrediente a la lista de ingredientes elegidos si no existe ya en la lista.
     *
     * @param item El ingrediente con su precio y cantidad que se va a agregar.
     * */
    fun setIngredientesElegido(item: IngredientePrecioCantidad) {
        if (ingredientesElegidos.find { ing -> ing.nombreIngrediente.equals(item.nombreIngrediente) } == null) {
            ingredientesElegidos.add(item)
        }
    }

    /**
     * Elimina un ingrediente de la lista de ingredientes elegidos según su nombre.
     *
     * @param nombre El nombre del ingrediente que se va a eliminar de la lista.
     * */
    fun removeIngredienteElegido(nombre: String) {
        ingredientesElegidos.removeIf { ingrediente -> ingrediente.nombreIngrediente.equals(nombre) }
    }
}