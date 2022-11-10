/* Título: Ejercicio 3
 * Algoritmo: Calcular el factorial de un natural
 * Fecha: 09.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        int numero;
        int factorial;

        System.out.print("Entra un número natural: ");
        numero = Integer.parseInt(reader.readLine());
        factorial = 1;

        System.out.print("Factorial de " + numero + " es: ");
        for (int i = 1; i < numero + 1; ++i)
            factorial = factorial * i;

        System.out.println(factorial);
    }
}
