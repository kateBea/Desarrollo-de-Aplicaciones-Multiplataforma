package org.dam2.menu;

import java.util.List;

import org.dam2.examenjpa.Contexto;
import org.dam2.modelo.Perecedero;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion4 extends OpcionMenu {
	@Override
	public void accion() {
		// TODO Auto-generated method stub
		
		// a)
		List<Perecedero> perecederos = Contexto.getDaoPerec().findAll();
		
		float suma = 0.0f;
		
		for (Perecedero perecedero :perecederos) {
			if (perecedero.estaCaducado()) {
				suma += perecedero.getStock() * perecedero.getPvp();
			}
		}
		
		System.out.println("Dinero perdido por los perecedoros caducados: " + suma);
		
		// b)
		Contexto.getDaoProveedor()
		.executeQuery("SELECT p.proveedor\n"
				+ "FROM Producto\n"
				+ "GROUP BY p.proveedor");
		
	}

}
