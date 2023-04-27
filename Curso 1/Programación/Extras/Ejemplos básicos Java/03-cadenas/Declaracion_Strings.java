import java.util.Date;

/*
 * Disponemos de la Clase String para guardar cadenas de caracteres
 * En este fichero se muestran ejempos de cómo declarar cadenas
 * 
 */
public class Declaracion_Strings {
    public static void main(String[] args) {

        String text1 = "Esto es un ejemplo";
        String text2 = "Ejemplo de texto que ocupa " +
                "varias líneas";
        System.out.println(text1);
        System.out.println(text2);

        // otra forma es utilizar un array de caracteres
        char[] nombre = { 'J', 'U', 'A', 'N' }; // ojo porque no es lo mismo que un String
        // para crear un string a partir del array anterior
        String nombre_cadena = new String(nombre);
        System.out.println(nombre_cadena);
        System.out.println(nombre);

        // La clase String tiene el método valueOf (como otras clases que también lo
        // tienen)
        // permite convertir valores no cadena a forma cadena
        String numero_cadena = String.valueOf(1234);
        System.out.println(numero_cadena);

    }
}