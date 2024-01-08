package org.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class OpcionMenu {
	private String descripcion;
	
	
	/**
	 * Acción a ejecutar para esta opción de menú
	 * */
	public abstract void accion();
}
