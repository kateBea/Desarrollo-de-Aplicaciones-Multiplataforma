package ejercicios_gson_1.ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Proyecto maven de lectura sin adaptadores de datos de JSON con librería GSON.
 * Proyecto Maven. Abrir con IntelliJ IDEA. Los ficheros tienen la ruta relativa,
 * que en el momento de creación del proyecto es relativa a la carpeta raíz de este.
 *
 * @author Hugo Pelayo
 * */
public class Main {
    public static void main(String[] args) {
        // Gson builder con output formateado (legible)
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        // Contenedor del listado de personas del GSON o nulo si
        // el fichero está vacío o no existe
        ListaPersonas personas = null;

        final String directorioFichero = "../personas.json";

        // Abrimos el archivo
        try {
            Reader lector = new FileReader(new File(directorioFichero));
            personas = gson.fromJson(lector, ListaPersonas.class);
            lector.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("¡Fichero no encontrado!");
        }
        catch (IOException e) {
            System.err.println("¡Error de uso de Reader!");
        }

        if (personas != null) {
            System.out.println("Listado de personas:\n");
            personas.getPersonas().forEach(System.out::println);

            System.out.println("\nListado de personas formato JSON:\n");
            System.out.println(gson.toJson(personas));
        }
    }
}