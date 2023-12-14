package org.repositorio;

import org.utilidades_hibernate.GenericJPADAO;

import java.util.List;

/**
 * Repositorios
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final String PERSISTENCE = "org.repositorio";
    	
    	final GenericJPADAO<Empleado, Integer> DAO_EMPLEADO = new GenericJPADAO<>(Empleado.class, PERSISTENCE);
    	final GenericJPADAO<Departamento, Integer> DAO_DEPARTAMENTO = new GenericJPADAO<>(Departamento.class, PERSISTENCE);
    	
    	System.out.println("DAOs creados");
    	
    	List<Departamento> departamentos = (List<Departamento>) DAO_DEPARTAMENTO.findAll();
    	List<Empleado> empleados = (List<Empleado>) DAO_EMPLEADO.findAll();
    	
    	System.out.println("Departamentos ------------");
    	for (Departamento dept : departamentos) {
    		System.out.println(dept);
    	}
    	
    	System.out.println("\nEmpleados ------------");
    	for (Empleado empl : empleados) {
    		System.out.println(empl);
    	}
    	
    	Queries queries = new Queries(DAO_EMPLEADO, DAO_DEPARTAMENTO);
    	queries.run();
    }
}
