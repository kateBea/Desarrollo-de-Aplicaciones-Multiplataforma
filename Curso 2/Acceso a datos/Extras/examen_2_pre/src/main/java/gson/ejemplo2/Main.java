package gson.ejemplo2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.ejemplo1.Asignatura;
import gson.ejemplo1.LocalDateAdapter;
import gson.ejemplo1.Student;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String INPUT_FILE_PATH = "ficheros/gson.ejemplo2.json";

        GsonBuilder builder = new GsonBuilder().
                serializeNulls().
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                setPrettyPrinting();

        builder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        Gson gson = builder.create();

        // Escribir
        List<Student> students = getDatos();

        try (FileWriter escritor = new FileWriter(INPUT_FILE_PATH) ) {
            gson.toJson(students, escritor);
        } catch (IOException e) {
            System.err.println("Excepción. Mensaje: " + e.getMessage());
        }

        // Leer
        try (Reader lector = new FileReader(INPUT_FILE_PATH)) {
            List<Student> lista = List.of(gson.fromJson(lector, Student[].class));
            lista.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Error al leer del JSON. Mensaje: " + e.getMessage());
        }
    }

    public static List<Student> getDatos() {
        List<Student> estudiantes = new ArrayList<>();

        List<Asignatura> asignaturas = List.of(
                Asignatura.builder().nombre("Mates").nota(9.22).build(),
                Asignatura.builder().nombre("Castellano").nota(8.22).build(),
                Asignatura.builder().nombre("Química").nota(9.22).build(),
                Asignatura.builder().nombre("Catalán").nota(8.55).build());

        Student s1 = Student.builder().
                dni("12345678K").
                nombre("Eduardo").
                curso("2022-2023").
                media(Student.calcularMedia(asignaturas)).
                fechaNacimiento(LocalDate.now().minusYears(20)).
                asignaturas(asignaturas).
                build();


        List<Asignatura> asignaturas2 = List.of(
                Asignatura.builder().nombre("Mates").nota(5.22).build(),
                Asignatura.builder().nombre("Castellano").nota(6.22).build(),
                Asignatura.builder().nombre("Química").nota(7.22).build(),
                Asignatura.builder().nombre("Catalán").nota(8.88).build());

        Student s2 = Student.builder().
                dni("24362791T").
                nombre("Tiago").
                curso("2022-2023").
                media(Student.calcularMedia(asignaturas2)).
                fechaNacimiento(LocalDate.now().minusYears(21)).
                asignaturas(asignaturas2).
                build();

        estudiantes.add(s1);
        estudiantes.add(s2);

        return estudiantes;
    }
}
