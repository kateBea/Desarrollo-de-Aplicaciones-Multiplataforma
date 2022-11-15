/* Este fichero usa distintos métodos de la 
 * clase String
 * 
 */

public class Uso_Metodos {
    public static void main(String[] arg) {

        // método String.length() devuelve num caracteres
        String text1 = "Esto es una cadena";
        System.out.println("La longitud de la cadena es " + text1.length());

        System.out.println("**********");

        // método concatenar cadenas String.concat(objeto_string)
        String text2 = "Y esto es otra cadena";
        String text3 = text1.concat(text2);
        System.out.println(text3);

        System.out.println("**********");

        // método convertir mayúsculas String.toUpperCase()
        System.out.println(text3.toUpperCase());
        System.out.println("**********");

        // método convertir minusculas String.toLowerCase()
        System.out.println(text3.toLowerCase());
        System.out.println("**********");

        // también se podría usar el operador +

        // método String.charAt(numero_posicion), devuelve el carácter de posición
        char caracter = text1.charAt(0);
        System.out.println(caracter);
        caracter = text1.charAt(6);
        System.out.println(caracter);
        caracter = text1.charAt(text1.length() - 1);
        System.out.println(caracter);

        System.out.println("**********");

        // método String.substring(posicion_inicial, posición_final)
        // devuelve la porción desde posición_inicial hasta posición_final-1

        String saludo = "Hola a todos";
        String subcadena_saludo = saludo.substring(0, 7);
        System.out.println(subcadena_saludo);

        System.out.println("**********");

        // método String.indexOf(caracter) o String.indexOf(cadena)
        // devuelve la primera posición en la que aparece el caracter o cadena
        // si no encuentra devuelve -1

        String mensaje = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme...";
        System.out.println(mensaje.indexOf("Mancha"));
        System.out.println(mensaje.indexOf("lugar"));
        System.out.println(mensaje.indexOf("Pepe"));

        System.out.println("**********");

        // método String.lastIndexOf(cadena) devuelve la última posición
        // igual que anterior pero busca por el final
        String mensaje2 = "Ya queda menos para el viernes...";
        System.out.println(mensaje2.lastIndexOf("viernes"));
        System.out.println(mensaje2.lastIndexOf("Viernes")); // ojo con may y min
        System.out.println(mensaje2.lastIndexOf("Pepe"));

        System.out.println("**********");

        // método String.endsWith(subcadena) devuelve true si la cadena termina con la
        // subcadena que le envia
        System.out.println(mensaje2.endsWith("..."));

        System.out.println("**********");

        // método String.startsWith(subcadena) devuelve true si la cadena comienza con
        // la subcadena
        System.out.println(mensaje2.startsWith("Ya"));

        System.out.println("**********");

        // método String.replace(caracter_a_cambiar, nuevo_caracter) reemplaza
        // caracteres
        text1 = "Hola a todos";
        System.out.println(text1.replace("o", "*")); // cambia las 'o' por *

        // método String.replaceAll (cadena_cambiar, nuevo_valor)
        text1 = "En la casa de la mujer de al lado la ventana está rota";
        System.out.println(text1.replace("la", "*-*"));

        // método String.toCharArray() crea un array de char a partir de la cadena
        char[] text1_caracteres = text1.toCharArray();
        System.out.println("caracter es " + text1_caracteres[0]);

    }
}
