/* Ejemplo de cómo se declaran los vectores unidimensionales

 Sintaxis:
 tipo [] nombre_array;
 o
 tipos nombre_array[];

 Los arrays pueden declararse como atributos de una clase o locales en el interior de un método.
 Cuando se declara un array se inicializa con null

 nombre_array = new tipo [tamaño]

 Ejemplos:
 String [] nombres = new String[10]; de 0 a 9, tiene cadenas

 int [] otro_vector;
 otro_vector = new int [5]; vector de 0 a 4, con enteros

 int[] numeros = {10,20, 30, 40} declara e inicializa con valores

*/
import java.io.*;
import java.util.Arrays;

public class Ej_Arrays {
    public static void main(String[] argumentos) throws IOException {

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        // Ejemplos de declaración de arrays unidimensionales

        // 01
        int[] edades = new int[5]; // array de 5 enteros, inicializados a 0
        // existe int edades[] = new int[5]
        
        edades[0] = 45; //asignar en posición 0 el valor 45
        edades[1] = 67;
        edades[2] = 45;

        System.out.println("La primera edad es " + edades[0]);
        System.out.println ("Edad " + edades [1]);
        System.out.println ("Edad " + edades [2]);
        System.out.println ("Edad " + edades [3]);
        System.out.println ("Edad " + edades [4]);

        

    }
}