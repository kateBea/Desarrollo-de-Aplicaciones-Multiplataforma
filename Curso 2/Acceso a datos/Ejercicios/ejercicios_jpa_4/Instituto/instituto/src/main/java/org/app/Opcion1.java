package org.app;

import org.instituto.Instituto;
import org.utilidades.LecturaConsola;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion1 extends OpcionMenu {

	@Override
	public void accion() {
		// Leer instituto
		Instituto instituto = LecturaConsola.leerInstituto();
		
		if (instituto != null) {
			Contexto.getDaoInstituto().save(instituto);
		}
	}

}
