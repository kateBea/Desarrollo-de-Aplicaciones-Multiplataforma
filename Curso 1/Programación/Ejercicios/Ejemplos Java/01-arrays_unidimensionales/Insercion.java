/* Algoritmo de ordenamiento: Inserción 
 * Este algoritmo resuelve el problema de ordenar una secuencia de números de forma creciente.
 *  El ordenamiento por inserción funciona de la forma en que muchas personas ordenan una mano de
* juego de cartas. Comenzamos con una mano vacía, la izquierda y las cartas boca abajo en la mesa. 
* Luego quitamos una tarjeta de la mesa y la insertamos en la posición correcta en la mano izquierda. 
* Para encontrar la posición correcta para la tarjeta, comparamos con cada uno de los que ya están
*  en la mano de las tarjetas, de derecha a izquierda.
* Puedes consultar: http://puntocomnoesunlenguaje.blogspot.com/2015/02/ordenamiento-insercion-directa-java.html
 */
public class Insercion {

    public static void main(String[] argumentos) {

        int[] numeros = { 23, 45, 2, 56, 78, 54, 23, 45, 0, -2, -6, 9, 3, 0 };

        int p, j;
        int aux;

        // ordenamos el vector
        for (p = 1; p < numeros.length; p++) { // desde el segundo elemento hasta
            aux = numeros[p]; // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < numeros[j])) { // mientras queden posiciones y el
                // valor de aux sea menor que los
                numeros[j + 1] = numeros[j]; // de la izquierda, se desplaza a
                j--; // la derecha
            }
            numeros[j + 1] = aux; // colocamos aux en su sitio
        }

        // mostramos vector ordenado
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }

    }
}