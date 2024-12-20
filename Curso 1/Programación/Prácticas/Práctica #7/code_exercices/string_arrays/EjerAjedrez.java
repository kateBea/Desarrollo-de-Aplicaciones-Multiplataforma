package string_arrays;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class EjerAjedrez {
    // El tablero es un cuadrado, es decir, una matriz de DIMENSION * DIMENSION
    private static final int DIMENSION = 8;
    private static char[][] tablero;
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static final String[] nombrePieza = { "Rey", "Dama", "Torre", "Alfil" };
    public static void main(String[] args) throws IOException {
        int fila;           // Fila del tablero. Está en el rango [1, DIMENSION]
        int columna;        // Columna del tablero. Está en el rango [1, DIMENSION]
        int numeroPieza;    // Índice de la pieza
        boolean correcto;   // Auxiliar que sirve como indicador de validez de los datos entrados

        // inicializar tablero
        tablero = new char[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; ++i)
            Arrays.fill(tablero[i], '-');

        do {
            // Leemos el índice de pieza
            mostrarPiezas();
            numeroPieza = Integer.parseInt(reader.readLine());
            System.out.println("\nOpción elegida: " + numeroPieza);
            correcto = numeroPieza >= 1 && numeroPieza <= 4;
        }
        while (!correcto);

        do {
            // Leemos la fila
            System.out.print("\nElige la fila donde quieras colocar tu pieza (1-8): ");
            fila = Integer.parseInt(reader.readLine());
            correcto = fila >= 1 && fila <= 8;
        }
        while (!correcto);

        do {
            // Leemos la columna
            System.out.print("\nElige la columna donde quieras colocar tu pieza (1-8): ");
            columna = Integer.parseInt(reader.readLine());
            correcto = columna >= 1 && columna <= 8;
        }
        while (!correcto);

        // ************ FIN LECTURA DE DATOS ************
        System.out.printf("Pieza = %s Fila = %d Columna = %d\n", nombrePieza[numeroPieza - 1], fila, columna);
        mostrarZonas(numeroPieza, fila, columna);
    }

    public static void mostrarPiezas() {
        System.out.print(
                // For learning purposes String formatting is a text block
                """
                Piezas disponibles
                ==================
                1. Rey
                2. Dama
                3. Torre
                4. Alfil

                Elige la pieza que quieres colocar (1-4):\s"""
        );
    }

    public static void mostrarZonas(int pieza, int fila, int columna) {
        switch (pieza) {
            case 1 -> posRey(fila, columna);
            case 2 -> posDama(fila, columna);
            case 3 -> posTorre(fila, columna);
            case 4 -> posAlfil(fila, columna);
        }

        mostrarTablero();
    }

    public static void posRey(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]


        // representan una dirección a la que se puede mover la pieza
        // hay 8 casillas adyacentes al Rey al que este se puede mover
        int[] dirFilas    = { 0, -1, -1, -1, 0, 1, 1, 1 };
        int[] dirColumnas = { -1, -1, 0, 1, 1, 1, 0, -1 };

        tablero[fila - 1][columna - 1] = 'R';

        // dirFilas y dirColumnas tienen el mismo tamaño
        for (int i = 0; i < DIMENSION; ++i)
            // iteramos sobre las casillas adyacentes a la del rey
            if (posValida(fila + dirFilas[i], columna + dirColumnas[i]))
                tablero[fila + dirFilas[i] - 1][columna + dirColumnas[i] - 1] = '*';
    }

    public static void posDama(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        trazarRectaVertical(fila, columna);
        trazarRectaHorizontal(fila, columna);
        trazarDiagonalPrincipal(fila, columna);
        trazarDiagonalInvertida(fila, columna);

        tablero[fila - 1][columna - 1] = 'R';
    }

    public static void posTorre(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        trazarRectaHorizontal(fila, columna);
        trazarRectaVertical(fila, columna);
        tablero[fila - 1][columna - 1] = 'T';
    }

    public static void posAlfil(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        trazarDiagonalPrincipal(fila, columna);
        trazarDiagonalInvertida(fila, columna);

        tablero[fila - 1][columna - 1] = 'A';
    }

    public static void mostrarTablero() {
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < DIMENSION; ++i) {
            System.out.print((i + 1) + " ");

            // imprime la fila
            for (char c : tablero[i]) {
                if (c != '-')
                    System.out.print(c + " ");
                else
                    // dos espacios en el caso de haber un guion
                    System.out.print("  ");
            }

            System.out.println();
        }
    }

    public static boolean posValida(int fila, int columna) {
        return (fila >= 1 && fila <= DIMENSION) &&
                (columna >= 1 && columna <= DIMENSION);
    }
    public static void trazarRectaVertical(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        for (int i = 0; i < DIMENSION; ++i)
            tablero[fila - 1][i] = '*';
    }

    public static void trazarRectaHorizontal(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        for (int i = 0; i < DIMENSION; ++i)
            tablero[i][columna - 1] = '*';
    }

    public static void trazarDiagonalPrincipal(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        // empezamos por la posición siguiente
        int tempFila = fila + 1;
        int tempColumna = columna + 1;

        // hacemos dos bucles porque no necesariamente (fila, columna) es un punto medio en la diagonal principal

        for ( ;posValida(tempFila, tempColumna); ++tempFila, ++tempColumna)
            tablero[tempFila - 1][tempColumna - 1] = '*';

        tempFila = fila - 1;
        tempColumna = columna - 1;

        for ( ;posValida(tempFila, tempColumna); --tempFila, --tempColumna)
            tablero[tempFila - 1][tempColumna - 1] = '*';

    }

    public static void trazarDiagonalInvertida(int fila, int columna) {
        // Rango fila [1, 8]
        // Rango columna [1, 8]

        // empezamos por la posición siguiente
        int tempFila = fila - 1;
        int tempColumna = columna + 1;

        // hacemos dos bucles porque no necesariamente (fila, columna) es un punto medio en la diagonal invertida

        for ( ; posValida(tempFila, tempColumna); --tempFila, ++tempColumna)
            tablero[tempFila - 1][tempColumna - 1] = '*';

        tempFila = fila + 1;
        tempColumna = columna - 1;

        for ( ; posValida(tempFila, tempColumna); ++tempFila, --tempColumna)
            tablero[tempFila - 1][tempColumna - 1] = '*';

    }
}