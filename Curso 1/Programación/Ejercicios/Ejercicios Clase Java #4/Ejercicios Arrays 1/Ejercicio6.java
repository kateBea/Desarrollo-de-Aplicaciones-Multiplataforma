/*
 * Título: Ejercicio 6
 * Algoritmo: Extraer elementos pares e impares de un array
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio6 {
    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 7, 8, 10, 11 };
        int[] pares = new int[array.length];
        int[] impares = new int[array.length];

        int indicePares = 0;
        int indceImpares = 0;

        for (int it : array) {
            if (it % 2 == 1)
                pares[indicePares++] = it;
            else 
                impares[indceImpares++] = it; 
        }

        System.out.print("Valores pares: ");
        printArray(pares);
        System.out.print("Valores impares: ");
        printArray(impares);
    }

    public static void printArray(int[] array) {
        for (int it : array) {
            if (it != 0)
                System.out.print(it + " ");
        }
        System.out.println();
    }
}