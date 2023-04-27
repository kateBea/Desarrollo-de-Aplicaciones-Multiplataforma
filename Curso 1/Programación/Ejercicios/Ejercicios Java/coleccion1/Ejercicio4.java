package coleccion1;

/* Título: Ejercicio 4
 * Algoritmo: Indicar el signo de un real
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        float numero;

        System.out.print("Introduzca el radio del circulo: ");
        numero = Float.parseFloat(lector.readLine());

        if (numero == 0.0f)
            System.out.println("El número es nulo.");
        else {
            if (numero > 0.0f) 
                System.out.println("El número es positivo.");
            else 
            System.out.println("El número es negativo.");
        }
    }
}
