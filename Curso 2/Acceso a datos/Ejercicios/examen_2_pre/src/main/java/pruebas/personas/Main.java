package pruebas.personas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

public class Main {
    private static Gson gson;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    public static void main(String[] args) {
        final String INPUT_JSON_FILE = "ficheros/personas.json";
        final String OUTPUT_XML_FILE = "ficheros/personas.xml";

        // Inicialización
        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println("Error al inicializar contextos");
        }

        // Cargar y procesar datos
        try(Reader lectorFichero = new FileReader(INPUT_JSON_FILE)) {
            Personas personas = gson.fromJson(lectorFichero, Personas.class);

            // [Depuración]
            System.out.println(personas);
            marshaller.marshal(personas, new FileWriter(OUTPUT_XML_FILE));

            Personas personasUnmarshall = (Personas) unmarshaller.unmarshal(new FileReader(OUTPUT_XML_FILE));
            System.out.println(personasUnmarshall);

        } catch (Exception exception) {
            System.err.println("Excepción. Mensaje: " + exception.getMessage());
        }
    }

    private static void initContext() throws JAXBException {
        // GSON ------------------------
        gson = new GsonBuilder().
                serializeNulls().
                setPrettyPrinting().
                create();

        // JAXB ------------------------
        JAXBContext jaxbContext = JAXBContext.newInstance(Personas.class);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        unmarshaller = jaxbContext.createUnmarshaller();
    }
}
