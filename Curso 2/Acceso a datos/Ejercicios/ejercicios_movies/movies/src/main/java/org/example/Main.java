package org.example;

// Para lectura de ficheros
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

// Utilidades
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Main {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

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

    /**
     * Serializa una lista de personas a un fichero XML
     * @param movies listado de películas serializar
     * */
    public static void xmlDump(MoviesWrapper movies) {
        if (movies == null || movies.getMovies().isEmpty()) {
            return;
        }

        try {
            JAXBContext context = JAXBContext.newInstance(MoviesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(movies, stringWriter);

            String contents = stringWriter.toString();

            // para depuración
            System.out.println(contents);

            final String nombreFichero = leerCadena("Introduce el nombre del fichero XML: ");
            File fichero = new File(nombreFichero + ".xml");

            if (!fichero.exists() && fichero.createNewFile()) {
                System.out.println("Fichero creado");
            }

            writeToFile(fichero, contents);
        }
        catch (JAXBException e) {
            System.err.println("Excepción JAXB: " + e.getCause());
        }
        catch (IOException e) {
            System.err.println("Excepción al crear fichero: " + e.getCause());
        }
    }

    public static void main(String[] args) {
        // Abrir fichero JSON con los datos
        // Ruta relativa al directorio "working directory" del proyecto
        final String path = "../movies.json";

        File fichero = new File(path);

        // lista de futbolistas obtenidos del fichero JSON
        List<Movie> peliculas = new ArrayList<>();

        if (fichero.exists() && fichero.isFile()) {
            String fileContents = getFileContents(fichero);

            JsonParser parser = new JsonParser();

            // Asume que el JSON contiene una lista de objetos
            JsonArray dataList = parser.parse(fileContents).getAsJsonArray();

            // Recorremos elementos de la lista del JSON
            for (JsonElement listElement :  dataList) {
                // Película de la lista
                JsonObject object = listElement.getAsJsonObject();

                String title = object.get("title").getAsString();
                Integer year = Integer.parseInt(object.get("year").getAsString());

                // Campo género puede ser una lista o un string
                List<String> genres = new ArrayList<>();
                if (object.get("genres").isJsonArray()) {
                    for (JsonElement element : object.get("genres").getAsJsonArray()) {
                        genres.add(element.getAsString());
                    }
                }
                else {
                    genres.add(object.get("genres").getAsString());
                }

                // Ratings
                List<Integer> ratings = new ArrayList<>();
                for (JsonElement element : object.get("ratings").getAsJsonArray()) {
                    ratings.add(element.getAsInt());
                }

                String duration = object.get("duration").getAsString();
                LocalDate releaseDate = LocalDate.parse(object.get("releaseDate").getAsString());
                String originalTitle = object.get("originalTitle").getAsString();
                String storyline = object.get("storyline").getAsString();

                // actors
                List<String> actors = new ArrayList<>();
                for (JsonElement element : object.get("actors").getAsJsonArray()) {
                    actors.add(element.getAsString());
                }

                String posterurl = object.get("posterurl").getAsString();


                peliculas.add(Movie.builder().title(title).year(year).genres(genres).
                        ratings(ratings).duration(duration).releaseDate(releaseDate).originalTitle(originalTitle).
                        storyline(storyline).actors(actors).posterurl(posterurl).build());
            }
        }
        else {
            System.err.println("¡Fichero no encontrado!");
        }

        if (!peliculas.isEmpty()) {
            System.out.println(peliculas);
        }
        else {
            System.out.println("¡El fichero está vacío!");
        }

        xmlDump(MoviesWrapper.builder().movies(peliculas).build());
    }

    /**
     * Lee una línea de la entrada por defecto de datos mostrando
     * primero el prompt que se pasa como parámetro. Si se falla la lectura devuelve null
     * @param prompt mensaje a mostrar antes de la lectura
     * @return string con la línea leída
     * */
    public static String leerCadena(String prompt) {
        if (prompt != null)
            System.out.print(prompt);

        String resultado = null;

        try {
            resultado = lector.readLine();
        }
        catch (IOException exception) {
            System.out.println("Excepción leer cadena: " + exception.getCause());
        }

        return resultado;
    }

    /*
     * Escribe el contenido de "contents" al fichero indicado
     * Se asume que el fichero ya existe. Sobreescribe el contenido
     * @param fichero ruta salida
     * @param contents contenido a escribir
     * */
    public static void writeToFile(File fichero, Object... contents) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,false));
            for (Object item : contents) {
                try {
                    escritor.write(item.toString());
                }
                catch (IOException e) {
                    System.err.println("Excepción al escribir al fichero: " + e.getCause());
                }
            }

            escritor.close();
        }
        catch (IOException e) {
            System.err.println("Excepción al abrir al fichero: " + e.getCause());
        }
    }
}