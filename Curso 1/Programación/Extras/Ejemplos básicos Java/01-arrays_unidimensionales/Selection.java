/* Algoritmo de ordenamiento: Selección 
 * De igual modo que con el método de la burbuja, 
 * el algoritmo de selección dividirá el arreglo en 2 particiones, 
 * una ordenada y una desordenada, durante la ejecución la partición
 *  ordenada irá creciendo y la desordenada irá disminuyendo.
 */
public class Selection {

    public static void main(String[] argumentos) {

        int[] numeros = { 23, 45, 2, 56, 78, 54, 23, 45, 0, -2, -6, 9, 3, 0 };
        int temporal;

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    // ...intercambiarlos, es decir, mover el actual a la derecha y el de la derecha
                    // al actual
                    temporal = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temporal;
                }
            }
        }

        // mostramos vector ordenado
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

    }
}