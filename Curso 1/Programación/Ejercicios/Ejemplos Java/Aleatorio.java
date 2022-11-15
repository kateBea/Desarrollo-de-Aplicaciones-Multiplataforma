/* Ejemplo de cómo generar un número aleatorio utilizando la clase Random de Java
 * 
 * Para generar un número aleatorio, Java proporciona una clase Math 
 * disponible en el paquete java.util. Esta clase contiene un método 
 * estático Math.random() para generar números aleatorios de tipo double.
 * 
 * En este fichero se muestran ejemplos de cómo utilizar Random
 */

import java.util.*;

public class Aleatorio {
    public static void main(String[] arg) {
        // ejemplo
        Random rd = new Random(); // creamos un objeto de la clase Random para poder usar sus métodos
        int aleatorio = rd.nextInt(); // hasta 2 elevado a 32
        System.out.println("Aleatorio " + aleatorio);
        aleatorio = rd.nextInt(100); // aleatorio de 0 a 99
        System.out.println("Aleatorio " + aleatorio);

        // Ejemplo
        double num_aleatorio;
        num_aleatorio = Math.random();
        System.out.println("El aleatorio es " + num_aleatorio);

        // ejemplo

        // Ejemplo numero alaetaroio de 0 a 10
        num_aleatorio = Math.random() * 10;
        System.out.println("El aleatorio es " + num_aleatorio);

        // Ejemplo numero aleatorio entre un rango min y max
        int min = 5;
        int max = 10;
        num_aleatorio = Math.floor(Math.random() * (max - min + 1)) + min;
        System.out.println("El aleatorio es " + num_aleatorio);

    }
}
