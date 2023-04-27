package coleccion5;

/*
 * Título: Primitiva
 * Algoritmo: Jugar a la primitiva
 * Autor: Hugo Pelayo:
 * Fecha: 24.11.2022
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio4 {
    // rand se declara global para evitar
    // seed-ear (seed) cada vez que se usa
    private static final Random rand = new Random();

    public static void sortear(int[] arr) {
        // Se usa para determinar el aleatorios de números
        // random y ambos límites está inclusos
        final int LIMITE_SUP_ALEATORIOS = 49;
        final int LIMITE_INF_ALEATORIOS = 1;
        boolean fin = false;
        int index = 0;
        int numAux;

        do {
            if (index < arr.length) {
                numAux = rand.nextInt(LIMITE_INF_ALEATORIOS, LIMITE_SUP_ALEATORIOS);

                String cnt = String.valueOf(numAux);
                if (!Arrays.toString(arr).contains(cnt)) {
                    arr[index] = numAux;
                    ++index;
                }
            }
            else
                fin = true;
        }
        while(!fin);
    }

    public static void leerDatos(int[] arr) throws IOException{
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        boolean fin = false;
        int index = 0;
        int numAux;

        do {
            if (index < arr.length) {
                System.out.print("Introduce número #" + (index + 1) + ": ");
                numAux = Integer.parseInt(reader.readLine());

                String cnt = String.valueOf(numAux);
                if (!Arrays.toString(arr).contains(cnt)) {
                    arr[index] = numAux;
                    ++index;
                }
                else
                    System.out.println("El número ya existe...");
            }
            else
                fin = true;
        }
        while(!fin);
    }

    public static int intersection(int[] arr1, int[] arr2) {
        int totalIguales = 0;
        int index_arr1 = 0;
        int index_arr2 = 0;

        while (index_arr1 < arr1.length && index_arr2 < arr2.length) {
            if (arr1[index_arr1] == arr2[index_arr2]) {
                ++totalIguales;
                ++index_arr1;
                ++index_arr2;
            }
            else if(arr1[index_arr1] < arr2[index_arr2]) {
                ++index_arr1;
            }
            else {
                ++index_arr2;
            }
        }
        return totalIguales;
    }

    public static void imprimir(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) throws IOException {
        final int LIMITE_ENTRADAS = 6;

        int[] userData = new int[LIMITE_ENTRADAS];
        int[] randomData = new int[LIMITE_ENTRADAS];
        leerDatos(userData);
        sortear(randomData);

        imprimir(userData);
        imprimir(randomData);

        System.out.println("Has acertado: " + intersection(userData, randomData) + " valores.");
    }
}