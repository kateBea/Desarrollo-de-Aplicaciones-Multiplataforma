/*
 * Título: Ejercicio 5
 * Algoritmo: Con la cadena “Esta es una cadena cualquiera” mostrarla tal cual está y en el
 * renglón siguiente del revés
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        String str = new String("Esta es una cadena cualquiera");
        System.out.println("Cadena original:  " + str);
        System.out.print("Cadena invertida: ");
        for (int i = 0; i < str.length(); ++i)
            System.out.print(str.charAt(str.length() - 1 - i));
        
        System.out.println();
    }
}
