/* Ejemplo uso instrucción for-each --> En Java se usa palabra reservada for

 * Facilita el recorrido de arrays y colecciones (éstas se verán mas adelante)
 
 * No será necesario declarar la variable que se utiliza de índice
 * para acceder a las posiciones.
 * 
 * Sintaxis: 
 * for (tipo variable:var_Array){
 *     //instrucciones
 * }
 */

public class Recorrer_Array_version2 {
    public static void main(String[] argumentos) {
        int[] numeros = { 1, 2, 45, 2, 67, 3, 13, 56 };

        // versión for
        System.out.println("Mostrar numeros con for");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

        // versión for-each
        System.out.println("\nMostrar numeros con for-each");
        for (int n : numeros) {
            System.out.print(n + " ");
        }
    }
}
