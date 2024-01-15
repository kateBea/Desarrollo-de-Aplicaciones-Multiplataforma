package org.dam2.menu;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class OpcionSalir extends OpcionMenu {

	@Override
	public void accion() {
		System.out.println("Saliendo");
		
	}

}
