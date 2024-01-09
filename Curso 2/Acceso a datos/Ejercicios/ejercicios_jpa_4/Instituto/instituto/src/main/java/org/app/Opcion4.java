package org.app;

import java.time.LocalDate;
import java.util.Optional;

import org.instituto.Estudiante;
import org.instituto.Profesor;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion4 extends OpcionMenu {
	
	@Override
	public void accion() {
		final String nif = Input.leerCadena("Introduce NIF del profesor: ");
		
		Optional<Profesor> result = Contexto.getDaoProfesor().findById(nif);
		
		if (result.isEmpty()) {
			System.err.println("El profesor con NIF " + nif + " no existe.");
			return;
		}
		
		LocalDate fecha = null;
		try {
			fecha = LocalDate.parse(Input.leerCadena("Introduce fecha de tutoría (YYY-MM-DD): ")); 
			
			for (Estudiante estudiante : result.get().getEstudiantes()) {
				System.out.printf("% quedas convocado/a a la sesión de tutoría en el despacho %s en la fecha %s\n",
					estudiante.getNombre(), result.get().getDespacho(), fecha.toString());
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
	}
}
