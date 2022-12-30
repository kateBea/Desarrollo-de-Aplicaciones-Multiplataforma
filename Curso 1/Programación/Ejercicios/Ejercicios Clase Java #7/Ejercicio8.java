import java.util.Random;
import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(input);
        final float LIMITE_INFERIOR = 1.0f;
        final float LIMITE_SUPERIOR = 50.0f;

        final Random rand = new Random();
        float[][] matriz;

        int numeroFilas;
        int numeroColumnas;

        System.out.print("Introduce el número de filas de la matriz: ");
        numeroFilas = Integer.parseInt(lector.readLine());
        System.out.print("Introduce el número de columnas de la matriz: ");
        numeroColumnas = Integer.parseInt(lector.readLine());
        
        matriz = new float[numeroFilas][numeroColumnas];
        for (int fila = 0; fila < numeroFilas; ++fila)
            for (int columna = 0; columna < numeroColumnas; ++columna)
                matriz[fila][columna] = rand.nextFloat(LIMITE_INFERIOR, LIMITE_SUPERIOR);

        for (float[] fila : matriz) {
            for (float numero : fila) 
                System.out.printf("%.3f ", numero);

            System.out.print("\n");
        }
    }
}