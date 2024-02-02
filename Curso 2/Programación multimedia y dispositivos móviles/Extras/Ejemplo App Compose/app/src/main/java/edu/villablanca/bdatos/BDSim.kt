package edu.villablanca.bdatos


/*

 */
class BDSim {

    val mapa = mutableMapOf(
        "Ana" to Usuario("Ana", 30, "ana@example.com"),
        "Carlos" to Usuario("Carlos", 25, "carlos@example.com")
    )

    fun open(){

    }
    fun close(){

    }
    fun create(user: Usuario){
        mapa.put(user.nombre, user)
    }
    fun read(nombre: String): Usuario? {
        return mapa.get(nombre)
    }
    fun update(nombre: String, userModificado: Usuario){
        mapa[nombre] = userModificado
    }
    fun delete(nombre: String): Usuario?{
        return mapa.remove(nombre)
    }


    override fun toString(): String {
        return "Registros = $mapa)"
    }


}