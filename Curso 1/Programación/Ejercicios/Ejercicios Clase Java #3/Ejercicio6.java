/* Título: Ejercicio 6
 * Algoritmo: Pedir dos números e indicar si uno es múltiplo de otro
 * Fecha: 10.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException{
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero1;
        int numero2;

        System.out.print("Introduce el primer número: ");
        numero1 = Integer.parseInt(reader.readLine());
        System.out.print("Introduce el segundo número: ");
        numero2 = Integer.parseInt(reader.readLine());

        if (numero1 % numero2 == 0)
            System.out.println(numero1 + " es múltiplo de " + numero2);
        else if (numero2 % numero1 == 0)
            System.out.println(numero2 + " es múltiplo de " + numero1);
        else
            System.out.println("Los dos números no son múltiplos ninguno del otro");
    }
}
