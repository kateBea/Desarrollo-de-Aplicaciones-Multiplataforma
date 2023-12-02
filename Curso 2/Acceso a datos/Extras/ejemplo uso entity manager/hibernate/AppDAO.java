package org.dam2.hibernate;

import java.time.LocalDate;
import java.util.List;

import org.dam2.utilidadeshibernate.GenericJPADAO;

import lombok.var;

public class AppDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO <Alumno,Integer> alumnoDAO ;
		List<Alumno> alumnos;
		
		
		alumnoDAO = new GenericJPADAO (Alumno.class,"hibernate");
		
		// Insertar alumnos
		var alumno1 = Alumno.builder().
					firstName("miguel").
					fecha(LocalDate.now()).
					build();

		var alumno2 = Alumno.builder().
				firstName("rosa").
				fecha(LocalDate.now().minusWeeks(6)).
				build();
		
		System.out.println("Insertando...");
		alumno1 = alumnoDAO.save(alumno1);
		alumno2 = alumnoDAO.save(alumno2);
		System.out.println(alumno1);
		System.out.println(alumno2);
		
		// buscar un alumno
		System.out.println("Buscando uno...");
		var alumnoOptional = alumnoDAO.findById(1);
		System.out.println(alumnoOptional);
		
	
		
		// buscar todos los alumnos
		System.out.println("Buscando todos...");
		alumnoDAO.findAll().forEach(System.out::println);
		
		// Actualizar un alumno existente
		System.out.println("Actualizando existente...");
		alumno2.setFirstName("miguel antonio");
		alumno2 = alumnoDAO.update(alumno2);
		System.out.println(alumno2);
		
		// Actualizar alumno no existente
		System.out.println("Actuanlizando no existente...");
		var alumno3 = Alumno.builder().
				id(14).
				firstName("rosa maria").
				fecha(LocalDate.now().minusWeeks(1)).
				build();
		
		alumno3 = alumnoDAO.update(alumno3);
		System.out.println(alumno3);
		
		alumnoDAO.findAll().forEach(System.out::println);
		
		//Borrar un alumno
		System.out.println("Borrando...");
		alumno3 = alumnoDAO.delete(alumno3);
		
		if (alumno3 != null)
			System.out.println("Borrado correctamente");
		else
			System.out.println("No se ha podido borrar");
		
		
		System.out.println("Listando...");
		alumnoDAO.findAll().forEach(System.out::println);
		
	}

}
