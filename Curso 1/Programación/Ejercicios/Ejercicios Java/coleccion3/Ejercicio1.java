package coleccion3;

/* Título: Ejercicio 1
 * Algoritmo: Determina la paridad de un número
 * Fecha: 09.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero;

        System.out.print("Entra un número entero: ");
        numero = Integer.parseInt(reader.readLine());

        if (numero % 2 == 0)
            System.out.printf("El número %d es par\n", numero);
        else
            System.out.printf("El número %d es impar\n", numero); 
    }
}
