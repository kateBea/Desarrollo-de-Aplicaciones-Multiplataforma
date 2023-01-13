/* 
 * Este programa lee de la entrada estándar una cadena y un entero y muestra
 * por pantalla la cadena tantas veces como indique el entero.
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2013
 * 
 * 
 */

import java.io.*;

public class Ejercicio7 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        int numeroDeRepeticiones;
        String cadena;

        System.out.print("Introduce una cadena: ");
        cadena = lector.readLine();

        do {
            System.out.print("Introduce el número de repeticiones: ");
            numeroDeRepeticiones = Integer.parseInt(lector.readLine());

            if (numeroDeRepeticiones < 0)
                System.out.println("Error: El número de repeticiones debe ser un número natural o cero.\n");
        }
        while (numeroDeRepeticiones < 0);

        System.out.print(repetirCadena(cadena, numeroDeRepeticiones));
    }

    /*
     * Retorna el resultado de concatenar una cadena tantas veces como se indica
     * 
     * @param str La cadena a ser concatenada
     * @param veces El número de veces que se debe repetir la cadena
     * @return String el resultado de la concatenación
     * @authro Hugo
     */
    public static String repetirCadena(String str, int veces) {
        String resultado = new String();
        for (int i = 0; i < veces; ++i)
            resultado = resultado.concat(str);

        return resultado;
    }
}
