package pruebas.provincias;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    private static Gson gson;

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "ficheros/provincias.json";
        final String OUTPUT_FILE_PATH = "ficheros/provincias-output.json";

        createGsonContext();

        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            // Leer
            ListaProvincias lista = gson.fromJson(lector, ListaProvincias.class);
            lista.getWrapperProvincias().getProvincias().forEach(System.out::println);

            // Escribir
            Writer escritor = new FileWriter(OUTPUT_FILE_PATH);
            gson.toJson(lista, System.out);
            gson.toJson(lista, escritor);
            escritor.close();

        } catch (Exception e) {
            System.err.println("Excepción. Mensaje: " + e.getMessage());
        }

    }

    public static void createGsonContext() {
        GsonBuilder builder = new GsonBuilder().
                setPrettyPrinting();

        builder.registerTypeAdapter(Localidades.class, new LocalidadesAdapter());

        gson = builder.create();
    }
}
