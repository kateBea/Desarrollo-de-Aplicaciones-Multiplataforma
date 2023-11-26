package org.dam2.unoauno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppUnoAUno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("hibernate");
		
		EntityManager em = emFactory.createEntityManager();
		
		Direccion d = new Direccion (1,"calle", 110, "población", "provincia" );
		
		Profesor p = new Profesor (1, "Miguel", "Sutil", "Martín");
		
		p.setDireccion(d);
		
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		
		em.detach(p); // sacar p del em
		
		Profesor nuevo = em.find(Profesor.class,p.getId());
		
		//System.out.println(nuevo.getNombre());
		
		//System.out.println(nuevo.getDireccion().getCalle());
		
		em.detach(nuevo);
		
		//System.out.println(nuevo);
		//System.out.println(nuevo.getNombre());
		
		//System.out.println(nuevo.getDireccion());
		
		
		em.close();

	}

}
