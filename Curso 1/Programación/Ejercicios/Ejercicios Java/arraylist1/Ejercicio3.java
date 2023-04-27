package arraylist1;

/* 
 * Este programa crea una lista de cantidades que representan dinero y
 * las almacena dentro de un ArrayList<>. Luego muestra los elementos de
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

public class Ejercicio3 {
    public static final InputStreamReader input = new InputStreamReader(System.in);
    public static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        ArrayList<Float> cantidades = new ArrayList<>();

        cantidades = leerCantidades();
        imprimirCantidades(cantidades);
    }
    
    /*
    * Lee de la entrada de datos una secuncia de cantidades separadas por espacioes
    * y acabada en 0, los almacena en un ArrayList de Float y retorna el ArrayList conteniendo
    * los valores
    * 
    * @param None
    * @return ArrayList<> colección conteniendo los valores leídos de la entrada de datos
    * @author Hugo
    */
    public static ArrayList<Float> leerCantidades() throws IOException {
        ArrayList<Float> cantidades = new ArrayList<>();

        System.out.print("Introduce cantidades por favor (acabadas en cero). Ejemplo: 22 33 55 6 0:\n-> ");

        // se asume que el 0 siempre es el último valor de la secuencia
        for (String cantidad : lector.readLine().trim().split(" "))
            if (!cantidad.equals("0"))
                cantidades.add(Float.parseFloat(cantidad));

        return cantidades;
    }

    /*
    * Muestra por la salida de datos los contenido de un ArrayList<Float> (ArrayList de Float)
    * imprimiendo uno a uno en una nueva línea
    *  
    * @param cantidades Un objeto ArrayList que contiene una secuencia de Float
    * @return void
    * @author Hugo
    */
    public static void imprimirCantidades(ArrayList<Float> cantidades) {
        System.out.println("Lista de cantidades:");
        int indice = 0;
        for (Float cantidad : cantidades) {
            System.out.println("Cantidad #" + ((indice++) + 1) + ": " + cantidad);
        }
    }
}