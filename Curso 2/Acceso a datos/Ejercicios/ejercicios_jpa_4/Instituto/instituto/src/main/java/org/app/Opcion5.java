package org.app;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.instituto.Estudiante;
import org.instituto.Profesor;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion5 extends OpcionMenu {@Override
	public void accion() {
		System.out.println("Query 1\n");
		// Mostrar listado de los nombres ordenados por orden alfabético de todos los
		// alumnos menores de edad sin tutor asignado.
		final int MAYORIA_EDAD = 18;
		final Predicate<Estudiante> MENOR_EDAD = e -> 
			Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears() > MAYORIA_EDAD;
			
		
		Set<Estudiante> estudiantesConTutor = Contexto.getDaoProfesor().findAll().stream()
			.flatMap(profe -> profe.getEstudiantes().stream())
			.collect(Collectors.toSet());
		
		Set<Estudiante> todosEstudiantes = Contexto.getDaoEstudiante().findAll().stream()
			.collect(Collectors.toSet());
		
		// borramos de todosEstudiantes los estudiantes de estudiantesConTutor (quitamos del total los que tienen tutor)
		if (todosEstudiantes.removeAll(estudiantesConTutor)) {
			todosEstudiantes.stream()
				.filter(MENOR_EDAD)
				.forEach(System.out::println);
		}
		
		
		System.out.println("Query 2\n");
		// Listado de profesores que residen fuera de la población donde se encuentra el instituto.
		Contexto.getDaoProfesor().
		executeQuery("SELECT p\n" 
					+ "FROM Instituto i JOIN i.integrantes p\n"
					+ "WHERE TYPE(p) = Profesor AND p.poblacion <> i.direccion.poblacion").
			forEach(System.out::println);
		
	}

}
