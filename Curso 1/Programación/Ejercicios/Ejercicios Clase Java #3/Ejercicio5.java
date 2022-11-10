/* Título: Ejercicio 5
 * Algoritmo: Pedir tres números y mostralos ordenados de mayor a menor
 * Fecha: 10.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero1;
        int numero2;
        int numero3;

        System.out.print("Introduce el primer número: ");
        numero1 = Integer.parseInt(reader.readLine());
        System.out.print("Introduce el segundo número: ");
        numero2 = Integer.parseInt(reader.readLine());
        System.out.print("Introduce el tercer número: ");
        numero3 = Integer.parseInt(reader.readLine());

        if (numero1 > numero2) {
            if (numero1 > numero3) 
                System.out.print(numero1 + " " + numero3);
            else 
                System.out.print(numero3 + " " + numero1);

            System.out.print(" " + numero2);
        } 
        else {
            if (numero2 > numero3) 
                System.out.print(numero2 + " " + numero3);
            else 
                System.out.print(numero3 + " " + numero2);

            System.out.print(" " + numero1);
        }
    }
}
