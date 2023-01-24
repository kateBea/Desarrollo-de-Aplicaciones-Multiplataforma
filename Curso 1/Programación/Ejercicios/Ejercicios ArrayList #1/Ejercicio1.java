/* 
 * Este programa crea una lista de palabras y
 * las almacena dentro de un ArrayList<>. Luego muestro los elementos de
 * esta colección por la salida de datos.
 * 
 * @author Hugo
 * @version 1.0
 * @date 24 de enero de 2023
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio1 {
    public static final InputStreamReader input = new InputStreamReader(System.in);
    public static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        ArrayList<String> palabras = new ArrayList<>();

        palabras = leerPalabras();
        imprimirPalabras(palabras);
    }
    
    /*
     * Lee de la entrada de datos una secuncia de String y los almacena 
     * en un ArrayList. Retorna el ArrayList conteniendo los objetos String
     * 
     * @param None
     * @return ArrayList<> colección conteniendo los String leídos de la entrada de datos
     * @author Hugo
     */
    public static ArrayList<String> leerPalabras() throws IOException {
        int numeroPalabras;
        ArrayList<String> palabras;

        System.out.print("Cuántas palabras deseas almacenar? ");
        numeroPalabras = Integer.parseInt(lector.readLine());

        // inicializa un ArrayList<> con tamaño fijo
        palabras = new ArrayList<>(numeroPalabras);

        for (int i = 0; i < numeroPalabras; ++i) {
            System.out.print("Introduzca una palabra: ");
            palabras.add(i, lector.readLine());
        }

        return palabras;
    }

    /*
     * Muestra por la salida de datos los contenido de un ArrayList<String> (ArrayList de String)
     * imprimiendo uno a uno en una nueva línea
     *  
     * @param palabras Un objeto ArrayList que contiene una secuencia de String
     * @return void
     * @author Hugo
     */
    public static void imprimirPalabras(ArrayList<String> palabras) {
        System.out.println("Lista de palabras:");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
    }
}