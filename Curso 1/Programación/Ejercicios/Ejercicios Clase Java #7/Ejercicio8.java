/* 
 * Este programa crea una tabla dinámica, esto es, una matriz bidimensional que
 * el usuario puede rellenar con los datos que desea, con las dimensiones que éste indique.
 * 
 * @author Hugo
 * @version 1.0
 * @date 14 de enero de 2023
 */

import java.io.*;

public class Ejercicio8 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    public static void main(String[] args) throws IOException {
        float[][] matriz;

        System.out.print("Introduce el número de filas de la matriz: ");
        matriz = new float[leerNatural()][];
        
        leerColumnas(matriz);
        imprimir(matriz);
    }

    /*
     * Este método lee números reales de la entrada de datos y rellena 
     * las columnas de una matriz con dichos datos.
     * 
     * @param matriz la matriz a ser rellenada
     * @return void
     * @author Hugo
     */
    public static void leerColumnas(float[][] matriz) throws IOException {
        // se asume la matriz ya tiene las filas inicializadas
        // sólo se tiene que leer las columnas (cada una puede variar de tamaño)
        for (int fila = 0; fila < matriz.length; ++fila) {
            System.out.print("Introduce el tamaño de la fila #" + (fila + 1) + ": ");
            matriz[fila] = new float[leerNatural()];
            System.out.print("Por favor, rellene la columna con los valores separados por espacios: ");

            validarFila(matriz[fila]);
        }
    }

    /*
     * Este método muestra por pantalla de manera formateada 
     * los datos de una matriz de números decimales
     * 
     * @param matriz la matriz a ser mostrada
     * @return void
     * @author Hugo
     */
    public static void imprimir(float[]... matriz) {
        for (float[] fila : matriz) {
            for (float numero : fila)
                System.out.printf("%.3f ", numero);

            System.out.print("\n");
        }
    }

    /*
     * Este método lee un entero de la entrada de datos. 
     * Se contínua la lectura hasta que el usuario introduzca un 
     * entero mayor o igual que cero
     * 
     * @param None
     * @return int el número leído
     * @author Hugo
     */
    public static int leerNatural() throws IOException {
        int resultado;
        while ((resultado = Integer.parseInt(lector.readLine())) < 0) {
            System.out.print("Por favor, introduce un número natural o cero: ");
        }

        return resultado;
    }

    /*
     * Este método lee una secuencia de números reales por la entrada de datos
     * y los guarda en una arreglo. Se asegura que hay exactamente valores.length() elementos
     * 
     * @param valores el arreglo a rellenar de datos
     * @return void
     * @author Hugo
     */
    public static void validarFila(float... valores) throws IOException {
        int TAMANIO_ARRAY = valores.length;
        String[] datos;

        do {    
            System.out.print("\n-> ");
            datos = lector.readLine().trim().split(" ");

            if (datos.length != TAMANIO_ARRAY)
                System.out.print("Por favor, introduzca exactamente " + TAMANIO_ARRAY + " datos...");
            else {
                int indice = 0;
                for (String num : datos)
                    valores[indice++] = Float.parseFloat(num);
            }
        }
        while (datos.length != TAMANIO_ARRAY);
    }
}