package basico1;

/* Título: Ejercicio 6
* Algoritmo: Media de números positivos y negativos y cantidad de ceros
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        float numero;

        int cantidadCeros = 0;
        int cantidadPositivos = 0;
        int cantidadNegativos = 0;

        float sumaNegativos = 0;
        float sumaPositivos = 0;

        for (int i = 0; i < 10; ++i) {
            System.out.print("Introduce un número real por favor: ");
            numero = Float.parseFloat(reader.readLine());

            if (numero > 0) {
                sumaPositivos += numero;
                ++cantidadPositivos;
            }
            else if (numero < 0) {
                sumaNegativos += numero;
                ++cantidadNegativos;
            }
            else {
                ++cantidadCeros;
            }
        }

        if (cantidadPositivos == 0)
            System.out.println("No se introdujeron números positivos");
        else
            System.out.println("La media de los número positivos es: " + sumaPositivos / cantidadPositivos);

        if (cantidadNegativos == 0)
            System.out.println("No se introdujeron números positivos");
        else
            System.out.println("La media de los número positivos es: " + sumaNegativos / cantidadNegativos);

        System.out.print("La cantidad de ceros es: " + cantidadCeros);
    }
}