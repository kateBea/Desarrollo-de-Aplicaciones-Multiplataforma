/*
 * Título: Ejercicio 2
 * Algoritmo: Reemplaza posiciones pares de un String por mayúsculas
 * Autor: Hugo Pelayo
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        String str = new String("Esta es una frase completa de principio a fin");
        String other = new String("");

        System.out.println("Cadena original: " + str);
        System.out.print("Cadena modificada: ");
        for (int index = 0; index < str.length(); ++index) 
            if (index % 2 == 0)
                other = other + Character.toUpperCase(str.charAt(index));
            else
                other = other + str.charAt(index);
        
            System.out.println(other);
    }    
}
