package coleccion4.arrays2;

/*
 * Título: Ejercicio 5
 * Algoritmo: Ordenación de un vector con cose O(nlogn)
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] array = new int[]{ 34, 12, 7, 2, 4, 1, 5 };
        // ordenación por MergeSort
        ordenar(array);
        System.out.println(Arrays.toString(array));
    }

    public static void ordenar(int[] array) {
        ordenar(array, 0, array.length - 1);
    }

    static void ordenar(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ordenar(array, left, mid);
            ordenar(array, mid + 1, right);
            ordenar(array, left, mid, right);
        }
    }

    static void ordenar(int[] array, int left, int mid, int right) {
        int newSize = (right - left) + 1;
        int idxSubvectorIzq = left;
        int idxSubvectorDer = mid + 1; 
        int idxArrayAuxiliar = 0;

        int[] arrayAuxiliar = new int[newSize];

        while (idxSubvectorIzq <= mid && idxSubvectorDer <= right) {
            if (array[idxSubvectorIzq] <= array[idxSubvectorDer])
                arrayAuxiliar[idxArrayAuxiliar++] = array[idxSubvectorIzq++];
            else 
                arrayAuxiliar[idxArrayAuxiliar++] = array[idxSubvectorDer++];
        }

        if (idxSubvectorIzq <= mid)
            System.arraycopy(array, idxSubvectorIzq, arrayAuxiliar, idxArrayAuxiliar, (mid - idxSubvectorIzq) + 1);
        if (idxSubvectorDer <= right)
            System.arraycopy(array, idxSubvectorDer, arrayAuxiliar, idxArrayAuxiliar, (right - idxSubvectorDer) + 1);

        System.arraycopy(arrayAuxiliar, 0, array, 0 + left, newSize);
    }
}