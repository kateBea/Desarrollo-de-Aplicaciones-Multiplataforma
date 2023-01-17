/* 
 * Este programa cuenta el número de palabras que contiene una frase.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio10 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        String cadena;

        System.out.print("Introduce cadena: ");
        cadena = lector.readLine().trim();

        System.out.println("Total de palabra (s): " + (cadena.split(" ").length));
    }
}