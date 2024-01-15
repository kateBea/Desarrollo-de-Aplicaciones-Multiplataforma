package org.dam2.menu;

import java.util.List;

import org.dam2.examenjpa.Contexto;
import org.dam2.modelo.Perecedero;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Opcion3 extends OpcionMenu {

	@Override
	public void accion() {
		System.out.println("Subiendo precio de productos en un 10 %");
		
		List<Perecedero> perecederos = Contexto.getDaoPerec().findAll();
		
		for (Perecedero perecedero : perecederos) {
			perecedero.setPvp(perecedero.getPvp() * 1.10f);
		}
		
		for (Perecedero perecedero : perecederos) {
			Contexto.getDaoPerec().update(perecedero);
		}
		
	}

}
