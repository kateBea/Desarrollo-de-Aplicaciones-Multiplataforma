import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Es posible que el nº de filas sea distinto a nº columnas
 * Es decir, las dimensiones sean distintas
 * Este caso tenemos un array de arrays
 * Para ello, es necesario únicamente indicar el tamaño de la primera 
 * dimensión, es decir, de las filas. Las siguientes dimensiones pueden ser variables
 * 
 * En este ejemplo se crear un array irregular en el que
 * tendremos dos filas pero un nº de columnas irregular
 */
import java.io.*;

public class Array_irregulares {
    public static void main(String[] ar) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        // declaración matriz irregular
        int[][] irreg = new int[2][];

        // Ahora para cada dimensión fila podemos crear una dimensión columns distinta
        irreg[0] = new int[4];
        irreg[1] = new int[6];

        // Leemos los datos
        for (int fila = 0; fila < irreg.length; fila++) {
            for (int col = 0; col < irreg[fila].length; col++) {
                System.out.print("Escribe nº: ");
                irreg[fila][col] = Integer.parseInt(lector.readLine());
            }

        }

        // Mostramos los datos
        for (int[] fila : irreg)
            for (int valor : fila)
                System.out.println("El num es " + valor);

    }
}
