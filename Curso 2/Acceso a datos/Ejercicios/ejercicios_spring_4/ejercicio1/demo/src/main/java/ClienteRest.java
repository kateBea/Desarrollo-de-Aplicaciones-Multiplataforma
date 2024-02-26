import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Compra;
import com.example.demo.modelo.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ClienteRest {
    private static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(inputStreamReader);

    private static RestTemplate REST_TEMPLATE = new RestTemplate();
    private static String URLBASE_PRODUCTOS = "http://localhost:8080/tienda/productos/";
    private static String URLBASE_CLIENTES = "http://localhost:8080/tienda/clientes/";
    private static String URLBASE_COMPRAS = "http://localhost:8080/tienda/compras/";

    public static void main(String[] args) {
        int opcion = -1;
        final int SALIR = 5;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(leerCadena("Introduce índice: "));
            procesarOpcion(opcion);

        } while(opcion != SALIR);
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {
                String dni = leerCadena("DNI: ");
                String nombre = leerCadena("Nombre: ");

                ResponseEntity<Cliente> response;

                try {
                    response = REST_TEMPLATE.postForEntity(
                            URLBASE_CLIENTES + "registrar",
                            Cliente.builder().dni(dni).nombre(nombre).build(),
                            Cliente.class
                    );

                    if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                        System.err.println("El cliente ya existe");
                    } else {
                        System.out.println("Registro de " + nombre + " realizado correctamente");
                    }

                } catch (Exception e) {
                    System.err.println("Error petición: " + e.getMessage());
                }
            }
            case 2 -> {
                String dni = leerCadena("Identificación (dni): ");

                int indce;
                List<Producto> productos = mostrarListaProductos();

                do {
                    indce = Integer.parseInt(leerCadena("Introduce índice: "));
                } while(indce < 0 || indce > productos.size() - 1);

                Integer cantidad = Integer.parseInt(leerCadena("Introduce la cantidad: "));

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("dni", dni);
                parametros.put("numRef", productos.get(indce).getNumRef());
                parametros.put("cantidad", cantidad);

                try {
                    ResponseEntity<Long> response = REST_TEMPLATE.postForEntity(
                            URLBASE_COMPRAS + "registrar?dni={dni}&numRef={numRef}&cantidad={cantidad}",
                            null,
                            Long.class, parametros);
                    System.out.printf("Se ha registrado su compra de %d %s (s). El id de seguimiento es [%d]\n",
                            cantidad, productos.get(indce).getNombre(), response.getBody());

                } catch (Exception e) {
                    System.err.println("Error en compra. " +  e.getMessage());
                }

            }
            case 3 -> {
                String dni = leerCadena("Identificación (dni): ");

                try {
                    ResponseEntity<Cliente> response = REST_TEMPLATE.getForEntity(
                            URLBASE_CLIENTES + "consultar/{dni}",
                            Cliente.class,
                            dni
                    );

                    if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                        System.err.println("Cliente no existe...");
                    } else {
                        String idCompra = leerCadena("Introduce id de compra: ");
                        Compra compra = REST_TEMPLATE.getForEntity(
                                URLBASE_COMPRAS + "consultar/{id}",
                                Compra.class,
                                Long.parseLong(idCompra)
                        ).getBody();

                        System.out.println(compra);
                    }

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            case 4 -> {
                mostrarListaProductos();
                System.out.println();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Dar cliente de alta");
        System.out.println("2. Realizar compra");
        System.out.println("3. Consultar compras");
        System.out.println("4. Consultar productos");
        System.out.println("5. Salir");
    }

    public static List<Producto> mostrarListaProductos() {
        List<Producto> productos = List.of(Objects.requireNonNull(
                REST_TEMPLATE.getForObject(URLBASE_PRODUCTOS + "consultar", Producto[].class)));

        int index = 1;
        System.out.println("\nMostrando todos los productos:");
        for (Producto producto : productos) {
            System.out.printf("%d. %s\n", index++, producto.getNombre());
        }

        return productos;
    }

    public static String leerCadena(String prompt) {
        String result = null;
        System.out.print(prompt);

        try {
            result = reader.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
