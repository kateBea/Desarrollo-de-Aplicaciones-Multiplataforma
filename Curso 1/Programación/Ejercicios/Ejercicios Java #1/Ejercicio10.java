/* Título: Ejercicio 10
* Algoritmo: Indica si un número es primo o no
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero;
        int divisor;
        final int limite;
        boolean esPrimo;

        System.out.print("Introduce un número entero por favor: ");
        numero = Integer.parseInt(reader.readLine());

        limite = (int)Math.sqrt(numero);
        divisor = 2;

        // se asume que no es primo porque es una búsqueda si
        // encontramos al menos un divisor != 1 la búsqueda finaliza
        esPrimo = true;
        while (divisor <= limite && esPrimo) {
            esPrimo = !(numero % divisor == 0);
            ++divisor;
        }

        if (esPrimo)
            System.out.printf("El número [ %d ] es primo\n", numero);
        else
            System.out.printf("El número [ %d ] no es primo\n", numero);
    }
}