package proveedor;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p>Unidad de prueba para las clases del paquete proveedor. Realiza pruebas sobre
 * las clases <b>Tienda</b> y <b>Producto</b>.</p>
 * <p>Los productos del proveedor se leen do un fichero. Dicho fichero
 * debe tener un formato específico, donde en cada línea lista un producto
 * con el formato <b>nombreProducto : precio</b>. Se crean cinco empresas
 * o tiendas (se entienden del enunciado como sinónimos) y para cada empresa
 * se registra su encargo. Finalizado este registro tenemos para cada empresa
 * los productos que ha encargado y un listado donde tenemos todos los productos
 * que se han encargado entre las cinco empresas.</p>
 *
 * @author Hugo Pelayo
 * @version 1.0
 * */
public class Principal {
    public static void main(String[] args) {
        // Inicialización de datos

        // Mostramos el directorio de trabajo actual de la clase Principal
        // que está configurada por defecto al directorio principal del proyecto.
        // (Puede ser de ayuda para indicar la dirección relativa del fichero de datos
        // y no tener que especificar la ruta completa del fichero)
        printCurrentWorkingDirectory();

        // registrar productos del proveedor
        ArrayList<Producto> datos = loadData("./src/Productos.txt");

        if (datos == null) {
            // Si so se pudieron cargar los datos finalizamos el programa

            System.out.println("--------------------------------");
            System.out.println("Could not load data from file...");
            System.out.println("--------------------------------");
            return;
        }

        // Gestionamos los encargos:
        // loadStoreData se encarga de actualizar la cantidad
        // de productos acorde a los encargos de las empresas
        ArrayList<Tienda> tiendas = loadStoreData(datos);
        double importeTotal = 0.0;

        for (Tienda tienda : tiendas) {
            System.out.println("Tienda " + tienda.getNombre() + ':');

            for (Producto producto : tienda.getProductos()) {
                System.out.print("Producto solicitado: " + producto.getNombre());
                System.out.print(" [" + producto.getCantidad() + " unidades]\n");
            }

            System.out.println("---------------------------------------");
        }

        // Todos los productos solicitados entre todas las tiendas
        System.out.println("\nRESUMEN TOTAL PRODUCTOS ENCARGADOS");
        for (Producto p : datos) {
            System.out.print("Producto solicitado: " + p.getNombre());
            System.out.print(" [" + p.getCantidad() + " unidades]\n");
            System.out.printf("Importe total solicitud: %.3f\n", p.getCantidad() * p.getPrecio());
            System.out.println("---------------------------------------");

            importeTotal += p.getCantidad() * p.getPrecio();
        }

        System.out.println("\nIMPORTE TOTAL DE LOS PRODUCTOS SOLICITADOS: " + importeTotal);

    }

    public static ArrayList<Tienda> loadStoreData(ArrayList<Producto> datos) {
        final InputStreamReader input = new InputStreamReader(System.in);
        final BufferedReader lector = new BufferedReader(input);
        final int TOTAL_TIENDAS = 5;

        int idProducto = 0;
        int cantidad;
        ArrayList<Tienda> retVal = new ArrayList<>();

        retVal.add(new Tienda("Alampo"));
        retVal.add(new Tienda("Mercadona"));
        retVal.add(new Tienda("Aldi"));
        retVal.add(new Tienda("Tesla"));
        retVal.add(new Tienda("Virtues"));

        // Para cada tienda vamos a registrar los productos que tiene encargados
        for (int i = 0; i < TOTAL_TIENDAS; ++i) {
            System.out.println("Tienda: " + retVal.get(i).getNombre());

            do{
                // Leemos el índice de producto.
                System.out.print("¿Qué producto desea [1, 14)? ");
                try {
                    idProducto = Integer.parseInt(lector.readLine());

                }
                catch (IOException exp) {
                    System.out.println("Formato de índice no válido o error de I/O. Inténtelo de nuevo.");
                    continue;
                }

                // Si el índice es -1 ya hemos acabado de tratar esta tienda
                if (idProducto == -1) {
                    System.out.println();
                    break;
                }

                System.out.println(datos.get(idProducto - 1).getNombre() + '\n');
                System.out.print("¿Qué cantidad desea? ");

                // Leemos la cantidad a encargar de este producto
                try {
                    cantidad = Integer.parseInt(lector.readLine());
                }
                catch (IOException exp) {
                    System.out.println("Formato de cantidad no válido o error de I/O. Inténtelo de nuevo.");
                    continue;
                }

                System.out.println();

                // añadimos el producto a la lista de productos solicitados por la tienda actual
                retVal.get(i).addProducto(new Producto(datos.get(idProducto - 1).getNombre(),
                                                       datos.get(idProducto - 1).getPrecio(),
                                                        cantidad));

                // Actualizamos la cantidad solicitada del producto actual [datos.get(idProducto - 1)]
                // La cantidad del producto será la actual más la que haya solicitado la tienda o empresa
                datos.get(idProducto - 1).setCantidad(datos.get(idProducto - 1).getCantidad() + cantidad);

            }
            while (idProducto != -1);
        }

        return retVal;
    }

    /**
     * Lee una lista de productos de un fichero. Devuelve un ArrayList conteniendo
     * para cada producto leído, su nombre y su precio. Todos los productos vienen
     * inicializados con el stock a 0. En caso de no poder abrir el fichero se
     * retorna una referencia nula (null)
     * @param dataFilePath directorio del fichero del cual se leen los datos
     * @return Lista de productos leídos donde tenemos el nombre de producto y su precio
     * */
    public static ArrayList<Producto> loadData(String dataFilePath) {
        // El fichero con directorio debe contener una lista de productos
        // donde en cada línea hay el nombre de un producto seguido de dos puntos y el precio
        BufferedReader buffer;
        ArrayList<Producto> retVal = null;
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
            // Mostramos la razón de excepción
            System.out.println("Excepción capturada: " + exp.getMessage());
        }

        return retVal;
    }

    /**
     * Interpreta una cadena separándola en nombre de producto y su precio
     * con la cantidad inicializada a 0
     * @param product String con datos de un producto
     * @return Nombre de producto y su precio
     * */
    public static Producto parseProduct(String product) {
        String[] temp = product.split(":");
        return new Producto(temp[0].trim(), Double.parseDouble(temp[1].trim()), 0);
    }

    /**
     * Muestra por pantalla el directorio de trabajo actual
     * */
    public static void printCurrentWorkingDirectory() {
        // For more: https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + workingDir);
    }
}