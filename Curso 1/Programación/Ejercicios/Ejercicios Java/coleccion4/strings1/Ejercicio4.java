package coleccion4.strings1;

/*
 * Título: Ejercicio 4
 * Algoritmo: En la frase “Vamos a ver qué es lo que sale de este cambio de letras”, cambiar
 * las TRES primeras a's por i's
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        String str = new String("Vamos a ver qué es lo que sale de este cambio de letras");
        final int numeroReemplazos = 3;
        
        System.out.println("Cadena original: " + str);
        for (int i = 0; i < numeroReemplazos; ++i) 
            str = str.replaceFirst("a", "i");

        System.out.println("Cadena modificada: " + str);
    }
}