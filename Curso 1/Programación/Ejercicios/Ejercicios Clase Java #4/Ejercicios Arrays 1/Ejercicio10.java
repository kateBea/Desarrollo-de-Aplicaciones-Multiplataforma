/*
 * Título: Ejercicio 10
 * Algoritmo: Convertir array a string
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.util.Arrays;

public class Ejercicio10 {
    public static void main(String[] args) {
        char[] array = new char[]{ 'P', 'a', 'l', 'a', 'b', 'r', 'a' };
        System.out.println(Arrays.toString(array));

        // método 2. Constructora de la clase String que recibe 
        // un array como parámetro
        System.out.println(new String(array));
    }
}