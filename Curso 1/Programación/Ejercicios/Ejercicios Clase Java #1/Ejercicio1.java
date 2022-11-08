/* Título: Ejercicio 1
 * Algoritmo: Calcular el área de un círculo
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        float radio;

        System.out.print("Introduzca el radio del circulo: ");
        radio = Float.parseFloat(lector.readLine());
        System.out.printf("El área del círculo es: %.3f\n", (Math.PI * Math.pow(radio, 2)));
    }
}
