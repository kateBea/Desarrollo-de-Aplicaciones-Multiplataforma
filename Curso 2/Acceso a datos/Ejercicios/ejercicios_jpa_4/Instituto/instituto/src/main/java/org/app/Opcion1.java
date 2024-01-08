package org.app;

import java.util.Optional;

import org.instituto.Profesor;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion1 extends OpcionMenu {

	@Override
	public void accion() {
		final String nif = Input.leerCadena("Introduce el NIF del profesor, por favor: ");
		Optional<Profesor> result = Contexto.getDaoProfesor().findById(nif);
		
		if (result.isEmpty()) {
			System.err.println("El profesor con NIF " + nif + " no existe.");
			return;
		}
		
		// Asignar primero sus alumnos a otros profes
		
	}

}
