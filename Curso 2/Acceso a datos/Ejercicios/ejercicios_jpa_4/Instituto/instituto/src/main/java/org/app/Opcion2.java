package org.app;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.instituto.Estudiante;
import org.instituto.Persona;
import org.instituto.Profesor;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion2 extends OpcionMenu{
	
	@Override
	public void accion() {
		final String nif = Input.leerCadena("Introduce el NIF del profesor: ");
		
		Optional<Profesor> result = Contexto.getDaoProfesor().findById(nif);
		
		if (result.isEmpty()) {
			System.err.println("El profesor con NIF " + nif + " no existe.");
			return;
		}
		
		Set<Estudiante> estudiantesProfesor = result.get().getEstudiantes();
		
		// Un profesor solo puede estar en un instituto
		List<Persona> integrantes = Contexto.getDaoInstituto().findAll().stream()
			.filter(insti -> insti.getIntegrantes().contains(result.get()))
			.flatMap(insti -> insti.getIntegrantes().stream())
			.toList();

			
		// Recogemos todos los profes del mismo instituto que el profesor a eliminar
		List<Profesor> profesores = integrantes.stream()
			.filter(pers -> pers instanceof Profesor)
			.map(pers -> (Profesor) pers)
			.toList();
		
		// Eliminamos el profesor a borrar de la lista "profesores"
		// Ya que hemos recogido los integrantes del instituto al completo.
		profesores.remove(result.get());
		
		// si la lista está vacía no hace falta recorrer los alumnos a intentar asignarles profes
		if (!profesores.isEmpty()) {
			int indiceProfeActual = 0;
			for (Estudiante estudiante : estudiantesProfesor) {
				// Si no se puede asignar más estudiantes al profe actual avanzamos
				// IMPORTANTE: Tenemos que asignar los alumnos a profes del mismo instituto
				if (!profesores.get(indiceProfeActual).addEstudiante(estudiante)) {
					indiceProfeActual++;
				}
			}
		}
		
		// Serializar a la base de datos
		for (Profesor profesor : profesores) {
			Contexto.getDaoProfesor().update(profesor);
		}
	}

}
