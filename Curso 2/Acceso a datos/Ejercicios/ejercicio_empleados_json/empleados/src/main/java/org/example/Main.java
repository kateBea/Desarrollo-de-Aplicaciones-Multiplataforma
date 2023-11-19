package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Main {
    private static Gson gson;
    private static Marshaller marshaller;

    public static void main(String[] args) {
        final String INPUT_JSON_FILE = "../empleados.json";
        final String OUTPUT_XML_FILE = "../empleados.xml";

        try {
            initContext();
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        try (Reader lector = new FileReader(INPUT_JSON_FILE)) {
            Empresa empresa = gson.fromJson(lector, Empresa.class);
            System.out.println(empresa);

            Writer escritor = new FileWriter(OUTPUT_XML_FILE);
            marshaller.marshal(empresa, escritor);
            marshaller.marshal(empresa, System.out);
            escritor.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void initContext() throws JAXBException {
        gson = new GsonBuilder().
                setPrettyPrinting().
                serializeNulls().
                create();

        marshaller = JAXBContext.newInstance(Empresa.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}