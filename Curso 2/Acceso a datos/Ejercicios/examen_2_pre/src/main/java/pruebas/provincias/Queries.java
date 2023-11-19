package pruebas.provincias;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queries {
    private static Provincias queryProvincias;

    public static void setProvincias(Provincias provincias) {
        queryProvincias = provincias;
    }

    /**
     * Lista todas las provincias.
     * */
    public static class Query1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nQuery 1\n");
            queryProvincias.getProvincias().stream().map(Provincia::getNombre).forEach(System.out::println);
        }
    }

    /**
     * Lista todos los municipios. (Evitar repeticiones en el posible caso de que las haya)
     * */
    public static class Query2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nQuery 2\n");
            queryProvincias.getProvincias().stream().flatMap(provincia -> provincia.getLocalidades().
                    getLocalidades().stream()).
                    map(Localidad::getCData).
                    distinct().
                    forEach(System.out::println);
        }
    }

    /**
     * Lista de provincias y el total de municipios que tiene cada una.
     * */
    public static class Query3 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nQuery 3\n");
            queryProvincias.getProvincias().
                    forEach(provincia -> System.out.println("Provincia: " + provincia.getNombre().getNombre() +
                            " Total municipios: " + provincia.getLocalidades().getLocalidades().size()));

            // alternativa
            queryProvincias.getProvincias().
                    stream().
                    collect(Collectors.toMap(Provincia::getNombre, p -> (long) p.getLocalidades().getLocalidades().size())).
                    forEach((nombre, cuantos)-> System.out.println(nombre.getNombre() + " ->" + cuantos));
        }
    }

    /**
     * Leer por teclado el nombre de una provincia y mostrar sus municipios.
     * */
    public static class Query4 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nQuery 4\n");

            String input = null;

            try {
                final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                System.out.print("Introduce una provincia: ");

                input = bufferedReader.readLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            if (input != null) {
                String finalInput = input;
                queryProvincias.getProvincias().stream().
                        filter(provincia -> provincia.getNombre().getNombre().equalsIgnoreCase(finalInput)).
                        flatMap(provincia -> provincia.getLocalidades().getLocalidades().stream()).
                        forEach(System.out::println);
            }
        }
    }

    /**
     * Leer por teclado el nombre de un municipio y mostrar la provincia donde se encuentra.
     * */
    public static class Query5 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nQuery 5\n");

            String input = null;

            try {
                final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                System.out.print("Introduce un municipio: ");

                input = bufferedReader.readLine();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            if (input != null) {
                String finalInput = input;
                queryProvincias.getProvincias().stream().
                        filter(provincia -> provincia.getLocalidades().getLocalidades().stream().
                                                                                        anyMatch(localidad -> localidad.getCData().equalsIgnoreCase(finalInput))).
                        forEach(provincia -> System.out.println(provincia.getNombre()));
            }
        }
    }

    /**
     * En una lista tenemos distintos identificadores de provincias, mostrar el nombre
     * de los municipios y todas las provincias correspondientes a los identificadores
     * que se encuentran en la lista.
     * */
    public static class Query6 implements Runnable {

        @Override
        public void run() {
            final List<String> identificadores = List.of("01", "02", "03");

            queryProvincias.getProvincias().stream().
                    filter(provincia -> identificadores.contains(provincia.getId())).
                    collect(Collectors.toMap(Provincia::getNombre, Provincia::getLocalidades)).
                    forEach((nombre, localidades) -> System.out.println(nombre + " " + localidades.getLocalidades()));

        }
    }
}
