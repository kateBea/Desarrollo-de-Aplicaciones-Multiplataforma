package coleccion4.strings1;

/*
 * Título: Ejercicio 2
 * Algoritmo: Seleccionar las letras de una frase de 5 en 5 y mostrarlas
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        String str = "Esta es una frase cualquiera";

        for (int charIndex = 0; charIndex < str.length(); charIndex += 5) {
            System.out.println("Character at index #" + (charIndex) + ": " + str.charAt(charIndex));
        }
    }
}