package pruebas.provincias;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Provincias provincias;
    private static Gson gson;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "ficheros/provincias.json";
        final String OUTPUT_FILE_PATH = "ficheros/provincias-output.json";

        final String OUTPUT_XML_FILE_PATH = "ficheros/provincias-output.xml";

        // Inicialización contexto
        try {
            initContext();
        } catch (Exception e) {
            System.err.println("Error al inicializar contexto. Mensaje: " + e.getMessage());
            return;
        }

        // Cargar y procesar datos
        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            ListaProvincias lista = gson.fromJson(lector, ListaProvincias.class);

            // [Depuración]
            Writer escritor = new FileWriter(OUTPUT_FILE_PATH);
            gson.toJson(lista, escritor);
            escritor.close();

            escritor = new FileWriter(OUTPUT_XML_FILE_PATH);
            marshaller.marshal(lista.getWrapperProvincias(), escritor);
            escritor.close();

            Reader lector1 = new FileReader(OUTPUT_XML_FILE_PATH);
            provincias = (Provincias) unmarshaller.unmarshal(lector1);

            // [Ejecutar queries]
            runQueries();

        } catch (Exception e) {
            System.err.println("Excepción. Mensaje: " + e.getMessage());
        }
    }

    private static void runQueries() {
        List<Runnable> queryRunners = new ArrayList<>();

        Queries.setProvincias(provincias);

        queryRunners.add(new Queries.Query1());
        queryRunners.add(new Queries.Query2());
        queryRunners.add(new Queries.Query3());
        queryRunners.add(new Queries.Query4());
        queryRunners.add(new Queries.Query5());
        queryRunners.add(new Queries.Query6());

        for (Runnable query : queryRunners) {
            query.run();
        }
    }

    public static void initContext() throws JAXBException {
        // GSON -------------------------------------------------------------
        GsonBuilder builder = new GsonBuilder().
                setPrettyPrinting().
                registerTypeAdapter(Localidades.class, new LocalidadesAdapter());

        gson = builder.create();

        // JAXB -------------------------------------------------------------
        JAXBContext jaxbContext = JAXBContext.newInstance(Provincias.class);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        unmarshaller = jaxbContext.createUnmarshaller();

    }
}
