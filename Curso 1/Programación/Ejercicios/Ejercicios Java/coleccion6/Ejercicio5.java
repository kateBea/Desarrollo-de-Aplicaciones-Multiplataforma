package coleccion6;

/* 
 * Este programa pide un número por la entrada estándar de datos e indica
 * mediante un mensaje por pantalla la paridad de dicho número.
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2023
 * 
 * 
 */

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        int numero1;
        
        System.out.print("Introduce un número entero: ");
        numero1 = Integer.parseInt(lector.readLine());

        System.out.println("El entero[ " + numero1 + " ] es " + (esPar(numero1) ? "par." : "impar."));

    }

    /*
     * Retorna cierto si el valor pasado como parámetro es un número
     * par, retorna falso en caso contrario
     * 
     * @param numero el número a ser evaluado
     * @return boolean cierto, si el valor es par, falso en caso contrario
     * @authro Hugo
     */
    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}
