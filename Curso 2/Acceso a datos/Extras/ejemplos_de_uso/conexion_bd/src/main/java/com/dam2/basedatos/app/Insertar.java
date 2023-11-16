package com.dam2.basedatos.app;

import com.dam2.basedatos.Service;
import com.dam2.basedatos.unidirecional1an.ControladorDepart;
import com.dam2.basedatos.unidirecional1an.DepartDAO;

public class Insertar implements Service {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ControladorDepart controladorDepart = new ControladorDepart();
		DepartDAO dao = new DepartDAO ();
		
		// Insertar Departamento
		controladorDepart.leerModelo();
		if (dao.save(controladorDepart.getModelo()) > 0)
			System.out.println("Departamento insertado correctamente");
		else
			System.out.println("Error insertando departamento");

	}

}
