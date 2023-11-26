package org.dam2.herenciatablaporclasehija;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.dam2.utilidadeshibernate.GenericJPADAO;



public class AppHerencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericJPADAO<Persona, Long> personaDAO;
		personaDAO = new GenericJPADAO<>(Persona.class, "herenciaporclasehija");
		
		Normal normal = Normal.builder().
				nombre("normal").
				edad(21).
				ocupacion("Empleado").
				build();

		Tecnologo tecnologo = Tecnologo.builder().
						nombre("Tecnologo").
						edad(24).
						aniosDeEstudios(4).
						build();
		
		Programador programador1 = Programador.builder().
						nombre("primer programador").
						edad(25).
						aniosDeEstudios(4).
						lenguajeFavorito("java").
						aniosDeExperiencia(4).
						build();
		
		Programador programador2 = Programador.builder().
			nombre("segundo programador").
			edad(35).
			aniosDeEstudios(5).
			lenguajeFavorito("php").
			aniosDeExperiencia(4).
			build();
		
		
		Tester tester = Tester.builder().
			nombre("tester").
			edad(18).
			aniosDeEstudios(3).
			herramientaDeTesteo("JUnit").
			build();
		
		personaDAO.save(normal);
		personaDAO.save(tecnologo);
		personaDAO.save(programador1);
		personaDAO.save(programador2);
		personaDAO.save(tester);
		
		
		personaDAO.findAll().forEach(System.out::println);
		
		personaDAO.findById(3L).ifPresent(System.out::println); 
	   
		//Mostrar los programadores
		GenericJPADAO<Programador, Long> programadorDAO;
		programadorDAO = new GenericJPADAO<>(Programador.class, "herenciaporclasehija");
		   
		programadorDAO.findAll().forEach(System.out::println);
		
		
		/*
	   // usando querys	
	   String query = "SELECT p FROM Persona p "
	    				+ "WHERE TYPE(p) = Programador";
	    
	   personaDAO.executeQuery(query).forEach(System.out::println);
		*/
	   
	}

}
