/* Título: Ejercicio 1
* Algoritmo: Mostrar el cuadrado de un número
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        float numero;

        do {

            System.out.print("Introduce un número real por favor: ");
            numero = Float.parseFloat(reader.readLine());

            if (numero > 0)
                System.out.printf("[ %.3f ] al cuadrado es [ %.3f ]\n", (numero), (float)(Math.pow(numero, 2)));
        }
        while (numero >= 0);
    }
}