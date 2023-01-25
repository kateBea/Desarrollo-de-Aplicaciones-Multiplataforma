/* 
 * Este programa lee una lista de números enteros hasta introducir un -1.
 * Cada uno de ellos se lee en una línea nueva.
 * 
 * @author Hugo
 * @version 1.0
 * @date 24 de enero de 2023
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio4 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros = leerNumeros();
        imprimirNumeros(numeros);
    }

    /*
    * Lee de la entrada de datos una secuncia de números enteros separadas por líneas nuevas
    * y acabada en -1, los almacena en un ArrayList de Integer y retorna el ArrayList conteniendo
    * los valores
    * 
    * @param None
    * @return ArrayList<> colección conteniendo los valores leídos de la entrada de datos
    * @author Hugo
    */
    public static ArrayList<Integer> leerNumeros() throws IOException {
        ArrayList<Integer> cantidades = new ArrayList<>();
        int numero;

        System.out.println("Introduce cantidades por favor (acabadas en -1 y una por línea):");
        while ((numero = Integer.parseInt(lector.readLine())) != -1) 
            cantidades.add(numero);
        
        return cantidades;
    }

    /*
    * Muestra por la salida de datos los contenido de un ArrayList<Integer>
    * imprimiendo uno a uno en una nueva línea
    *  
    * @param cantidades Un objeto ArrayList que contiene una secuencia de Integers
    * @return void
    * @author Hugo
    */
    public static void imprimirNumeros(ArrayList<Integer> cantidades) {
        System.out.println("Lista de cantidades:");
        int indice = 0;
        for (Integer cantidad : cantidades) {
            System.out.println("Cantidad #" + ((indice++) + 1) + ": " + cantidad);
        }
    }
}