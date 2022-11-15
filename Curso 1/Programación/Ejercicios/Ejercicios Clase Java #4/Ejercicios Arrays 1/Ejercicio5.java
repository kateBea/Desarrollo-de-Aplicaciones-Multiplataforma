/*
 * Título: Ejercicio 5
 * Algoritmo: Extraer los elementos mayores y menores que 6 de un array
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 7, 8, 10, 11 };
        int[] mayores = new int[array.length];
        int[] menores = new int[array.length];
        final int treshold = 6;

        int indiceMayores = 0;
        int indceMenores = 0;

        for (int it : array) {
            if (it > treshold)
                mayores[indiceMayores++] = it;
            else if (it < treshold)
                menores[indceMenores++] = it; 
        }

        System.out.print("Valores mayores que " + treshold + ": ");
        printArray(mayores);
        System.out.print("Valores menores que " + treshold + ": ");
        printArray(menores);
    }

    public static void printArray(int[] array) {
        for (int it : array) {
            if (it != 0)
                System.out.print(it + " ");
        }
        System.out.println();
    }
}