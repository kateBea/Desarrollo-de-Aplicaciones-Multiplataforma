package org.dam2.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App1a1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
        EntityManager em = factory.createEntityManager();
        

        // guardar alumno
        Alumno alumno = new Alumno();
        alumno.setFirstName("ana");
        
        Direccion d = new Direccion (10,"calle", 34, "poblacion", "provincia");
        
        //alumno.setDireccion(d);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        

        // buscar alumno por clave
        Alumno  a1 = em.find(Alumno.class, 1);
        System.out.println(a1);

        em.detach(a1);
        
        //a1.getDireccion().setCalle("otra calle");
        //em.merge(a1);
        
        Alumno  a2 = em.find(Alumno.class, 1);
        System.out.println(a2);
	}

}
