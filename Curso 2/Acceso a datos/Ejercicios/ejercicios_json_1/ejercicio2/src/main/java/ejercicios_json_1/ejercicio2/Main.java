package ejercicios_json_1.ejercicio2;

import com.google.gson.*;

import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        final String DIRECTORIO_FICHERO = "../pruebasdenivel.json";

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(PruebasWrapper.class, new PruebasWrapperAdapter());
        Gson gson = gsonBuilder.create();

        PruebasWrapper listaPruebas = new PruebasWrapper();

        // Abrimos el archivo
        try {
            Reader lector = new FileReader(new File(DIRECTORIO_FICHERO));
            listaPruebas = gson.fromJson(lector, PruebasWrapper.class);
            lector.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("¡Fichero no encontrado!");
        }
        catch (IOException e) {
            System.err.println("¡Error de uso de Reader!");
        }

    }
}