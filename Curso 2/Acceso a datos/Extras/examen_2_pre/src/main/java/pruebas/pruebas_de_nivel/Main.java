package pruebas.pruebas_de_nivel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static Gson gson;
    private static Marshaller marshaller;

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "ficheros/pruebasdenivel.json";
        final String OUTNPUT_XML_FILE_PATH = "ficheros/pruebasdenivel.xml";

        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            final List<Prueba> pruebas = List.of(gson.fromJson(lector, Prueba[].class));

            // [Depuración]
            System.out.println(gson.toJson(pruebas));

            PruebasXMLWrapper pruebasXMLWrapper = PruebasXMLWrapper.builder().pruebas(pruebas).build();
            marshaller.marshal(pruebasXMLWrapper, System.out);
            Writer writer = new FileWriter(OUTNPUT_XML_FILE_PATH);
            marshaller.marshal(pruebasXMLWrapper, writer);
            writer.close();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static void initContext() throws JAXBException {
        GsonBuilder builder = new GsonBuilder().
                serializeNulls().
                setPrettyPrinting().
                registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());

        gson = builder.create();

        marshaller = JAXBContext.newInstance(PruebasXMLWrapper.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
