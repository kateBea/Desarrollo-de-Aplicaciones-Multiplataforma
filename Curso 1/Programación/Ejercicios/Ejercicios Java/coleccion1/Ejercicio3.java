package coleccion1;

/* Título: Ejercicio 3
 * Algoritmo: Lectura de datos
 * Fecha: 08.11.2022
 * Autor: Hugo
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        int dato;
        float datoReal;
        String datoCadena;

        System.out.print("Introduce el número entero: ");
        dato = Integer.parseInt(lector.readLine());
        System.out.print("Introduce el número real: ");
        datoReal = Float.parseFloat(lector.readLine());
        System.out.print("Introduce cadena de caracteres: ");
        datoCadena = lector.readLine();


        System.out.println("El dato entero es: " + dato);
        System.out.println("El dato de cadena es: " + datoCadena);
        System.out.println("El dato de número real es: " + datoReal);
    }
}
