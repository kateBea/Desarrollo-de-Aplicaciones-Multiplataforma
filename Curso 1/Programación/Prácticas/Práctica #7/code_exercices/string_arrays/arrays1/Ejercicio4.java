package string_arrays.arrays1;

/*
 * Título: Ejercicio 4
 * Algoritmo: Imprimir los elementos de un array indicando si son pares o impares
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

 public class Ejercicio4 {
    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 7, 8, 10, 11 };

        for (int it : array) {
            System.out.println("[" + it + "] es " + (it % 2 == 0 ? "par." : "impar."));
        }
    }
 }