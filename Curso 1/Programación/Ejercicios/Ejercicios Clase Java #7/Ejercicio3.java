/* 
 * Este programa lee dos números reales de la entrada de datos
 * y muestra por pantalla cuál de ambos es más grande.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        float num1 = 0;
        float num2 = 0;

        num1 = leerNumero();
        num2 = leerNumero();

        if (num1 == num2)
            System.out.println("Ambos son iguales.");
        else 
            System.out.println("El mayor es: " + mayor(num1, num2));
    }
    
    /*
     * Esta función lee un número real de la entrada de datos.
     * 
     * @param None
     * @return float número real leído
     * @author Hugo
     */
    public static float leerNumero() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);

        System.out.print("Introcue un número: ");
        return Float.parseFloat(lector.readLine());
    }

    /*
     * Esta función retorna el mayor de dos números reales.
     * Retrorna el primero si ambos son iguales
     * 
     * @param a número real a ser evaluado
     * @param b número real a ser evaluado
     * @return float el mayor de ambos números reales
     * @author Hugo
     */
    public static float mayor(float a, float b) {
        return a < b ? b : a; 
    }
}