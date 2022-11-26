/*
 * Título: Ejercicio 2
 * Algoritmo: Escribir un programa que genere 50 números enteros aleatorios entre 
 * el 97 y el 122 que representarán las letras del alfabeto (exceptuando la ñ), 
 * los almacene en un array de caracteres, y cuente cuantas vocales se han generado. 
 * Nota: para pasar del código entero a carácter se utiliza: char  c = (char) numero;
 * Autor: Hugo Pelayo
 * Fecha: 22.11.2022
 */

import java.util.Random;
import java.util.Arrays;

public class Ejercicio2 {
    private static final Random rand = new Random();
    private static final int LIMITE_SUPERIOR = 122;
    private static final int LIMITE_INFERIOR = 97;
    
    public static void generarAleatorios(char[] arr) {
        for (int index = 0; index < arr.length; ++index) {
            arr[index] = (char)rand.nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR);
        }
    }

    public static int cuentaVocales(char[] arr) {
        int contador = 0;
        for (char ch : arr) {
            if (isVowel(ch)) 
                ++contador;
        }

        return contador;
    }

    public static boolean isVowel(char ch) {
        switch(ch) {
            case 'a':
            case 'i':
            case 'u':
            case 'e':
            case 'o':
            case 'A':
            case 'I':
            case 'E':
            case 'U':
            case 'O': return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        final int TOTAL_VALORES = 50;
        char[] letras = new char[TOTAL_VALORES];
        generarAleatorios(letras);
        System.out.println("Se han generado " + cuentaVocales(letras) + " vocales.");
        System.out.println("Letras: " + Arrays.toString(letras));
    }
}