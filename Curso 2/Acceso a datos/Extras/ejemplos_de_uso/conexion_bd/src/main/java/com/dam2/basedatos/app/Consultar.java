package com.dam2.basedatos.app;

import java.util.function.Consumer;

import com.dam2.basedatos.Service;
import com.dam2.basedatos.unidirecional1an.ControladorDepart;
import com.dam2.basedatos.unidirecional1an.Depart;
import com.dam2.basedatos.unidirecional1an.DepartDAO;
import com.dam2.basedatos.unidirecional1an.VistaDepart;

public class Consultar implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		ControladorDepart controladorDepart = new ControladorDepart();
		DepartDAO dao = new DepartDAO ();

		// Función para mostrar un deparamento
		Consumer<Depart> mostrarDepart = d -> new VistaDepart (d).mostrarModelo();
		
		// Buscar y mostrar un departamento
		controladorDepart.leerClaveModelo();
		dao.findById(controladorDepart.getModelo().getDeptNo()).ifPresent(mostrarDepart);
	}

}
