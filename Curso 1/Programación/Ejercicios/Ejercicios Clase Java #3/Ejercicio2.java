/* Título: Ejercicio 2
 * Algoritmo: Asigna título
 * Fecha: 09.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        float numero;

        System.out.print("Intorduce tu nota por favor: ");
        numero = Float.parseFloat(reader.readLine());

        if (numero >= 0.0f && numero < 5.0f)
            System.out.println("Suspenso");
        else if (numero >= 5.0f && numero < 7.0f)
            System.out.println("Aprobado");
        else if (numero >= 7.0f && numero < 9.0f)
            System.out.println("Notable");
        else if (numero >= 9.0f && numero < 10.0f)
            System.out.println("Sobresaliente");
        else
            System.out.println("Matrícula de honor");
    }    
}
