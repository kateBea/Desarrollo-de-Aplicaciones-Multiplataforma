package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class Main {
    private static Gson gson;
    private static Marshaller marshaller;

    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "../paises.json";

        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            List<Pais> paises = List.of(gson.fromJson(lector, Pais[].class));
            System.out.println(paises);

            Paises paises1 = Paises.builder().paises(paises).build();
            marshaller.marshal(paises1, System.out);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void initContext() throws JAXBException {
        gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                create();

        JAXBContext jaxbContext = JAXBContext.newInstance(Paises.class);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}