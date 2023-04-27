package coleccion1;

/* Título: Ejercicio 5
 * Algoritmo: Resolver ecuación cuadrática
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

import java.io.*;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        float a;
        float b;
        float c;
        float discriminant;

        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        
        // lectura de datos
        System.out.print("Please enter the value of [ a ]: ");
        a = Float.parseFloat(reader.readLine());
        System.out.print("Please enter the value of [ b ]: ");
        b = Float.parseFloat(reader.readLine());
        System.out.print("Please enter the value of [ c ]: ");
        c = Float.parseFloat(reader.readLine());

        discriminant = (float)Math.pow(b, 2) - (4 * a * c);

        if (discriminant < 0) {
            System.out.print("The corresponding equation with coefficients ");
            System.out.println("[ a ] = " + a + ", [ b ] = " + b + " and [ c ] = " + c);
            System.out.println("does not have a solution in the set of real numbers (no real roots) ):");
        }
        else {
            System.out.println("First solution [ + ]: " + ((-b + Math.sqrt(discriminant)) / 2.0f * a));
            System.out.println("Second solution [ - ]: " + ((-b - Math.sqrt(discriminant)) / 2.0f * a));
        }
    }
}
