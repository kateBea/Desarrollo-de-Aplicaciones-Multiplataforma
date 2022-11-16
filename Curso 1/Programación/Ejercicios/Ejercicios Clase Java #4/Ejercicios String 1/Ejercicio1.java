/*
 * Título: Ejercicio 1
 * Algoritmo: Eliminar los espacios de una cadena de carcteres
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        String str = "Esta es una frase cualquiera";
        System.out.println("String: " + str);
        str = str.replace(" ", "");
        System.out.println("String: " + str);
    }
}