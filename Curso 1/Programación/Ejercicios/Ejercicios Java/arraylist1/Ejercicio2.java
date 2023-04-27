package arraylist1;

/* 
 * Este programa crea un ArrayList<Integer>. Almacena en él 
 * los número del 0 al 9 ambos inclusos.
 * 
 * @author Hugo
 * @version 1.0
 * @date 24 de enero de 2023
 */

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros = inicializar();
        imprimirNumeros(numeros);
    }
    
    /*
    * Inicializa una ArrayList con los números del 0 al 9 
    *
    * @param None
    * @return ArrayList<> colección conteniendo los datos de inicialización
    * @author Hugo
    */
    public static ArrayList<Integer> inicializar() {
        int TOTAL_NUMEROS = 10;
        ArrayList<Integer> numeros;

        // inicializa un ArrayList<> con tamaño fijo
        numeros = new ArrayList<>(TOTAL_NUMEROS);

        for (int i = 0; i < TOTAL_NUMEROS; ++i) {
            Integer vl = i;
            numeros.add(i, vl);

            // alternativa. IMPORTANTE: Integer(int) obsoleto
            // numeros.add(i, new Integer(i));
        }

        return numeros;
    }

    /*
    * Muestra por la salida de datos los contenido de un ArrayList<Integer> 
    * (ArrayList de enteros) imprimiendo uno a uno en una nueva línea
    *  
    * @param numeros Un objeto ArrayList que contiene una secuencia de enteros
    * @return void
    * @author Hugo
    */
    public static void imprimirNumeros(ArrayList<Integer> numeros) {
        System.out.println("Lista de numeros:");
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
    }
}