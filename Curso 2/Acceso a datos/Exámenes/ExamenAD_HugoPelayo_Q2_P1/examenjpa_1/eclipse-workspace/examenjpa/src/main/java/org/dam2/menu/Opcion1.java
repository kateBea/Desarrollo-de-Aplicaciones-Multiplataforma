package org.dam2.menu;

import org.dam2.examenjpa.Contexto;
import org.dam2.modelo.Producto;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion1 extends OpcionMenu {
	
	@Override
	public void accion() {
		Producto producto = Lectura.leerProducto();
		
		if (producto != null) {
			Contexto.getDaoProducto().save(producto);
		} else {
			System.err.println("Error al leer el producto");
		}
		
	}

}
