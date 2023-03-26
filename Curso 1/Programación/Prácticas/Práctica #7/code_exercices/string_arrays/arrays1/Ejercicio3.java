package string_arrays.arrays1;

/*
 * Título: Ejercicio 3
 * Algoritmo: Suma de los elementos de un array
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] array = new int[]{ 1, 4, 6, 10, -3, 4, 6, -5 };
        int suma = 0;
        
        // Método 1:
        for (int numero : array) {
            suma += numero;
        }
        System.out.println("La suma es: " + suma);

        // Método 2
        System.out.println("La suma es: " + Arrays.stream(array).sum());
    }
}