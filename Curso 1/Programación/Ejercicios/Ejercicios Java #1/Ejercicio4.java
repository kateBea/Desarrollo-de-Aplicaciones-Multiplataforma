/* Título: Ejercicio 4
* Algoritmo: Serie de números hasta N
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero;

        System.out.print("Introduce un número entero por favor: ");
        numero = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= numero; ++i) {
            // añadir espacio entre números si no es el último
            System.out.print(i + (i < numero ? " " : ""));
        }
    }
}