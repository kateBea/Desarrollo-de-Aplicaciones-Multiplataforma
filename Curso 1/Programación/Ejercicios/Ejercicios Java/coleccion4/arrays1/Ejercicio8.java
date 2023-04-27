package coleccion4.arrays1;

/*
 * Título: Ejercicio 8
 * Algoritmo: Obtener un array a partir de otro donde cada posición se multiplica por ptencias de 10
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio8 {
    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 7, 8 };
        int[] arrayRes = new int[array.length];
        int indice = 0;

        for (int num : array) {
            arrayRes[indice++] = num * (int)Math.pow(10, indice);
        }

        System.out.println(Arrays.toString(arrayRes));
    }
}