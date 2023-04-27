package basico1;

/* Título: Ejercicio 2
* Algoritmo: Indicar números pares de una secuencia de enteros
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero;

        do {

            System.out.print("Introduce un número entero por favor: ");
            numero = Integer.parseInt(reader.readLine());

            System.out.println("El número " + numero + (numero % 2 == 0 ? " es par" : " es impar") + "\n");
        }
        while (numero != 0);
    }
}