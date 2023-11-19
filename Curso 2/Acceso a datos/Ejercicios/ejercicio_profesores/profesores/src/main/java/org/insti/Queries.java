package org.insti;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Queries {
    private static Instituto instituto;

    public static void initContext(Instituto insti) {
        instituto = insti;
    }

    /**
     * ¿Cuántos profesores hay en el departamento de "Matemáticas"?
     * */
    public static class Query1_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 1.1:\n");
            final String DEPARTAMENTO = "Matemáticas";

            System.out.printf("Departamento %s tiene %d profesores", DEPARTAMENTO, instituto.getProfesores().stream().
                    filter(profesor -> profesor.getMateria().equalsIgnoreCase(DEPARTAMENTO)).
                    count());
        }
    }

    /**
     * ¿Cuál es el promedio de edad de los profesores del departamento de "Química"?
     * */
    public static class Query1_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 1.2:\n");
            final String DEPARTAMENTO = "Química";

            System.out.printf("Edad media en departamento %s es %.2f", DEPARTAMENTO, instituto.getProfesores().stream().
                    filter(profesor -> profesor.getMateria().equalsIgnoreCase(DEPARTAMENTO)).
                    mapToInt(Profesor::getEdad).average().orElse(-1));
        }
    }

    /**
     * ¿Quiénes son los profesores que enseñan "Historia"?
     * */
    public static class Query2_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 2.1:\n");
            final String FILTRO = "Historia";

            System.out.println("Profesores de historia: " + instituto.getProfesores().stream().
                    filter(profesor -> profesor.getCursos().stream().
                            anyMatch(curso -> curso.getNombre().contains(FILTRO))).
                    map(Profesor::getNombre).
                    toList());
        }
    }

    /**
     * ¿Cuántos profesores enseñan "Idiomas"?
     * */
    public static class Query2_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 2.2:\n");
            final String DEPARTAMENTO = "Idiomas";

            System.out.printf("%d profesor (es) enseñas idiomas", instituto.getProfesores().stream()
                            .filter(profesor -> profesor.getMateria().equalsIgnoreCase(DEPARTAMENTO))
                            .count());
        }
    }

    /**
     * ¿Cuántos profesores hay en cada departamento?
     * */
    public static class Query3_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 3.1:\n");

            Map<String, Long> profesoresPorDepartamento = instituto.getProfesores().stream()
                    .collect(Collectors.groupingBy(Profesor::getMateria, Collectors.counting()));

            profesoresPorDepartamento.forEach((departamento, cantidad) ->
                    System.out.printf("Departamento %s tiene %d profesor(es)\n", departamento, cantidad));

        }
    }

    /**
     * ¿Cuál es el profesor más joven de cada departamento?
     * */
    public static class Query3_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 3.2:\n");

            Map<String, Optional<Profesor>> profesorMasJovenPorDepartamento = instituto.getProfesores().stream()
                    .collect(Collectors.groupingBy(Profesor::getMateria,
                            Collectors.minBy(Comparator.comparingInt(Profesor::getEdad))));

            profesorMasJovenPorDepartamento.forEach((departamento, profesorMasJoven) -> System.out.printf("En el departamento %s, el profesor más joven es: %s\n",
                    departamento,
                    profesorMasJoven.map(Profesor::getNombre).orElse("No hay profesores")));
        }
    }

    /**
     * ¿Cuántos cursos hay en total en el instituto?
     * */
    public static class Query4_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 4.1:\n");

            long total = Stream.of(instituto.getProfesores())
                    .flatMap(Collection::stream)
                    .flatMap(profesor -> profesor.getCursos().stream())
                    .distinct()
                    .count();

            System.out.println("Hay en total " + total + " cursos");

            Stream.of(instituto.getProfesores()).
                    flatMap(Collection::stream).flatMap(profesor -> profesor.getCursos().stream()).
                    distinct().
                    map(Curso::getNombre).
                    forEach(System.out::println);
        }
    }

    /**
     * ¿Cuál es el curso con más estudiantes?
     * */
    public static class Query4_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 4.2:\n");

            // Obtener estudiantes por curso
            Map<String, List<Estudiante>> estudiantesPorCurso = instituto.getProfesores().stream()
                    .flatMap(profesor -> profesor.getCursos().stream())
                    .collect(Collectors.groupingBy(Curso::getNombre,
                            Collectors.flatMapping(curso -> curso.getEstudiantes().stream(), Collectors.toList())));

            // Encontrar el curso con más estudiantes
            Map.Entry<String, List<Estudiante>> cursoConMasEstudiantes = estudiantesPorCurso.entrySet().stream()
                    .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                    .orElse(null);

            // Imprimir el resultado
            if (cursoConMasEstudiantes != null) {
                System.out.printf("El curso con más estudiantes es '%s' con %d estudiantes.%n",
                        cursoConMasEstudiantes.getKey(), cursoConMasEstudiantes.getValue().size());
            } else {
                System.out.println("No hay información sobre cursos y estudiantes.");
            }
        }
    }

    /**
     * ¿Cuántos estudiantes hay en el curso "Inglés Avanzado"?
     * */
    public static class Query5_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 5.1:\n");

            final String cursoBuscado = "Inglés Avanzado";

            long cantidadEstudiantes = instituto.getProfesores().stream()
                    .flatMap(profesor -> profesor.getCursos().stream())
                    .filter(curso -> curso.getNombre().equals(cursoBuscado))
                    .mapToLong(curso -> curso.getEstudiantes().size())
                    .sum();

            System.out.printf("En el curso \"%s\" hay %d estudiantes.%n", cursoBuscado, cantidadEstudiantes);
        }
    }

    /**
     * ¿Quiénes son los estudiantes que asisten al curso "Biología Celular"?
     * */
    public static class Query5_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("\nEjercicio 5.2:\n");

            final String cursoBuscado = "Biología Celular";

            instituto.getProfesores().stream()
                    .flatMap(profesor -> profesor.getCursos().stream())
                    .filter(curso -> curso.getNombre().equals(cursoBuscado))
                    .flatMap(curso -> curso.getEstudiantes().stream())
                    .forEach(System.out::println);
        }
    }
}
