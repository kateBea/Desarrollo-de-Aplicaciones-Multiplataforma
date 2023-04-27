package coleccion4.arrays2;

/*
 * Título: Ejercicio 3
 * Algoritmo: Imprimir lista de letras de una cadena
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;
public class Ejercicio3 {
    public static void main(String[] args) {
        String borrasca = "Filomena";
        char[] letras = new char[borrasca.length()];

        // Método 1
        for (int index = 0; index < borrasca.length(); ++index) {
            letras[index] = borrasca.charAt(index);
        }

        System.out.println("Letras: " + Arrays.toString(letras));

        // Método 2
        @SuppressWarnings("unused")
        char[] letras2 = borrasca.toCharArray();
        System.out.println("Letras: " + Arrays.toString(letras));
    }
}