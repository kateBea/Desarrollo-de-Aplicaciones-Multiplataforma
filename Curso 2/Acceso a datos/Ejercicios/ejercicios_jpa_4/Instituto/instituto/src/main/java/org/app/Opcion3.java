package org.app;

import org.instituto.Persona;
import org.utilidades.Input;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion3 extends OpcionMenu {

	@Override
	public void accion() {
		// TODO Auto-generated method stub
		final String nif = Input.leerCadena("Introduce el nif de la persona");
		
		Persona fetchedPersona = null;
		
		
	}

}
