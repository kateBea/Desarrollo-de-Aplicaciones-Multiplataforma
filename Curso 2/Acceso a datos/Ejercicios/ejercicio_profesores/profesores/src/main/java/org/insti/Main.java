package org.insti;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Gson gson;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    public static void main(String[] args) {
        final String INPUT_JSON_FILE = "../profesores.json";
        final String OUTPUT_XML_FILE = "../profesores.xml";

        // Inicialización
        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        // Procesamiento datos
        try (Reader reader = new FileReader(INPUT_JSON_FILE)) {
            Instituto instituto = gson.fromJson(reader, Instituto.class);
            System.out.println(gson.toJson(instituto));

            marshaller.marshal(instituto, System.out);
            marshaller.marshal(instituto, new FileWriter(OUTPUT_XML_FILE));

            Instituto institutoFromXml = (Instituto) unmarshaller.unmarshal(new FileReader(OUTPUT_XML_FILE));
            System.out.println(institutoFromXml);

            runQueries(instituto);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void runQueries(Instituto instituto) {
        List<Runnable> queries = new ArrayList<>();

        Queries.initContext(instituto);

        queries.add(new Queries.Query1_1());
        queries.add(new Queries.Query1_2());

        queries.add(new Queries.Query2_1());
        queries.add(new Queries.Query2_2());

        queries.add(new Queries.Query3_1());
        queries.add(new Queries.Query3_2());

        queries.add(new Queries.Query4_1());
        queries.add(new Queries.Query4_2());

        queries.add(new Queries.Query5_1());
        queries.add(new Queries.Query5_2());

        for (Runnable query : queries) {
            query.run();
            System.out.println();
        }
    }

    private static void initContext() throws JAXBException {
        gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                create();

        JAXBContext jaxbContext = JAXBContext.newInstance(Instituto.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        unmarshaller = jaxbContext.createUnmarshaller();
    }
}