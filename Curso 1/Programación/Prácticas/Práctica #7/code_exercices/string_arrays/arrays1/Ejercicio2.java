package string_arrays.arrays1;

/*
* Título: Ejercicio 2
* Algoritmo: Suma de los elementos en las posiciones impares de dos array
* Fecha: 15.11.2022
* Autor: Hugo Pelayo
*/

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] array1 = new int[]{ 1, 3, 5, 7, 8 };
        int[] array2 = new int[]{ 1, 2, 3, 4, 5 };

        // asumiendo que array1 y array2 tienen el mismo tamaño
        int tamanioArrayRes = esImpar(array1.length) ? (array1.length / 2) : (array1.length / 2) + 1;
        int[] arrayRes = new int[tamanioArrayRes];

        int indiceArray1 = 1;
        int indiceArray2 = 1;
        int indiceArrayRes = 0;

        while (indiceArray1 < array1.length && indiceArray2 < array2.length) {
            arrayRes[indiceArrayRes++] = (array1[indiceArray1] + (int)array2[indiceArray2]);
            indiceArray1 += 2;
            indiceArray2 += 2;
        }
        
        System.out.println(Arrays.toString(arrayRes));
    }

    public static boolean esImpar(int numero) {
        return numero % 2 == 1;
    }
}