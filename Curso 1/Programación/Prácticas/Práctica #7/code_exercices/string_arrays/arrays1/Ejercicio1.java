package string_arrays.arrays1;

/*
 * Título: Ejercicio 1
 * Algoritmo: Suma de dos arrays
 * Fecha: 26.03.2023
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] array1 = new int[]{ 1, 3, 5, 7, 8 };
        int[] array2 = new int[]{ 1, 2, 3, 4, 5 };

        // asumiendo que array1 y array2 tienen el mismo tamaño
        int[] arrayRes = new int[array1.length];

        int indiceArray1 = 0;
        int indiceArray2 = 0;
        int indiceArrayRes = 0;

        while (indiceArray1 < array1.length && indiceArray2 < array2.length) {
            arrayRes[indiceArrayRes++] = (array1[indiceArray1++] + array2[indiceArray2++]);
        }
        
        System.out.println(Arrays.toString(arrayRes));
    }

    public static boolean esImpar(int numero) {
        return numero % 2 == 1;
    }
}