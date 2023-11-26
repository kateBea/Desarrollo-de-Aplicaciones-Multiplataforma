package org.dam2.unoauno;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App1a1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String PERSISTENCE_UNIT = "unoauno";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = factory.createEntityManager();
        

        
        
        // guardar alumno
        Alumno alumno = Alumno.builder().
        					id(1).
        					firstName("ana").
        					fecha(LocalDate.now()).
        					build();
        
        Direccion d = Direccion.builder().
        		//id(1).      		
				calle("calle").
				numero(34).
				poblacion("poblacion").
				provincia("provincia").
				build();
        
        alumno.setDireccion(d);
        
        em.getTransaction().begin();
        em.persist(alumno);
        
        em.getTransaction().commit();
        

        // buscar alumno por clave
        Alumno  a1 = em.find(Alumno.class, 1);
        System.out.println(a1.getFirstName());

        em.detach(a1);
        System.out.println(a1.getDireccion());
        
        a1.getDireccion().setCalle("otra calle");
        em.merge(a1);
        
        Alumno  a2 = em.find(Alumno.class, 1);
        System.out.println(a2);
        
	}

}
