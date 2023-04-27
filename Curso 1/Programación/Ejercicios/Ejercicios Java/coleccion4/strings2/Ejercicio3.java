package coleccion4.strings2;

/*
 * Título: Ejercicio 3
 * Algoritmo: Rotar las palabras en índices impares de un String
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */


public class Ejercicio3 {
    public static void main(String[] args) {
        String original = new String("Esta es una frase completa de principio a fin");
        String other = new String("");
        int indice = 0; 

        for (String subStr : original.split(" ")) {
            if (indice % 2 == 1)
                other = other + reverseString(subStr) + " ";
            else 
                other = other + subStr + " ";
            ++indice;
        }

        other.trim();
        System.out.println("Cadena original:   " + original);
        System.out.println("Cadena modificada: " + other);
    } 
    
    public static String reverseString(String str) {
        String returnStr = new String("");
        for (int i = 0; i < str.length(); ++i)
            returnStr = returnStr + str.charAt(str.length() - 1 - i);

        return returnStr;
    }
}
