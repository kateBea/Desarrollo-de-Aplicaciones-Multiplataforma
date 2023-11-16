package com.dam2.basedatos.unidirecional1an;

import java.util.List;
import java.util.function.Consumer;

public class AppMVCDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorDepart controladorDepart = new ControladorDepart();
		DepartDAO dao = new DepartDAO ();
		
		
		
		// Función para mostrar un deparamento
		Consumer<Depart> mostrarDepart = d -> new VistaDepart (d).mostrarModelo();
		
		//Buscar y mostrar todos los Departamentos y Empleados
		dao.findAll().forEach(mostrarDepart);
		

		// Insertar Departamento
		controladorDepart.leerModelo();
		dao.save(controladorDepart.getModelo());
		
		
		// Buscar y mostrar un departamento
		controladorDepart.setModelo(new Depart()); // Inicializar modelo controlador
		controladorDepart.leerClaveModelo();
		dao.findById(controladorDepart.getModelo().getDeptNo()).ifPresent(mostrarDepart);
		
	}

}
