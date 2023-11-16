package com.dam2.basedatos.unidirecional1an;

import daw.com.Teclado;

public class AppUsarDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartDAO dao = new DepartDAO();
		Depart depart;
		String deptno;
		
		
		// Mostrar todos los departamentos
		dao.findAll().forEach(System.out::println);
		
		// Mostrar un departamento
		deptno = Teclado.leerString("indicar codigo depto");
		
		dao.findById(deptno).ifPresent(System.out::println);
		
				
		// Insertar un departamento
		depart = new Depart ();
		depart.setDeptNo(Teclado.leerString("nº departamento"));
		depart.setDname(Teclado.leerString("Nombre"));
		depart.setLoc(Teclado.leerString("Localizado en: "));
		
		// Leer empleados
		
		
		
		if (dao.save(depart) > 0)
			System.out.println("Departamento insertado correctamente");
	}

}
