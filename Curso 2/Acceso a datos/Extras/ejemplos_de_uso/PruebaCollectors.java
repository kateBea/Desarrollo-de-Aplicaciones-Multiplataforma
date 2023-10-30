package ejemplos_de_uso;

import static java.util.stream.Collectors.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class PruebaCollectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Alumno> alumnos;
		
		alumnos = EjercicioLambdas.cargarAlumnos();
		
		
		System.out.println("lista");
		alumnos.stream().collect(toList()).forEach(System.out::println);
		
		System.out.println("set");
		alumnos.stream().collect(toSet()).forEach(System.out::println);

		System.out.println("Map");
		alumnos.stream().collect(toMap(Alumno::getNia,Alumno::getNombre))
					.forEach((nia, nombre) -> System.out.println(nia + " -> " + nombre));
		
		
		// Contar
		System.out.println("Contar");
		
		System.out.println(alumnos.stream().collect(counting()).longValue());
		
		// unir
		System.out.println("Unir");
		System.out.println(
					alumnos.stream().map(Alumno::getNombre).collect(joining(", ")));
		
		// Mapping
		System.out.println("Mapping");
		System.out.println(
				alumnos.stream().collect(mapping(Alumno::getNota,toList()))
				);		
		
		// Agrupar
		
		System.out.println("agrupar por curso");
		System.out.println(
				alumnos.stream().collect(groupingBy(Alumno::getCurso))
						);
		
		// Agrupar y Mapping
		System.out.println("agrupar y mapping");
		System.out.println(
				alumnos.stream().collect(groupingBy(
											Alumno::getCurso,
											mapping(Alumno::getNombre,toList()))));
		
		// Agrupar y contar
				System.out.println("agrupar y contar");
				System.out.println(
						alumnos.stream().collect(groupingBy(
													Alumno::getCurso,
													counting())));
				
						
		}

}
