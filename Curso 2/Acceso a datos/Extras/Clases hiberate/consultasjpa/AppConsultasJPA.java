package org.dam2.consultasjpa;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppConsultasJPA {
	public static final String UNIDADPERSISTENCIA = "consultasjpa";
	
	private GenericJPADAO<Depart,String> departDAO;
	private GenericJPADAO<Emple,String> empleDAO;
	
	
	public AppConsultasJPA ()
	{
		departDAO = new GenericJPADAO<Depart, String>(Depart.class,UNIDADPERSISTENCIA);
		empleDAO = new GenericJPADAO<Emple, String>(Emple.class,UNIDADPERSISTENCIA);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String query;
		Stream <Object[]> resultado;
		Optional<Object[]> resultadoUnico;
		Consumer<Object[]> imprimirResultado = o -> 
					System.out.println(Arrays.stream(o).reduce((o1,o2) -> o1+","+o2).get());
		Consumer<Object> mostrarUnaColumna = o -> System.out.println(o);
		Runnable sindatos = () -> System.out.println("sin datos");
		
		
		AppConsultasJPA app = new AppConsultasJPA ();
		
		/*
		System.out.println("Todos los departamentos");
		app.departDAO.findAll().forEach(System.out::println);
		*/
		
		// 3
		/*
		query = "SELECT e FROM Emple e WHERE e.cargoE=?1";
		app.empleDAO.executeQuery(query, "Secretaria").forEach(mostrarUnaColumna);
		*/
		/*
		query = "SELECT e.nomemp, e.cargoE FROM Emple e ORDER BY e.salEmp DESC";
		app.empleDAO.executeQuery(query).forEach(imprimirResultado);
		
		query = "SELECT DISTINCT e.salEmp FROM Emple e";
		app.empleDAO.executeQuery(query).forEach(mostrarUnaColumna);
		*/
		
		/*
		query = "SELECT d.nombreDepto FROM Depart d WHERE d.nombreDepto NOT IN ('VENTAS', 'INVESTIGACIÓN','MANTENIMIENTO') ORDER BY d.ciudad";
		app.departDAO.executeQuery(query).forEach(mostrarUnaColumna);
		*/
		/*
		query = "SELECT MAX(e.salEmp) FROM Emple e";
		app.empleDAO.executeQuerySingleResult(query).ifPresentOrElse(mostrarUnaColumna, sindatos);
		*/
		/*
		System.out.println("Todos los empleados");
		app.empleDAO.findAll().forEach(System.out::println);
		*/
		
		//Query 50
		/*System.out.println("Query 50");
		query = "SELECT d.codDepto FROM Depart d WHERE d.codDepto IN (SELECT DISTINCT e.depto.codDepto FROM Emple e)";
		app.departDAO.executeQuery(query).forEach(System.out::println);
		*/
		
		// Query 52
		/*
		System.out.println("Query 52");
		query = "SELECT SUM (e.salEmp), e.depto.codDepto FROM Emple e GROUP by e.depto ORDER by SUM(e.salEmp) DESC";
		resultadoUnico = app.empleDAO.executeQuerySingleResult(query);
		resultadoUnico.ifPresent(imprimirResultado);
		*/
		
		/*
		// Query 53
		System.out.println("Query 53");
		query = "SELECT j.nidemp, j.nomemp, COUNT(e) FROM Emple e JOIN e.jefe j GROUP BY j";
		resultado = app.empleDAO.executeQuery(query);
		resultado.forEach(imprimirResultado);
		*/

		System.out.println("Query 24");
		query ="SELECT e.nomemp FROM Emple e WHERE e.nomemp like '[PQRS]%'";
		app.empleDAO.executeQuery(query).forEach(System.out::println);
		
		
	}

}
