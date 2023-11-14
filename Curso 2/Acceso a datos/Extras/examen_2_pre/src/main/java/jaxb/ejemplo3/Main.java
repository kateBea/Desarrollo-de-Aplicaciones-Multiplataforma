package jaxb.ejemplo3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.util.List;

import jaxb.ejemplo2.Student;
import jaxb.ejemplo2.Asignatura;

public class Main {
    public static void main(String[] args) {
        // crear asignaturas
        List<Asignatura> asignaturas = List.of(
                Asignatura.builder().nombre("Mates").nota(9.22).build(),
                Asignatura.builder().nombre("Castellano").nota(8.22).build(),
                Asignatura.builder().nombre("Química").nota(9.22).build(),
                Asignatura.builder().nombre("Catalán").nota(8.55).build());

        // Crear alumno
        Student student = Student.builder().
                dni("12345678K").
                nombre("Eduardo").
                curso("2022-2023").
                media(Student.calcularMedia(asignaturas)).
                edad(19).
                asignaturas(asignaturas).
                build();

        System.out.println(student);

        final String outputFilePath = "ficheros/jaxb.ejemplo2.xml";

        try {
            JAXBContext context = JAXBContext.newInstance(Student.class, Asignatura.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(student, new FileWriter(outputFilePath));
            marshaller.marshal(student, System.out);
        }
        catch (Exception exception) {
            System.err.println("Excepción. Mensaje: " + exception.getMessage());
        }
    }
}
