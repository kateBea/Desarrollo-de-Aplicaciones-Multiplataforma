package gson.ejemplo1;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Preparamos los datos a serializar
        Student student = datoPrueba();
        System.out.println(student);

        // Crear contexto
        GsonBuilder builder = new GsonBuilder()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting();

        // Register adapters
        // Podemos especificar desde la clase. Ver definición de Student
        //builder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());

        Gson gson = builder.create();

        // Mostramos por pantalla
        System.out.println(gson.toJson(student));

        // Serializamos a fichero
        final String OUTPUT_FILE_PATH = "ficheros/student.json";

        File ficheroSalida = new File(OUTPUT_FILE_PATH);
        try (PrintWriter escritor = new PrintWriter(ficheroSalida)) {
            if (!ficheroSalida.exists() && ficheroSalida.createNewFile()) {
                System.out.printf("Fichero [%s] creado\n", OUTPUT_FILE_PATH);
            }

            gson.toJson(student, escritor);
        } catch (Exception e) {
            System.out.println("Excepción. Mensaje: " + e.getMessage());
        }
    }

    public static Student datoPrueba() {
        // crear asignaturas
        List<Asignatura> asignaturas = List.of(
                Asignatura.builder().nombre("Mates").nota(9.22).build(),
                Asignatura.builder().nombre("Castellano").nota(8.22).build(),
                Asignatura.builder().nombre("Química").nota(9.22).build(),
                Asignatura.builder().nombre("Catalán").nota(8.55).build());

        // Crear alumno
        return Student.builder().
                dni("12345678K").
                nombre("Eduardo").
                curso("2022-2023").
                media(Student.calcularMedia(asignaturas)).
                fechaNacimiento(LocalDate.now().minusYears(20)).
                asignaturas(asignaturas).
                build();
    }
}
