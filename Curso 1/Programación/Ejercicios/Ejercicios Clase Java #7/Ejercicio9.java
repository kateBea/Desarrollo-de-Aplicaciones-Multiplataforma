import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Ejercicio9 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        gestor();
    }

    public static void gestor() throws IOException {
        System.out.print("Entre un número aleatorio entre 1 y 10 (ambos inclusos): ");
        String[] frases;
        int tamanioArray;
        int index;

        tamanioArray = Integer.parseInt(lector.readLine());
        frases = leerFrases(tamanioArray);


        do {
            mostrarMenu();
            index = Integer.parseInt(lector.readLine());

            if (!(index > 0 && index < 8))
                System.out.println("Índice fuera de rango, intenta de nuevo.");
        }
        while (index != 7);
    }

    public static String[] leerFrases(int limite) throws IOException {
        String[] result = new String[limite];
        for (int i = 0; i < limite; ++i) {
            System.out.println("Introduzca frase #" + (i + 1) + ":");
            result[i] = lector.readLine();
        }

        return result;
    }

    public static void mostrarMenu() {
        System.out.println("1. Mostrar contenido del vector.");
        System.out.println("2. Mostrar todo el contenido en minúsculas.");
        System.out.println("3. Mostrar todo el contenido en mayúsculas.");
        System.out.println("4. Mostrar el contenido con la primera letra de cada palabra en minúsculas.");
        System.out.println("5. Mostrar el número de vocales y de consonantes de cada texto en cada posición.");
        System.out.println("6. Mostrar el contenido más largo.");
        System.out.println("7. Salir");
    }
}