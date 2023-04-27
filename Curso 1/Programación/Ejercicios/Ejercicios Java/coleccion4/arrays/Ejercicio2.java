package coleccion4.arrays;

/*
 * Título: Ejercicio 2
 * Algoritmo: Genera 10 números aleatorios entre el 0 
 * y el 15. A continuación, se solicita un número al usuario y se 
 * comprobará si dicho número está entre los generados
 * de ordenación que desea
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        Random randGenerator = new Random();
        final int limiteNumeros = 10;
        final int totalIntentos = 3;

        int userInput;  // entrada del usuario 
        int intentos = 0;   // contador de números de intentos hechos

        int[] numeros = new int[limiteNumeros];

        boolean encontrado;

        for (int index = 0; index < limiteNumeros; ++index) {
            // guardar números aleatorios en array "numeros" entre el 0 y el 15 ambos inclusive
            numeros[index] = randGenerator.nextInt(0, 16);
        }

        ordenar(numeros);
        System.out.println("Bienvenido a este minijuego. Se han generado 10 números");
        System.out.println("aleatorios, tu misión es adivinar 1, tienes 3 inetntos, suerte!");

        do {
            System.out.print("Introduce un número: ");
            userInput = Integer.parseInt(reader.readLine());
            ++intentos;
            encontrado = busquedaBinaria(numeros, userInput, 0, numeros.length - 1) != -1;
            if (!encontrado) {
                System.out.println("Has fallado, ese número no ha sido genrado.");
                System.out.print("Por favor, inténtalo de nuevo. [" + (totalIntentos - intentos));
                System.out.println("] intentos restantes.");

            }
            
        }
        while (!encontrado && intentos < totalIntentos);

        if (encontrado)
            System.out.println("Felicidades! Has acertado. El número [" + userInput + "] está en la lista.");

        System.out.print("Números de la lista: " + Arrays.toString(numeros));

        System.out.println();
    }

    static void ordenar(int[] numeros) {
        int aux;

        for (int p = 1; p < numeros.length; p++) {
            aux = numeros[p]; 
            int j = p - 1;

            while ((j >= 0) && (aux < numeros[j])) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = aux;
        }
    }

    public static int busquedaBinaria(int[] letras, int target, int limInf, int limSup) {
        if (limSup > limInf) {
            int midle = (limInf + limSup) / 2;
            if (letras[midle] > target) 
                return busquedaBinaria(letras, target, limInf, midle - 1);
            if (letras[midle] < target) 
                return busquedaBinaria(letras, target, midle + 1, limSup);
            return midle;
        }

        return -1;
    }
}
