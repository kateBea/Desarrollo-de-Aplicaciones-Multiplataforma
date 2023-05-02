package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPiscina {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    private static Piscina piscina;

    public static void main(String[] args) {
        System.out.println("************** Ejercicio 1 **************************");
        inicializarPiscina();
        if (piscina != null)
            gestionarPiscina();

        System.out.println("Fin del programa");
    }

    public static void inicializarPiscina() {
        int maxCapacity;

        do {
            try {
                maxCapacity = Integer.parseInt(leerCadena(String.format("Capacidad máxima en litros de la piscina. " +
                        "Valor entre %d y %d. (Pulse -1 para cancelar): ", Piscina.getMin(), Piscina.getMax())));
            }
            catch (NumberFormatException nfe) {
                // para volver a iterar en caso de excepción
                maxCapacity = -1;

                System.out.println(String.format("Error. Solo se permiten números entre %d y %d",
                        Piscina.getMin(), Piscina.getMax()));
            }
        }
        while (maxCapacity != -1 && !(maxCapacity >= Piscina.getMin() && maxCapacity <= Piscina.getMax()));
        
        // cancelar si el usuario entra -1
        if (maxCapacity == -1) {
            piscina = null;
            return;
        }

        piscina = new Piscina(maxCapacity);
        System.out.println("Piscina creada");
    }
    
    public static void gestionarPiscina() {
        System.out.println("¿Qué operación desea realizar?");
        System.out.println(piscina.toString());
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(leerCadena("Opción: "));
                procesarOpcion(opcion);
            }
            catch (NumberFormatException nfe) {
                // para volver a iterar en caso de excepción
                opcion = -1;

                System.out.println("Error. Solo se permiten números");
            }
        }
        while (opcion != 4);
    }

    public static void procesarOpcion(int opcion) {
        // inicializar a 0 para mantener la piscina
        // sin cambios en caso de excepción
        int cantidad = 0;
        switch (opcion) {
            case 1:
                try {
                    cantidad = Integer.parseInt(leerCadena(String.format("Actualmente su piscina tiene un " +
                            "nivel de %d y su capacidad máxima es %d. Cantidad: ", piscina.getNivelActual(), piscina.getMaxNivel())));
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Error. Solo se permiten números");
                }

                try {
                    piscina.rellenar(cantidad);
                    System.out.println(piscina.toString());
                }
                catch (NivelPiscinaException npe) {
                    System.out.println(npe.getMessage());
                }
                break;
            case 2:
                try {
                    cantidad = Integer.parseInt(leerCadena(String.format("Actualmente su piscina tiene un " +
                            "nivel de %d. Cantidad: ", piscina.getNivelActual())));
                }
                catch (NumberFormatException nfe) {
                    System.out.println("Error. Solo se permiten números");
                }

                try {
                    piscina.vaciar(cantidad);
                    System.out.println(piscina.toString());
                }
                catch (NivelPiscinaException npe) {
                    System.out.println(npe.getMessage());
                }
                break;
            case 3:
                System.out.println(piscina.toString());
                break;
        }
    }

    public static void mostrarMenu() {
        System.out.println("1. Rellenar piscina");
        System.out.println("2. Vaciar piscina");
        System.out.println("3. Mostrar datos piscina");
        System.out.println("4. Salir");
    }

    public static String leerCadena(String prompt) {
        String resultado = null;
        if (prompt != null)
            System.out.print(prompt);

        try  {
            resultado = lector.readLine();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return resultado;
    }
}
