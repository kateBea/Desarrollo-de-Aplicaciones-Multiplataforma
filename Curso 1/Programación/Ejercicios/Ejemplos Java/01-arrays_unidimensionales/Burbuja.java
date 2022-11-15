/* Algoritmo de ordenamiento: Burbuja 
 * El ordenamiento por burbuja es el algoritmo más sencillo 
 * Consiste en ciclar repetidamente a través de la lista, comparando elementos adyacentes de dos en dos. 
 * Si un elemento es mayor que el que está en la siguiente posición se intercambian. 
 * Es un algoritmo estable. El inconveniente es que es muy lento.
 */
public class Burbuja {

    public static void main(String[] argumentos) {
        int temporal;
        int[] numeros = { 23, 45, 2, 56, 78, 54, 23, 45, 0, -2, -6, 9, 3, 0 };

        // ordenamos el vector
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    temporal = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temporal;
                }
            }
        }

        // mostramos vector ordenado
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

    }
}