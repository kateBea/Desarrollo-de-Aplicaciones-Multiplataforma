package coleccion4.arrays;

/*
 * Título: Ejercicio 1
 * Algoritmo: Pide al usuario 10 números y el método 
 * de ordenación que desea
 * Fecha: 15.11.2022
 * Autor: Hugo Pelayo
 */

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException{
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        final int limiteNumeros = 10;
        int ordenacionEscogida;
        float[] numeros = new float[limiteNumeros];

        System.out.println("Introduce diez números:");

        for (int index = 0; index < limiteNumeros; ++index) {
            System.out.print("Introduce número #" + (index + 1) + ": ");
            numeros[index] = Float.parseFloat(reader.readLine());
        }

        System.out.println("Indique el método de ordenación (introduce índice): ");
        System.out.println("[1] Ordenación burbuja.");
        System.out.println("[2] Ordenación por selección.");
        System.out.println("[3] Ordenación inserción.");

        do {
            ordenacionEscogida = Integer.parseInt(reader.readLine());
            if (!(ordenacionEscogida > 0 && ordenacionEscogida < 4))
                System.out.print("índice no válido. Inténtalo de nuevo: ");
        }
        while (!(ordenacionEscogida > 0 && ordenacionEscogida < 4));

        switch(ordenacionEscogida) {
            case 1:
                ordenacionBurbuja(numeros);
                break;
            case 2:
                ordenacionSeleccion(numeros);
                break;
            default:
                ordenacionInsercion(numeros);
            break;
        }

        System.out.println("Imprimiendo números ordenados: ");
        for (float fl : numeros) {
            System.out.print(fl + " ");
        }

        System.out.println();
    }

    static void ordenacionBurbuja(float[] numeros) {
        float temporal;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    temporal = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temporal;
                }
            }
        }
    }

    static void ordenacionSeleccion(float[] numeros) {
        float temporal;

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    // ...intercambiarlos, es decir, mover 
                    //el actual a la derecha y el de la derecha al actual
                    temporal = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temporal;
                }
            }
        }
    }

    static void ordenacionInsercion(float[] numeros) {
        float aux;

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
}