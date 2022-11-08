/* Título: Ejercicio 2
 * Algoritmo: Calcular la suma, resta, multiplicación y división de dos números
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        float numero1;
        float numero2;

        System.out.print("Introduzca primer operando: ");
        numero1 = Float.parseFloat(lector.readLine());

        System.out.print("Introduzca segundo operando: ");
        numero2 = Float.parseFloat(lector.readLine());

        System.out.printf("La suma de %.2f y %.2f es: %.2f\n", numero1, numero2, numero1 + numero2);
        System.out.printf("La resta de %.2f y %.2f es: %.2f\n", numero1, numero2, numero1 - numero2);
        System.out.printf("La multiplicación de %.2f y %.2f es: %.2f\n", numero1, numero2, numero1 * numero2);
        
        if (numero2 == 0.0f)
            System.out.println("Error segundo operando nulo");
        else
            System.out.printf("La suma de %.2f división %.2f es: %.2f\n", numero1, numero2, numero1 / numero2);
    }
}