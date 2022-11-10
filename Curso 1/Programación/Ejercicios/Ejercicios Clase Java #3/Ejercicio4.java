/* Título: Ejercicio 4
 * Algoritmo: Pedir dos numeros y decir cual es mayor o si son iguales
 * Fecha: 10.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero1;
        int numero2;

        System.out.print("Introduce el primer número: ");
        numero1 = Integer.parseInt(reader.readLine());
        System.out.print("Introduce el segundo número: ");
        numero2 = Integer.parseInt(reader.readLine());

        if (numero1 == numero2)
            System.out.print("Ambos variables tienen el mismo valor");
        else
            System.out.println("El más grande es: " + (numero1 > numero2 ? numero1 : numero2));

    }
}