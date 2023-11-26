package org.dam2.clavecompuesta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppClaveCompuesta {
	  public static void main(String[] args) {
		    
		    //Curso c= new Curso("Java","Programacion",20,1);
		    
		    GenericJPADAO<Curso, CursoPK> cursoDAO = new GenericJPADAO<>(Curso.class, "clavecompuesta");
		    
		    CursoPK cursoPK = CursoPK.builder().
							titulo("Java").
							nivel(1).
							build();
		    
		    Curso c = Curso.builder().
		    					cursoPK(cursoPK).
		    					categoria("Programación").
		    					horas(20).
		    					build();
		    					
		    cursoDAO.save(c);
		   
		    cursoDAO.findById(cursoPK).ifPresent(System.out::println);
		    
  
		  }
}
