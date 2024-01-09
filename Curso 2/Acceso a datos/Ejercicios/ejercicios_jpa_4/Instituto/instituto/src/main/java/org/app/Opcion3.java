package org.app;

import java.util.Optional;

import org.instituto.Email;
import org.instituto.Estudiante;
import org.instituto.Persona;
import org.instituto.Profesor;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion3 extends OpcionMenu {

	@Override
	public void accion() {
		// TODO Auto-generated method stub
		final String nif = Input.leerCadena("Introduce el nif de la persona");
		
		Optional<Persona> fetchedPersona = Contexto.getDaoPersona().findById(nif);
	
		if (fetchedPersona.isEmpty()) {
			System.err.println("La persona con NIF " + nif + " no existe.");
			return;
		}
		
		String tipo = null;
		
		if (fetchedPersona.get() instanceof Profesor) {
			tipo = "Profesor";
		} else if (fetchedPersona.get() instanceof Estudiante) {
			tipo = "Estudiante";
		}
		
		System.out.printf("Mostrando todos los emails de %s con NIF %s\n", tipo, nif);
		for (Email email : fetchedPersona.get().getEmails()) {
			System.out.println(email);
		}
	}

}
