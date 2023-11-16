package jaxb.ejemplo2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "ficheros/jaxb.ejemplo2.xml";

        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Student student = (Student) unmarshaller.unmarshal(new FileReader(inputFilePath));

            System.out.println(student);

        }
        catch (Exception exception) {
            System.err.println("Excepción. Mensaje: " + exception.getMessage());
        }
    }
}
