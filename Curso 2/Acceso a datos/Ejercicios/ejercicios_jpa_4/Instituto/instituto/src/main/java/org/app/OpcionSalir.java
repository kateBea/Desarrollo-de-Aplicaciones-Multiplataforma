package org.app;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class OpcionSalir extends OpcionMenu {

	@Override
	public void accion() {
		System.out.println("Saliendo de la aplicaciñon...");
		
	}
	
}
