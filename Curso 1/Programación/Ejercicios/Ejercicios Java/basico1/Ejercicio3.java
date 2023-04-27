package basico1;

/* Título: Ejercicio 3
* Algoritmo: Calcular la suma y promedio de una secuencia de números
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        float numero;
        int totalNumeros = 0;
        float sumaSecuencia = 0;

        do {

            System.out.print("Introduce un número entero por favor: ");
            numero = Float.parseFloat(reader.readLine());

            if (numero > 0) {
                totalNumeros += 1;
                sumaSecuencia += numero;
            }
        }
        while (numero >= 0);

        System.out.println("Has introducido un total de " + totalNumeros + " números positivos");
        System.out.println("La suma de todos los números es: " + sumaSecuencia);
        System.out.println("El promedio de la secuencia es: " + sumaSecuencia / totalNumeros);
    }
}