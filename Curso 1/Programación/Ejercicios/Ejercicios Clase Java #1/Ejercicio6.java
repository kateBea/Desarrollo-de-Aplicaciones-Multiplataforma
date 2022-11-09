/* Título: Ejercicio 6
 * Algoritmo: Comprobación de edad
 * Fecha: 08.11.2022
 * Autor: Hugo
 */

 import java.io.*;

public class Ejercicio6 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputReader);
        final int edadRequisito = 18;
        int edad;

        do {
            System.out.print("Introduce tu edad por favor: ");
            edad = Integer.parseInt(reader.readLine());
            
            if (edad < 0)
                System.out.println("La edad debe ser un valor nulo o positivo");
        } while (edad < 0);

        if (edad >= edadRequisito) 
            System.out.println("Bienvenido, puedes usar la aplicación, eres mayor de edad.");
        else 
        System.out.println("Acceso denegado por menoría de edad.");
    }
}