package proveedor;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
    public static class Pair<T, U> {
        T m_First;
        U m_Second;

        public Pair(T first, U second) {
            m_First = first;
            m_Second = second;
        }

        public T getFirst() {
            return m_First;
        }

        public U getSecond() {
            return m_Second;
        }
    }
    public static void main(String[] args) {
        // Inicialización datos

        // Configurado por defecto al directory principal del proyecto
        // printCurrentWorkingDirectory();

        // registrar productos del proveedor
        ArrayList<Pair<String, Double>> datos = loadData("./src/Productos.txt");

        if (datos == null) {
            System.out.println("--------------------------------");
            System.out.println("Could not load data from file...");
            System.out.println("--------------------------------");
            return;
        }

        // Solicitar productos
        ArrayList<Tienda> tiendas = loadStoreData(datos);

    }

    public static ArrayList<Tienda> loadStoreData(ArrayList<Pair<String, Double>> datos) {
        final InputStreamReader input = new InputStreamReader(System.in);
        final BufferedReader lector = new BufferedReader(input);

        final int TOTAL_TIENDAS = 5;
        int idProducto = 0;
        int cantidad = 0;
        ArrayList<Tienda> retVal = new ArrayList<>(TOTAL_TIENDAS);

        retVal.add(new Tienda("Alampo"));
        retVal.add(new Tienda("Mercadona"));
        retVal.add(new Tienda("Aldi"));
        retVal.add(new Tienda("Tesla"));
        retVal.add(new Tienda("Virtues"));

        for (int i = 0; i < TOTAL_TIENDAS; ++i) {
            // gestiona las solicitudes por tienda
            System.out.println("Tienda: " + retVal.get(i).getNombre());
            do{
                System.out.print("¿Qué producto desea? ");
                try {
                    idProducto = Integer.parseInt(lector.readLine());
                }
                catch (IOException exp) {
                    System.out.println("Formato de índice no válido. Inténtelo de nuevo.");
                    continue;
                }
                System.out.println(datos.get(idProducto - 1).getFirst() + '\n');
                System.out.print("¿Qué cantidad desea? ");

                try {
                    cantidad = Integer.parseInt(lector.readLine());
                }
                catch (IOException exp) {
                    System.out.println("Formato de cantidad no válido. Inténtelo de nuevo.");
                    continue;
                }
                System.out.println();
                retVal.get(i).addProducto(new Producto(datos.get(idProducto - 1).getFirst(),
                                                       datos.get(idProducto - 1).getSecond(),
                                                        cantidad));

            }
            while (idProducto != -1);
        }


        return retVal;
    }

    public static ArrayList<Pair<String, Double>> loadData(String dataFilePath) {
        // El fichero con directorio debe contener una lista de productos
        // donde en cada línea hay el nombre de un producto seguido de dos puntos y el precio
        final BufferedReader buffer;
        ArrayList<Pair<String, Double>> retVal = null;
        String tempLine;
        try {
            // abrir fichero de datos
            buffer = new BufferedReader(new FileReader(dataFilePath));
            retVal = new ArrayList<>();

            // leer productos
            while ((tempLine = buffer.readLine()) != null) {
                retVal.add(parseProduct(tempLine));
            }

            // cerrar fichero de datos
            buffer.close();
        }
        catch (IOException exp) {
            System.out.println("Excepción capturada: " + exp.getMessage());
        }

        return retVal;
    }

    public static Pair<String, Double> parseProduct(String product) {
        Double value = null;
        String name = null;
        String[] temp = product.split(":");

        return new Pair<>(temp[0].trim(), Double.parseDouble(temp[1].trim()));
    }
    // helper func
    public static void printCurrentWorkingDirectory() {
        // For more: https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);
    }
}