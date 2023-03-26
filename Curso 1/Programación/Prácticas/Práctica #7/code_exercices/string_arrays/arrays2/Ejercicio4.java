package string_arrays.arrays2;

/*
 * Título: Ejercicio 4
 * Algoritmo: Operaciones con arrays
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {
        int[] array = new int[]{ 7, 5, 6, 14, 2, 4, 89, 9, 55 };
        int[] subArray1 = new int[4];
        int[] subArray2 = new int[4];

        for (int index = 0; index < array.length / 2; ++index) {
            subArray1[index] = array[index];
            subArray2[index] = array[(array.length / 2 + 1 ) + index];
        }

        System.out.println("Array original:      " + Arrays.toString(array));
        System.out.println("SubArray izquierdo:  " + Arrays.toString(subArray1));
        System.out.println("Subarray derecho:    " + Arrays.toString(subArray2));
        System.out.println("Elemento intermedio: [" + array[array.length / 2] + "]");

        for (int index = 0; index < array.length / 2; ++index) {
            subArray1[index] *= array[array.length / 2];
            subArray2[index] *= array[array.length / 2];
        }
        
        System.out.println("\n******* Aplicados los cambios *******");
        System.out.println("Array original:      " + Arrays.toString(array));
        System.out.println("SubArray izquierdo:  " + Arrays.toString(subArray1));
        System.out.println("Subarray derecho:    " + Arrays.toString(subArray2));
    }
}