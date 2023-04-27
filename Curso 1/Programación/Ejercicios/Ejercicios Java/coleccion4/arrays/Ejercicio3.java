package coleccion4.arrays;

/*
 * Título: Ejercicio 3
 * Algoritmo: Crea un array multidimensional con los parámetros del usuario
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        Random randGenerator = new Random();
        char eleccionUsario;
        int numeroFilas;

        float[][] matriz;

        System.out.print("Introduzca el número de filas de la matriz: ");
        numeroFilas = Integer.parseInt(reader.readLine());
        matriz = new float[numeroFilas][];
        
        // tratamiento de error durante elección de tipo de matriz
        do {
            System.out.print("Si desea una matriz irregular escriba 'Y', escriba 'N' en caso contrario: ");
            eleccionUsario = reader.readLine().charAt(0);
            if (eleccionUsario != 'Y' && eleccionUsario != 'N')
                System.out.println("Por favor, introduce un carácter válido.");
        } while (eleccionUsario != 'Y' && eleccionUsario != 'N');

        // generar las filas acorde a la elección del usuario
        switch(eleccionUsario) {
            case 'Y':
                for (int index = 0; index < matriz.length; ++index) {
                    System.out.print("Introduce longitud de fila #" + (index + 1) + ": ");
                    matriz[index] = new float[Integer.parseInt(reader.readLine())];
                }
                break;
            case 'N':
                for (int index = 0; index < matriz.length; ++index) {
                    matriz[index] = new float[numeroFilas];
                }
                break;
        }
        
        // rellenar matriz e imprimirla
        System.out.println("Rellenando matriz con valores aleatorios...");

        for (int fila = 0; fila < matriz.length; ++fila) {
            for (int col = 0; col < matriz[fila].length; ++col)
                // números aleatorios entre 0 y 256
                matriz[fila][col] = randGenerator.nextInt(0, 256);
        }

        for (float[] fl : matriz)
            System.out.println(Arrays.toString(fl));
    }
}
