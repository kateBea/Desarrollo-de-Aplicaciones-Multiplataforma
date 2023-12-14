package org.repositorio;

import org.utilidades_hibernate.GenericJPADAO;

public class Queries implements Runnable {
	private GenericJPADAO<Empleado, Integer> daoEmpleados;
	private GenericJPADAO<Departamento, Integer> daoDepartamentos;

	public Queries(GenericJPADAO<Empleado, Integer> dao1, GenericJPADAO<Departamento, Integer> dao2) {
		this.daoEmpleados = dao1;
		this.daoDepartamentos = dao2;
	}
	
	@Override
	public void run() {
		// 1. Obtener los datos completos de los empleados.
		System.out.println("Query 1");
		daoEmpleados.executeQuery("SELECT e FROM Empleado e").forEach(System.out::println);
		
		// 2. Obtener los datos completos de los departamentos
		System.out.println("Query 2");
		daoDepartamentos.executeQuery("SELECT d FROM Departamento d").forEach(System.out::println);
		
	}

}
