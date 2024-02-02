package edu.villablanca.catalogo.navegacion

/**
 * rutas para la navegación
 */
sealed class Destino(open val ruta: String){
    object PLista: Destino("/PantallaComponentes")
    object PPrincipal: Destino("/PantallaPrincipal")

    object PCodigoFuente: Destino("/PCodigoFuente"){
        var id="id"
    }
    object PText: Destino("/DemoText"){
      var id="DemoText"

    }
    object PButton: Destino("/DemoButton")


    // Estas dos funciones crear un
    fun getRutaPlana(vararg args: String): String {
        return buildString {
            append(ruta)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    fun getRutaNav(vararg args: String): String {
        return buildString {
            append(ruta)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}