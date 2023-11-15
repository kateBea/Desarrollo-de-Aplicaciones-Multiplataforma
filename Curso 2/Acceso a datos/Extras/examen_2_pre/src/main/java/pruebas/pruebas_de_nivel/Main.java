package pruebas.pruebas_de_nivel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static Gson gson;

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "ficheros/pruebasdenivel.json";

        initContext();

        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            final List<Prueba> pruebas = List.of(gson.fromJson(lector, Prueba[].class));

            // [Depuración]
            System.out.println(gson.toJson(pruebas));
        } catch (IOException exception) {
            System.err.println("Excepción. Mensaje: " + exception.getMessage());
        }
    }

    private static void initContext() {
        GsonBuilder builder = new GsonBuilder().
                serializeNulls().
                setPrettyPrinting().
                registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());

        gson = builder.create();
    }
}
