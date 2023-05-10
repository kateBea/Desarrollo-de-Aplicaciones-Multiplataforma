package coleccion10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coleccion10.clases.Boleto;

public class LoteriaPrim {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);
    private static final int INDICE_FIN = 8;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(leerCadena("Elige la opción deseada (1-8): "));

            if (!(opcion >= 1 && opcion <= INDICE_FIN))
                continue;

            procesarOpcion(opcion);

        } while (opcion != 8);
    }

    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {
                int casilla;
                int indice = 0;

                while (indice < Boleto.getLimiteCasilla()) {
                    
                    ++indice;
                }

                System.out.println("Boleto rellenado correctamente");
            }
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
