package coleccion4.arrays2;

/*
 * Título: Ejercicio 2
 * Algoritmo: Dividir un array en dos partes
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] array = new int[]{ 3, 2, 4, 4, 5, 6, 7, 9 };
        int[] subArray1 = new int[4];
        int[] subArray2 = new int[4];

        for (int index = 0; index < array.length / 2; ++index) {
            subArray1[index] = array[index];
            subArray2[index] = array[(array.length / 2) + index];
        }

        System.out.println("Array original:      " + Arrays.toString(array));
        System.out.println("SubArray izquierdo:  " + Arrays.toString(subArray1));
        System.out.println("Subarray derecho:    " + Arrays.toString(subArray2));
    }
}