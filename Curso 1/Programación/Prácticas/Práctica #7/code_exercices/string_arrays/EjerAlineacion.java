package string_arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class EjerAlineacion {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static final String[] esquemaTactico = { "4-4-2", "4-3-3", "5-3-1-1", "3-5-2", "4-1-4-1" };
    private static final String [] jugadores = {"Bruno", "Jesús", "Torres", "Aguado", "Carlos", "Mario", "Jaime", "Tomás", "Aitor", "Unai", "Rubio"};

    public static void main(String[] args) throws IOException {
        int option;
        System.out.print("Elige el esquema para este partido (1-5): ");
        option = Integer.parseInt(reader.readLine());

        if (option > 0 && option < 6) {
            System.out.println("Esquema elegido: " + esquemaTactico[option - 1]);
            representarAlineacion(esquemaTactico[option - 1]);
        }
        else
            System.out.println("Esquema táctico no entrenado");
    }

    public static void representarAlineacion(String alineacion) {
        ArrayList<Integer> jugadoresPorLinea = new ArrayList<>();

        for (String numero : alineacion.split("-"))
            jugadoresPorLinea.add(Integer.parseInt(numero));

        System.out.println("                [" + jugadores[0] + "]\n");
        int indice = 1; // primer jugador se ha puesto
        for (Integer linea : jugadoresPorLinea) {
            switch (linea) {
                case 1 -> {
                    System.out.print("                [" + jugadores[indice] + ']');
                }
                case 2 -> {
                    for (int i = 0; i < linea; ++i)
                        System.out.print("         [" + jugadores[indice] + ']');
                }
                case 3 -> {
                    for (int i = 0; i < linea; ++i)
                        System.out.print("     [" + jugadores[indice] + ']');
                }
                default -> {
                    for (int i = 0; i < linea; ++i)
                        System.out.print('[' + jugadores[indice++] + "]   ");
                }
            }

            System.out.println('\n');
        }
    }
}