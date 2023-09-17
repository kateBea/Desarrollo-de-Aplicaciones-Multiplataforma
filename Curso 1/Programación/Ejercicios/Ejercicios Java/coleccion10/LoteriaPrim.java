package coleccion10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coleccion10.clases.Boleto;

public class LoteriaPrim {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    private static Boleto boleto;

    // Indica la opción de menú para fin de aplicación
    private static final int INDICE_FIN = 8;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(leerCadena(String.format("Elige la opción deseada (1-%d): ", INDICE_FIN)));

            if (!(opcion >= 1 && opcion <= INDICE_FIN))
                continue;

            procesarOpcion(opcion);

        } while (opcion != INDICE_FIN);
    }

    public static void procesarOpcion(int opcion) {
        System.out.println("Opción elegida: " + opcion);
        switch (opcion) {
            case 1 -> rellenarBoletoManualmente();
            case 2 -> {
                // TODO: IMPLEMENT
                
                System.out.println("Boleto rellenado correctamente");
            }
            case 3 -> {
                
            }
            case 4 -> {
                
            }
            case 5 -> {
                
            }
            case 6 -> {
                
            }
            case 7 -> {
                
            }
        }
    }

    private static void rellenarBoletoManualmente() {
        int casilla = 0;
        int indice = 0;
        int[] casillas = new int[Boleto.getLimiteCasilla()];

        while (indice < Boleto.getLimiteCasilla()) {
            final String USER_INPUT = leerCadena(String.format("Introduzca un número del 1 al 49 (ambos inclusos) para la casilla %d: ", (indice + 1)));            
            casilla = validarEntrada(USER_INPUT);
            
            if (casilla != -1) {
                System.out.println("Recibida casilla " + casilla);
                casillas[indice] = casilla;
            }
            else {
                System.out.println("Error, los únicos números posibles son del 1 al 49, por favor, inténtelo de nuevo");
                continue;
            }

            ++indice;
        }

        boleto = new Boleto(casillas);
        System.out.println("Boleto rellenado correctamente");
    }

    // retornará -1 si la entrada es inválida
    private static int validarEntrada(String entrada) {
        final int LIMITE_INFERIOR = 1;
        final int LIMITE_SUPERIOR = 49;
        int valor = Integer.parseInt(entrada);

        if (valor < LIMITE_INFERIOR || valor > LIMITE_SUPERIOR)
            valor = -1;

        return valor;
    }

    public static void mostrarMenu() {
        System.out.printf(
            "\n                 Menú lotería primitiva\n" +
            "================================================================\n" +
            "1. Rellenar un boleto de lotería primitiva nuevo manualmente\n" +
            "2. Rellenar un boleto de lotería primitiva nuevo aleatoriamente\n" +
            "3. Seleccionar el boleto de lotería primitiva activo\n" +
            "4. Mostrar el boleto de lotería primitiva activo\n" +
            "5. Comprobar los aciertos del boleto de lotería primitiva activo\n" +
            "6. Comprobar los aciertos de todos los boletos jugados\n" +
            "7. Mostrar la combinación ganadora\n" +
            "%d. Salir de la aplicación\n\n",
            INDICE_FIN
        );
    }

    public static String leerCadena(String promt) {
        if (promt  != null)
            System.out.print(promt);

        String resultado = null;
        try {
            resultado = lector.readLine();
        } catch(IOException e) { System.out.println(e.getMessage()); }

        return resultado;
    }
}
