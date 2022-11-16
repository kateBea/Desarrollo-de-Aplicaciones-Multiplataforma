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

        for (int index = 0; index < borrasca.length(); ++index) {
            letras[index] = borrasca.charAt(index);
        }

        System.out.println("Letras: " + Arrays.toString(letras));
    }
}