package ejercicio2;

import java.io.*;

public class TestPiscina {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    private static Piscina piscina;

    public static void main(String[] args) {
        System.out.println("************** Ejercicio 2 **************************");
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
                        "Valor entre %d y %d. (Pulse -1 para cancelar): ", ejercicio1.Piscina.getMin(), ejercicio1.Piscina.getMax())));
            }
            catch (NumberFormatException nfe) {
                // para volver a iterar en caso de excepción
                maxCapacity = -2;

                System.out.printf("Error. Solo se permiten números entre %d y %d%n",
                        Piscina.getMin(), Piscina.getMax());
            }
        }
        while (maxCapacity != -1 && !(maxCapacity >= ejercicio1.Piscina.getMin() && maxCapacity <= ejercicio1.Piscina.getMax()));

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
        while (opcion != 5);
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
            case 4:
                serializarPiscina();
                System.out.println("Serialización del objeto: " + piscina.toString());
                break;
        }
    }

    public static void serializarPiscina() {
        ObjectOutputStream outFile = null;
        try {
            outFile = new ObjectOutputStream(new FileOutputStream(("piscina.dat")));
            outFile.writeObject(piscina);
            outFile.close();
        }
        catch (IOException e) {
            System.out.println("Error. No se pudo serializar el objeto Piscina");
        }
    }
    public static void mostrarMenu() {
        System.out.println("1. Rellenar piscina");
        System.out.println("2. Vaciar piscina");
        System.out.println("3. Mostrar datos piscina");
        System.out.println("4. Serializar objeto");
        System.out.println("5. Salir");
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
