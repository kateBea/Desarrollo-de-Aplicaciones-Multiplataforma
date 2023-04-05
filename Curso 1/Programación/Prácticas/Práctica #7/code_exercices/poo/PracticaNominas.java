package poo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

import poo.nomina.Empleado;
import poo.nomina.Directivo;
import poo.nomina.JefePlanta;
import poo.nomina.JefeSeccion;
import poo.nomina.MozoAlmacen;
import poo.nomina.PersonalAdministracion;

import poo.utils.Pair;

public class PracticaNominas {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    // el número indica el tipo de empleado
    private static ArrayList<Pair<Integer, Empleado>> empleados;

    public static void main(String[] args) {
        int opcion;
        empleados = new ArrayList<>();
        do {
            mostrarMenu();
            opcion = leerOpcion();
            
            procsesarOpcion(opcion);

        }
        while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.print(
            """
                        MENÚ
                        ====

            1.- Introducir trabajador
            2.- Eliminar trabajador
            3.- Mostrar sueldo e indemnización trabajador
            4.- Ver empleados de una categoría
            5.- Salir
            """
        );
    }

    public static int leerOpcion() {
        int resultado;

        do {
            System.out.print("\nElija opción: ");
            try {
                resultado = Integer.parseInt(reader.readLine());

                if (!(resultado >= 1 && resultado <= 5))
                    System.out.println("Valor debe estar en el rango [1, 5]");
            } 
            catch (NumberFormatException | IOException e) {
                resultado = -1;
                System.out.println("Opción no válida");
            }
        }
        while (!(resultado >= 1 && resultado <= 5));

        return resultado;
    }

    public static void procsesarOpcion(int opcion) {
        int indice;
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce nuevo trabajador");
                empleados.add(readEmpleado());
            }
            case 2 -> {
                boolean eliminado = false;
                if (empleados.isEmpty())
                    System.out.println("Error: no hay empleados registrados...");
                else {
                    mostrarEmpleados();
                    
                    do {
                        System.out.printf("\n¿Qué empleado desea eliminar? Índice en rango [1, %d]: ", empleados.size());
                        try {
                            indice = Integer.parseInt(reader.readLine());
    
                            if (!(indice > 0 && indice < empleados.size() + 1))
                                System.out.println("Índice de empleado no válido...");
                            else {
                                empleados.remove(indice - 1);
                                eliminado = true;
                            }
                        } 
                        catch (NumberFormatException | IOException e) {
                            indice = -1;
                            System.out.println("Error al leer índice de empleado...");
                        }
                    }
                    while (!eliminado);
                }

            }
            case 3 -> {
                boolean acabado = false;
                if (empleados.isEmpty())
                    System.out.println("Error: no hay empleados registrados...");
                else {
                    do {
                        System.out.println();
                        mostrarEmpleados();
                        System.out.print("¿De qué empleado desea ver el sueldo y la indemnización? ");
    
                        try {
                            indice = Integer.parseInt(reader.readLine());
                            acabado = indice >= 1 && indice <= empleados.size();
    
                            if (!acabado)
                                System.out.println("Índice de empleado no válido...");
                        } 
                        catch (NumberFormatException | IOException e) {
                            indice = -1;
                            System.out.println("Índice de empleado no válido...");
                        }
                    }
                    while (!acabado);
    
                    System.out.printf(
                        "%s %s %s %s\n", 
                        empleados.get(indice - 1).getSecond().getNombre(),
                        empleados.get(indice - 1).getSecond().getPrimerApellido(),
                        empleados.get(indice - 1).getSecond().getSegundoApellido(),
                        empleados.get(indice - 1).getSecond().getDni()
                    );
                    
                    switch (empleados.get(indice).getFirst()) {
                        // mostramos comision si es tipo jefe de planta o sección
                        case 1 -> System.out.println("Plus por comisiones de ventas: " + ((JefeSeccion)empleados.get(indice).getSecond()).plusComision());
                        case 2 -> System.out.println("Plus por comisiones de ventas: " + ((JefePlanta)empleados.get(indice).getSecond()).plusComision());
                        case 5 -> System.out.printf(
                            "Plus por cumplimiento de objetivos: %s\n", 
                            ((Directivo)empleados.get(indice).getSecond()).cumpleObjetivos() ? 
                            String.format("%.4f", ((Directivo)empleados.get(indice).getSecond()).plusCumplimiento()) : "no corresponde"
                            );
                    }
    
                    System.out.println("Sueldo neto por cada mes trabajado: " + empleados.get(indice).getSecond().sueldo());
                    System.out.println("Indemnización que corresponde: " + empleados.get(indice).getSecond().indemnizacion());
                }

            }
            case 4 -> {
                boolean acabado = false;
                if (empleados.isEmpty())
                    System.out.println("Error: no hay empleados registrados...");
                else {
                    do {
                        System.out.println();
                        System.out.println("¿Los empleados de qué categoría quiere mostrar? ");
                        mostrarCategorias();
    
                        try {
                            indice = Integer.parseInt(reader.readLine());
                            // índice entre 1 y el índice del último puesto
                            acabado = indice >= 1 && indice <= 5;
    
                            if (!acabado)
                                System.out.println("Índice de empleado no válido...");
                        } 
                        catch (NumberFormatException | IOException e) {
                            indice = -1;
                            System.out.println("Índice de empleado no válido...");
                        }
                    }
                    while (!acabado);
    
                    for (Pair<Integer, Empleado> item : empleados) {
                        if (item.getFirst() == indice) {
                            switch (indice) {
                                case 5 -> {
                                    // si es un directivo se muestra el plus de cumplimiento
                                    System.out.println("Plus cumplimiento de objetivos = " + ((Directivo)item.getSecond()).plusCumplimiento());
                                }
        
                                case 2 -> {
                                    // mostrar comisiones si es jefe de sección
                                    System.out.println("Plus por comisiones de ventas: " + ((JefeSeccion)item.getSecond()).plusComision());
                                }
                                case 3 -> {
                                    // mostrar comisiones si es jefe de planta
                                    System.out.println("Plus por comisiones de ventas: " + ((JefePlanta)item.getSecond()).plusComision());
                                }
                            }

                            System.out.printf(
                                "%s %s %s %s corresponde indemnización %.4f con %d días de antiguedad\n",
                                item.getSecond().getNombre(),
                                item.getSecond().getPrimerApellido(),
                                item.getSecond().getSegundoApellido(),
                                item.getSecond().getDni(),
                                item.getSecond().indemnizacion(),
                                item.getSecond().getDiasAntiguedad()
                            );
                        }
                    }
                }
            }
        }

        System.out.println();
    }

    public static void mostrarCategorias() {
        System.out.println("1.- Mozos de almacén");
        System.out.println("2.- Jefes de sección");
        System.out.println("3.- Jefes de planta");
        System.out.println("4.- Personal adminstrativo");
        System.out.println("5.- Directivos");

        System.out.println();
    }

    public static Pair<Integer, Empleado> readEmpleado() {
        String nombreEmpleado = "Unknown";
        String primerApellido = "Unknown";
        String segundoApellido = "Unknown";
        String dni = "Unknown";
        int puesto = 1;
        int antiguedadEnDias = 0;
        Pair<Integer, Empleado> empleado = new Pair<Integer,Empleado>();


        System.out.println();
        System.out.print("Nombre: ");
        try {
            nombreEmpleado = reader.readLine();
        } 
        catch (IOException e) {
            System.out.println("Error de excepción al leer el nombre...");
        }

        System.out.println();
        System.out.print("Primer apellido: ");
        try {
            primerApellido = reader.readLine();
        } 
        catch (IOException e) {
            System.out.println("Error de excepción al leer el primer apellido...");
        }

        System.out.println();
        System.out.print("Segundo apellido: ");
        try {
            segundoApellido = reader.readLine();
        } 
        catch (IOException e) {
            System.out.println("Error de excepción al leer el segundo apellido...");
        }

        System.out.println();
        System.out.print("DNI: ");
        try {
            dni = reader.readLine();
        } 
        catch (IOException e) {
            System.out.println("Error de excepción al leer el dni...");
        }

        do {
            System.out.println();
            System.out.print("Puesto [1.- Mozo, 2.- Jefe de sección, 3.- Jefe de Planta, 4.- Personal Administrativo, 5.- Directivo]: ");
            try {
                puesto = Integer.parseInt(reader.readLine());

                if (puesto < 1 || puesto > 5)
                    System.out.println("Valor de puesto inválido");
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error de excepción al leer el puesto...");
            }
        }
        while (puesto < 1 || puesto > 5);


        do {
            System.out.println();
            System.out.print("Días de antigüedad: ");
            try {
                antiguedadEnDias = Integer.parseInt(reader.readLine());

                if (antiguedadEnDias < 0)
                    System.out.println("Valor de antiguedad en días debe ser positivo o 0");
            } 
            catch (NumberFormatException | IOException e) {
                // para reiterar y volver a pedir los días
                antiguedadEnDias = -1;
                System.out.println("Error de excepción al leer los días de antigüedad...");
            }
        }
        while (antiguedadEnDias < 0);


        switch (puesto) {
            case 1 -> empleado.setSecond(new MozoAlmacen(dni, nombreEmpleado, primerApellido, segundoApellido, antiguedadEnDias));
            case 2 -> empleado.setSecond(new JefeSeccion(dni, nombreEmpleado, primerApellido, segundoApellido, antiguedadEnDias));
            case 3 -> empleado.setSecond(new JefePlanta(dni, nombreEmpleado, primerApellido, segundoApellido, antiguedadEnDias));
            case 4 -> empleado.setSecond(new PersonalAdministracion(dni, nombreEmpleado, primerApellido, segundoApellido, antiguedadEnDias));
            case 5 -> empleado.setSecond(new Directivo(dni, nombreEmpleado, primerApellido, segundoApellido, antiguedadEnDias));
        }

        empleado.setFirst(puesto);
        
        return empleado;
    }

    public static void mostrarEmpleados() {
        int indice = 1;

        for (Pair<Integer, Empleado> item : empleados) 
            System.out.printf(
                "%d.- %s %s %s %s con puetsto como %s llevas %d días de antiguedad\n",
                indice++,
                item.getSecond().getNombre(),
                item.getSecond().getPrimerApellido(),
                item.getSecond().getSegundoApellido(),
                item.getSecond().getDni(),
                getPuestoStr(item.getFirst()),
                item.getSecond().getDiasAntiguedad()
            );
    }

    public static String getPuestoStr(int puesto) {
        return switch (puesto) {
            case 1 -> "mozo";
            case 2 -> "jefe de sección";
            case 3 -> "jefe de planta";
            case 4 -> "personal de administración";
            case 5 -> "directivo";
            default -> "desconocido";
        };
    }
}