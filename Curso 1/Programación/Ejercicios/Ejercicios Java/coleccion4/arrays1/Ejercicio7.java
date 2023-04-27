package coleccion4.arrays1;

/*
 * Título: Ejercicio 7
 * Algoritmo: Modificar un array intercalando ceros
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

 import java.util.Arrays;
  
public class Ejercicio7 {
    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 7, 8, 10, 11 };
        int[] arrayRes = new int[array.length * 2 - 1];
        int indice = 0;

        for (int num : array) {
            arrayRes[indice] = num;
            indice += 2;
        }

        System.out.println(Arrays.toString(arrayRes));
    }
}