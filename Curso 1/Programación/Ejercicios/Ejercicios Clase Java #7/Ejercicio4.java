/* 
 * Este programa lee tres números reales de la entrada de datos
 * y muestra por pantalla cuál de los tres es el más grande.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        float num1 = 0;
        float num2 = 0;
        float num3 = 0;

        num1 = leerNumero();
        num2 = leerNumero();
        num3 = leerNumero();

        if (num1 == num2 && num2 == num3)
            System.out.println("Los tres son iguales.");
        else 
            System.out.println("El mayor es: " + mayor(num1, num2, num3));
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
     * Esta función retorna el mayor de dos números reales,
     * retrorna el primero si los tres son iguales.
     * 
     * @param a número real a ser evaluado
     * @param b número real a ser evaluado
     * @param c número real a ser evaluado
     * 
     * @return float el mayor de los tres números reales
     * @author Hugo
     */
    public static float mayor(float a, float b, float c) {
        return (a < b) ? (b < c ? c : b) : (a < c ? c : a);
    }
}