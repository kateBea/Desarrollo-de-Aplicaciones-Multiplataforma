package arrays;

import java.util.Random;

public class ArraysMultidimensionales {
    private static final Random rand = new Random();
    public static void main(String[] args) {
        int[][] bidimensionalRegular = new int[5][3];

        // inicializamos solo las "filas" con arrays int[5]
        int[][] bidimensionalIrregular = new int[5][];

        // inicializamos filas con longitud aleatoria de valor entre 0 y 6, ambos inclusos
        for (int i = 0; i < bidimensionalIrregular.length; ++i)
            bidimensionalIrregular[i] = new int[2 * rand.nextInt(4)];

        mostrarBidimensional(bidimensionalRegular, "matriz regular");
        mostrarBidimensional(bidimensionalIrregular, "matriz irregular");
    }

    public static void mostrarBidimensional(int[][] matriz, String promt) {
        System.out.println(promt);
        for (int[] fila : matriz) {
            for (int dato : fila)
                System.out.print(dato + " ");

            System.out.print('\n');
        }
    }
}
