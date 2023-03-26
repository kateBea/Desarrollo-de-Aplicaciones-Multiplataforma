package string_arrays.string1;

/*
 * Título: Ejercicio 1
 * Algoritmo: Separar un String en dos, uno con palabras impares y
 * otro con palabras pares
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */


public class Ejercicio6 {
    public static void main(String[] args) {
        String str = new String("Esta es una frase completa de principio a fin");
        String pares = new String("");
        String impares = new String("");
        int indice = 0;

        for (String subStr : str.split(" ")) {
            if (indice % 2 == 0)
                pares = pares + subStr + " ";
            else 
                impares = impares + subStr + " ";

            ++indice;
        }

        pares = pares.trim();
        impares = impares.trim();
        
        System.out.println("Cadena original:   " + str);
        System.out.println("Cadena de pares:   " + pares);
        System.out.println("Cadena de impares: " + impares);
    }    
}
