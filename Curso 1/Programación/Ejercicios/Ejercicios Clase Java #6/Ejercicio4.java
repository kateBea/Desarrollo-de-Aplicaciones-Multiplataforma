/* 
 * Este programa lee do números enteros de la entrada estándar de datos
 * y muestra por pantalla el mayor, en caso de ser iguales se indica
 * un mensaje apropiado.
 * 
 * @author Hugo
 * @version 1.0
 * @date 13 de enero de 2023
 * 
 * 
 */

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        int numero1;
        int numero2;
        
        System.out.print("Introduzca el primer número: ");
        numero1 = Integer.parseInt(lector.readLine());
        System.out.print("Introduzca el segundo número: ");
        numero2 = Integer.parseInt(lector.readLine());

        System.out.println((numero1 == numero2 ? "Los dos son iguales" : (numero1 < numero2 ? 
            (numero2) : (numero1)) + " es el mayor"));

    }
}
