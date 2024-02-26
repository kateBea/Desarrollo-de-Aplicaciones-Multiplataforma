package dam2.taller;

import dam2.taller.modelo.Asignacion;
import dam2.taller.modelo.Mecanico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ClienteRest {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String URLBASE_TRABAJO = "http://localhost:8080/taller/trabajos/";
    private static final String URLBASE_MECANICO = "http://localhost:8080/taller/mecanicos/";
    private static final String URLBASE_ASIGNACION = "http://localhost:8080/taller/asignaciones/";


    public static void main(String[] args) {
        int opcion;
        final int SALIR = 5;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(leerCadena("\nIntroduce índice: "));
            procesarOpcion(opcion);
        } while (opcion != SALIR);
    }

    private static void mostrarMenu() {
        System.out.println("1. Registrar mecánico");
        System.out.println("2. Registrar trabajo");
        System.out.println("3. Registrar piezas usada y tiempo");
        System.out.println("4. Finalizar trabajo");
        System.out.println("5. Salir");
    }

    private static void procesarOpcion(int opcion) {
        switch(opcion) {
            case 1 -> {
                String nombre = leerCadena("Introduce tu nombre: ");
                String password = leerCadena("Introduce tu contraseña: ");

                try {
                    ResponseEntity<Boolean> response = REST_TEMPLATE.postForEntity(
                            URLBASE_MECANICO + "registrar",
                            Mecanico.builder().nickname(nombre).contrasena(password).build(),
                            Boolean.class
                    );

                    boolean resultado = Boolean.TRUE.equals(response.getBody());

                    if (resultado) {
                        System.out.println("Registrado correctamente");
                    } else {
                        System.out.println("No se registró");
                    }


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            case 2 -> {
                String descripcion = leerCadena("Introduce la descripción: ");
                ResponseEntity<Asignacion> response;

                Map<String, String> valores = new HashMap<>();
                valores.put("desc", descripcion);

                try {
                    response = REST_TEMPLATE.postForEntity(
                        URLBASE_TRABAJO + "registrar&desc={desc}",
                            null,
                            Asignacion.class,
                            valores
                    );

                    Asignacion asignacion = response.getBody();

                    System.out.println(asignacion);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
            case 3 -> {

            }
            case 4 -> {

            }
        }
    }

    private static String leerCadena(String prompt) {
        String result = null;
        System.out.print(prompt);

        try {
            result = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
