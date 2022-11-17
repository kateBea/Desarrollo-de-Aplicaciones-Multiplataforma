/*
 * Título: Ejercicio 3
 * Algoritmo: En la frase "A ver cuantos asteriscos salen de aquí", cambiar todas las
 * posiciones múltiplos de 5 por asteriscos
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        String outStr = new String("");
        char[] str = "A ver cuantos asteriscos salen de aquí".toCharArray();

        for (int charIndex = 0; charIndex < str.length; ++charIndex) {
            if (charIndex % 5 == 0)
                outStr = outStr + "*";
            else 
                outStr = outStr + str[charIndex]; 
        }

        System.out.println("Nueva cadena: " + outStr);
    }
}