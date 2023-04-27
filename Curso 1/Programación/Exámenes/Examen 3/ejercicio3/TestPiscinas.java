package ejercicio3;

import ejercicio2.NivelPiscinaException;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class TestPiscinas {
    private static ObjectOutputStream outFile;
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    private static Hashtable<String, Piscina> piscinas;

    public static void main(String[] args) {
        System.out.println("************** Ejercicio 3 **************************");
        piscinas = new Hashtable<>();
        inicializarSerializacion();
        gestionarPiscinas();
        System.out.println("Fin del programa");
    }

    public static void gestionarPiscinas() {
        int opcion;
        do {
            mostrarMenuPrincipal();
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
        while (opcion != 6);
    }

    public static void inicializarSerializacion() {
        try {
            outFile = new ObjectOutputStream(new FileOutputStream(("piscina.dat")));
        }
        catch (IOException e) {
            System.out.println("Excepcion de IO");
        }
    }

    public static void procesarOpcion(int opcion) {
        String cif;
        int cantidad = 0;
        switch (opcion) {
            case 1:
                cif = leerCif();
                cantidad = leerCantidadAgua();

                if (cantidad == -1)
                    return;
                else {
                    piscinas.put(cif, new Piscina(cantidad));
                    System.out.println("Piscina creada");
                }
                break;
            case 2:
                cif = leerCadena("Escriba CIF de la comunidad al que pertenece la piscina\n");
                Piscina temp = piscinas.remove(cif);

                if (temp == null)
                    System.out.println("La clave no existe");
                break;
            case 3:
                for (Map.Entry<String, Piscina> item : piscinas.entrySet())
                    System.out.printf("Clave %s - Valor %s\n", item.getKey(), item.getValue());
                break;
            case 4:
                exportarAFichero();
                break;
            case 5:
                cif = leerCadena("Escriba CIF de la comunidad al que pertenece la piscina\n");

                if (piscinas.contains(cif))
                    gestionarPiscinaIndividual(piscinas.get(cif));
                else
                    System.out.println("La clave no existe");
                break;
        }
    }

    public static void gestionarPiscinaIndividual(Piscina piscina) {
        System.out.println("¿Qué operación desea realizar?");
        System.out.println(piscina.toString());
        int opcion;
        do {
            mostrarMenuPorPiscina();
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

    public static void procesarOpcion(int opcion, Piscina piscina) {
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
                catch (ejercicio1.NivelPiscinaException npe) {
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
                System.out.println("Serialización del objeto: " + piscina.toString());
                serializarPiscina(piscina);
                break;
        }
    }

    private static int leerCantidadAgua() {
        int cantidad = -1;
        try {
            cantidad = Integer.parseInt(leerCadena(String.format("Capacidad máxima de litros de la piscina." +
                    "Valor entre %d y %d (Pulse -1 para cancelar): ", Piscina.getMin(), Piscina.getMax())));
        }
        catch (NumberFormatException nfe) {
            System.out.println("Error. Solo se permiten números");
        }

        return cantidad;
    }

    public static void exportarAFichero() {
        File fileOut = new File("piscinas.txt");
        boolean existe;
        try {
            existe = fileOut.createNewFile();
        }
        catch (IOException e) {
            existe = false;
            System.out.println("Error al crear el fichero");
        }

        if (existe)
            System.out.println("Fichero ya existe");

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fileOut));
            for (Map.Entry<String, Piscina> item : piscinas.entrySet())
                escritor.write(String.format("Clave %s - Valor %s\n", item.getKey(), item.getValue()));
            escritor.close();
        }
        catch (IOException e) {
            System.out.println("Fichero es un directorio o no existe");
        }
    }

    private static String leerCif() {
        return leerCadena("Escriba CIF de la comunidad al que pertenece la piscina\n");
    }

    public static void serializarPiscina(Piscina piscina) {
        try {
            outFile.writeObject(piscina);
        }
        catch (IOException e) {
            System.out.println("Error. No se pudo serializar el objeto Piscina");
        }
    }
    public static void mostrarMenuPorPiscina() {
        System.out.println("1. Rellenar piscina");
        System.out.println("2. Vaciar piscina");
        System.out.println("3. Mostrar datos piscina");
        System.out.println("4. Serializar objeto");
        System.out.println("5. Salir");
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("1. Nueva piscina");
        System.out.println("2. Eliminar piscina");
        System.out.println("3. Mostrar piscinas");
        System.out.println("4. Exportar piscinas a fichero");
        System.out.println("5. Gestionar agua de una piscina");
        System.out.println("6. Salir");
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
