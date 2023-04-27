package basico1;

/* Título: Ejercicio 7
* Algoritmo: Tabla de multiplicar de un número
* Fecha: 13/11/2022
* Autor: Hugo Pelayo
* */

import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        int numero;
        boolean enRango;

        do {
            System.out.print("Por favor, introduzca un número entero entre el 1 y el 10, ambos inclusos: ");
            numero = Integer.parseInt(reader.readLine());
            enRango = numero >= 0 && numero <= 10;

            if (!enRango)
                System.out.println("Valor fuera de rango");
        }
        while (!enRango);

        for (int i = 0; i <= 10; ++i) {
            System.out.printf("%d x %d = %d\n", i, numero, i * numero);
        }
    }
}