import figuras.Circulo;
import figuras.Cuadrado;
import figuras.Figura;
import figuras.Triangulo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PruebaFiguras {
    // Para lectura de datos
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        // Contiene todas las figuras
        ArrayList<Figura> figuras = new ArrayList<>();
        int opcion;

        do {
            mostrarMenu();
            System.out.print("-> ");
            opcion = Integer.parseInt(reader.readLine());

            if (!(opcion > 0 && opcion < 5))
                System.out.println("Opción no válida");
        }
        while(opcion != 4);
    }
    
    public static void mostrarMenu() {
        System.out.println("Escoja una opción:");
        System.out.println("1. Añadir figura");
        System.out.println("2. Eliminar figura (indicar índice)");
        System.out.println("3. Mostrar listado de figuras");
        System.out.println("4. Salir");
    }
}
