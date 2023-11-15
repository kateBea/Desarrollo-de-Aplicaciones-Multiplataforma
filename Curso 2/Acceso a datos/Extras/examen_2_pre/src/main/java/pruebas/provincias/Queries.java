package pruebas.provincias;


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
            queryProvincias.getProvincias().stream().map(Provincia::getNombre).forEach(System.out::println);
        }
    }

    /**
     * Lista todos los municipios. (Evitar repeticiones en el posible caso de que las haya)
     * */
    public static class Query2 implements Runnable {

        @Override
        public void run() {

        }
    }

    /**
     * Lista de provincias y el total de municipios que tiene cada una.
     * */
    public static class Query3 implements Runnable {

        @Override
        public void run() {

        }
    }

    /**
     * Leer por teclado el nombre de una provincia y mostrar sus municipios.
     * */
    public static class Query4 implements Runnable {

        @Override
        public void run() {

        }
    }

    /**
     * Leer por teclado el nombre de un municipio y mostrar la provincia donde se encuentra.
     * */
    public static class Query5 implements Runnable {

        @Override
        public void run() {

        }
    }

    /**
     * En una lista tenemos distintos identificadores de provincias, mostrar el nombre
     * */
    public static class Query6 implements Runnable {

        @Override
        public void run() {

        }
    }
}
