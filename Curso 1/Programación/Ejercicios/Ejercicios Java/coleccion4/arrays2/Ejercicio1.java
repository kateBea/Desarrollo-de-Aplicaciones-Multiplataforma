package coleccion4.arrays2;

/*
 * Título: Ejercicio 1
 * Algoritmo: Guardar los tamaños de las cadenas de un array
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        String[] cadenas = new String[]{ "coche", "casa", "avión", "tren" };
        int[] tamanios = new int[cadenas.length];
        int indice = 0;

        for (String str : cadenas) {
            tamanios[indice++] = str.length();
        }

        System.out.println("Tamaños de las cadenas: " + Arrays.toString(tamanios));
    }
}