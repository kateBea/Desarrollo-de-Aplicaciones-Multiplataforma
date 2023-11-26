package org.dam2.hibernate;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.dam2.utilidadeshibernate.GenericJPADAO;

import lombok.var;

public class AppDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO <Alumno,Integer> alumnoDAO ;
		List<Alumno> alumnos;
		final Function <Alumno,String> TOSTRING = Alumno::toString;
		final Consumer<String> MOSTRAR = System.out::println;
		final Runnable ERROR = () -> System.out.println("Error");
		
		
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
		
		alumnoDAO.save(alumno1).
				map(TOSTRING).
				ifPresentOrElse(MOSTRAR, ERROR);

		alumno2 = alumnoDAO.save(alumno2).orElseGet(Alumno::new);		
		System.out.println(alumno2);
		// buscar un alumno
		System.out.println("Buscando uno...");
		alumnoDAO.findById(1).
				map(TOSTRING).
				ifPresentOrElse(MOSTRAR, ERROR);
	
		
		// buscar todos los alumnos
		System.out.println("Buscando todos...");
		alumnoDAO.findAll().stream().
				map(TOSTRING).
				forEach(MOSTRAR);
		
		// Actualizar un alumno existente
		System.out.println("Actualizando existente...");
		alumno2.setFirstName("miguel antonio");
		alumnoDAO.update(alumno2).
				map(TOSTRING).
				ifPresentOrElse(MOSTRAR, ERROR);
		
		
		// Actualizar alumno no existente
		System.out.println("Actuanlizando no existente...");
		var alumno3 = Alumno.builder().
				id(14).
				firstName("rosa maria").
				fecha(LocalDate.now().minusWeeks(1)).
				build();
		
		alumnoDAO.update(alumno3).
				map(TOSTRING).
				ifPresentOrElse(MOSTRAR, ERROR);
		
		
		
		alumnoDAO.findAll().stream().
					map(TOSTRING).
					forEach(MOSTRAR);
		
		//Borrar un alumno
		System.out.println("Borrando...");
		alumno3.setId(3);
		if (alumnoDAO.delete(alumno3).isPresent())
			System.out.println("Borrado correctamente");
		else
			System.out.println("No se ha podido borrar");
		
			
		System.out.println("Listando...");
		alumnoDAO.findAll().forEach(System.out::println);
		
	}

}
