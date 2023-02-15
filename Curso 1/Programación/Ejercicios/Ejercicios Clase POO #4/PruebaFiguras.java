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
        int indiceFigura;

        do {
            mostrarMenu();
            System.out.print("-> ");
            opcion = Integer.parseInt(reader.readLine());

            if (!(opcion > 0 && opcion < 7))
                System.out.println("Opción no válida");
            else {
                switch (opcion) {
                    case 1 -> anadirFigura(figuras);
                    case 2 -> {
                        System.out.print("Entra índice: ");
                        indiceFigura = Integer.parseInt(reader.readLine());
                        eliminarFigura(indiceFigura, figuras);
                    }
                    case 3 -> mostrarFiguras(figuras);
                    case 4 -> editarFigura(figuras);
                    case 5 -> {
                        System.out.print("Entra índice: ");
                        indiceFigura = Integer.parseInt(reader.readLine());
                        dibujarFigura(indiceFigura, figuras);
                    }
                }
            }
        }
        while(opcion != 6);
    }
    
    public static void mostrarMenu() {
        System.out.println("Escoja una opción:");
        System.out.println("1. Añadir figura");
        System.out.println("2. Eliminar figura (indicar índice)");
        System.out.println("3. Mostrar listado de figuras");
        System.out.println("4. Editar figura");
        System.out.println("5. Dibujar figura");
        System.out.println("6. Salir");
    }

    public static void anadirFigura(ArrayList<Figura> figuras) throws IOException {
        int opcion;
        double temp1;
        double temp2;
        String color;

        System.out.println("Tipo de figura:");
        System.out.println("\t1. Círculo");
        System.out.println("\t2. Cuadrado");
        System.out.println("\t3. Triángulo");
        System.out.print("-> ");

        opcion = Integer.parseInt(reader.readLine());

        System.out.print("Introduce el color de la figura: ");
        color = reader.readLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce valor del radio: ");
                temp1 = Double.parseDouble(reader.readLine());
                figuras.add(new Circulo("Círculo", Figura.getColorType(color), temp1));
            }
            case 2 -> {
                System.out.print("Introduce valor del lado: ");
                temp1 = Double.parseDouble(reader.readLine());
                figuras.add(new Cuadrado("Cuadrado", Figura.getColorType(color), temp1));
            }
            case 3 -> {
                System.out.print("Introduce valor de la base: ");
                temp1 = Double.parseDouble(reader.readLine());
                System.out.print("Introduce valor de la altura: ");
                temp2 = Double.parseDouble(reader.readLine());
                figuras.add(new Triangulo("Triangulo", Figura.getColorType(color), temp1, temp2));
            }
        }

    }

    public static void eliminarFigura(int indice, ArrayList<Figura> figuras) {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras...");
            return;
        }

        if (indice > -1 && indice < figuras.size())
            figuras.remove(indice);
        else 
            System.out.println("Valor de índice inválido...");
    }

    public static void mostrarFiguras(ArrayList<Figura> figuras) {
        for (Figura figura : figuras)
            System.out.println(figura.toString() + "\n");
    }

    public static void editarFigura(ArrayList<Figura> figuras) {
        // TODO: Implementar
        
    }

    public static void dibujarFigura(int indice, ArrayList<Figura> figuras) {
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras...");
            return;
        }

        if (indice > -1 && indice < figuras.size())
            figuras.get(indice).dibujar();
        else 
            System.out.println("Valor de índice inválido...");
    }
    
}
