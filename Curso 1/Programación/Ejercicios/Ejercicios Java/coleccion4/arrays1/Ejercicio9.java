package coleccion4.arrays1;

/*
 * Título: Ejercicio 9
 * Algoritmo: Operaciones básicas con elementos de arrays
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;
 
public class Ejercicio9 {
    public static void main(String[] args) {
        int[] array1 = new int[]{ 1, 3, 5, 7, 9 };
        int[] array2 = new int[]{ 6, 4, 2, 1, 3 };
        float[] arrayRes = new float[Math.max(array1.length, array2.length)];

        int indiceArray1 = 0;
        int indiceArray2 = 0;
        int indiceArrayRes = 0;

        while (indiceArray1 < array1.length && indiceArray2 < array2.length) 
            arrayRes[indiceArrayRes++] = ((float)array1[indiceArray1++] * (float)array2[indiceArray2++] / 10.0f);
        
        System.out.println(Arrays.toString(arrayRes));
    }
}