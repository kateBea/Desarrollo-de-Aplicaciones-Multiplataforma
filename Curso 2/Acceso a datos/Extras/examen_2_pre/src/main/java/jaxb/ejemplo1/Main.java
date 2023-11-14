package jaxb.ejemplo1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;

/**
 * Serializa un student a fichero xml usando clase POJO.
 * */
public class Main {
    public static void main(String[] args) {
        Student student = Student.builder().
                dni("12345678K").
                nombre("Eduardo").
                curso("2022-2023").
                media(8.22).
                edad(19).
                build();

        System.out.println(student);

        final String outputFilePath = "ficheros/jaxb.ejemplo1.xml";

        try {
            // [Crea contexto JAXB]
            JAXBContext context = JAXBContext.newInstance(Student.class);

            // [Crear marshaller con contexto JAXB]
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // [Usar marshall para serializar los datos]

            // Serializamos a fichero
            marshaller.marshal(student, new FileWriter(outputFilePath));

            // Mostramos por pantalla
            marshaller.marshal(student, System.out);
        }
        catch (Exception exception) {
            System.err.println("Excepción. Mensaje: " + exception.getMessage());
        }
    }
}