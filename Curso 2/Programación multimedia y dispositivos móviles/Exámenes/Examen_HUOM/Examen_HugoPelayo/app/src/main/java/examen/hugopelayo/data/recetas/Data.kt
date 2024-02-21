package examen.hugopelayo.data.recetas

import androidx.compose.ui.graphics.painter.Painter
import examen.hugopelayo.R

data class Receta(
    val titulo : String,
    val ingredientes: String,
    val pasos : String,
    val duracion : Int= 0, // minutos preparacion
    val imagen: Int
)

val listaRecetas = listOf(
    Receta(
        titulo= "Hamburguesa",
        ingredientes= "Pan lechuga tomate",
        pasos= """Agregamos la carne picada y, con las manos bien
                limpias, mezclamos hasta incorporar bien. Dividimos la mezcla de
                nuestras hamburguesas en seis partes iguales. Tomamos cada una de
                ellas, la boleamos y la aplastamos entre las palmas de las manos.
                Podemos usar un aro de emplatar o algún artilugio para formar
                hamburguesas, pero no es necesario.
                Pincelamos una sartén amplia o una plancha con
                aceite de oliva y la calentamos a fuego fuerte. Colocamos sobre
                ella las hamburguesas y las marcamos, sin tocar ni aplastar,
                durante dos o tres minutos, bajando el fuego a media cocción.
                Volteamos, cubrimos cada hamburguesa con dos lonchas de queso,
                tapamos y dejamos cocer por la otra cara durante otros dos o tres
                minutos minutos. El tiempo dependerá del punto que queramos darle
                a la carne. Servimos inmediatamente.""",
        duracion =30,
        imagen = R.drawable.burger
    ),

    Receta(
        titulo="Pasta",
        ingredientes = "Spagueti Pimienta negra molida Quese, Pecorino, Yemas de huevo",
        pasos="""Por otro lado bate las 3 yemas de huevo con el
        huevo y el queso pecorino recién rallado hasta hacer una mezcla
        algo espesa. Dale unos toques de pimienta negra a esa mezcla.
        Entre tanto, pon la pasta a cocer en agua abundante con sal, y
        sácala cuando falten un par de minutos para que esté al dente.
        En la sartén donde habíamos reservado la panceta
        o el guanciale salteado, agregaremos la pasta escurrida a la que
        añadimos la mezcla de huevos, queso y pimienta, mezclando bien.
        Agregamos también un cucharón del agua de cocción de la pasta.""",
        duracion = 45,
        imagen= R.drawable.pasta,
    )
)