package org.example;

// Para lectura de ficheros
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

// Utilidades
import java.util.ArrayList;
import java.util.List;


/**
 * Proyecto maven de lectura sin adaptadores de datos de JSON
 * con librería GSON. Abrir con IntelliJ IDEA
 * */
public class Main {
    /*
     * Lee los productos de un fichero. Se asume
     * que el fichero existe y no es un directorio
     * @param fichero fichero a ser inspeccionado
     * @returns contenido del fichero
     * */
    public static String getFileContents(File fichero) {
        String result = null;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            result = lector.lines().reduce((l1, l2) -> l1 + "\n" + l2).orElse("Fichero vacío");
            lector.close();
        }
        catch (IOException e) {
            System.out.println("Error al leer del fichero: " + e.getCause());
        }

        return result;
    }

    public static void main(String[] args) {
        // Abrir fichero JSON con los datos
        // Ruta relativa al directorio "working directory" del proyecto
        final String path = "datos.json";

        File fichero = new File(path);

        // lista de futbolistas obtenidos del fichero JSON
        List<Futbolista> futbolistas = new ArrayList<>();

        if (fichero.exists() && fichero.isFile()) {
            String fileContents = getFileContents(fichero);

            JsonParser parser = new JsonParser();

            // Asume que el JSON contiene una lista
            JsonArray dataList = parser.parse(fileContents).getAsJsonArray();

            // Recorremos elementos de la lista del JSON
            for (JsonElement listElement :  dataList) {
                // El elemento puede ser de cualquier tipo, incluso una lista
                JsonObject object = listElement.getAsJsonObject();

                // Recuperar los datos como strings
                String dorsal = object.get("dorsal").getAsString();
                String nombre = object.get("nombre").getAsString();
                String equipo = object.get("equipo").getAsString();

                // Recuperar las posiciones
                List<String> posiciones = new ArrayList<>();
                JsonArray listaPosiciones = object.get("posiciones").getAsJsonArray();
                for (JsonElement pos : listaPosiciones) {
                    posiciones.add(pos.getAsString());
                }

                futbolistas.add(Futbolista.builder().
                        dorsal(dorsal).
                        nombre(nombre).
                        nombreEquipo(equipo).
                        posiciones(posiciones).
                        build());
            }
        }
        else {
            System.err.println("¡Fichero no encontrado!");
        }

        if (!futbolistas.isEmpty()) {
            System.out.println(futbolistas);
        }
        else {
            System.out.println("¡El fichero está vacío!");
        }
    }
}