package org.app;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.instituto.Estudiante;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion5 extends OpcionMenu {@Override
	public void accion() {
		// Mostrar listado de los nombres ordenados por orden alfabético de todos los
		// alumnos menores de edad sin tutor asignado.
		final int MAYORIA_EDAD = 18;
		final Predicate<Estudiante> MENOR_EDAD = e -> 
			Period.between(e.getFechaNacimiento(), LocalDate.now()).getYears() > MAYORIA_EDAD;
			
		Stream<Estudiante> result = (Stream<Estudiante>) Contexto.getDaoEstudiante().
			executeQuery("SELECT e.nombre" 
						+ "FROM Estudiante e"
						+ "e.tutor IS NULL");
		
		result.filter(MENOR_EDAD).forEach(System.out::println); 
		
		// Listado de profesores que residen fuera de la población donde se encuentra el instituto.
		Contexto.getDaoProfesor().
		executeQuery("SELECT p" 
					+ "FROM Profesor p"
					+ "");
		
	}

}
