package org.dam2.consultas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;


public class AppConsultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("consultas");
		EntityManager em = emFactory.createEntityManager();
		
		//Profe profesor=new Profe(7, "Sara", "Barrrera", "Salas");
        
		
		Set<CorreoElectronico> correosElectronicos=new HashSet<>();
        
        correosElectronicos.add(new CorreoElectronico(3, "sara@yahoo.com"));
        correosElectronicos.add(new CorreoElectronico(2, "sara@hotmail.com"));
        correosElectronicos.add(new CorreoElectronico(1, "sara@gmail.com"));
        
        Profe profesor = Profe.builder().
        					id(7).
        					nombre("Sara").
        					ape1("Barrera").
        					ape2("Salas").
        					correosElectronicos(correosElectronicos).
        					build();
        
        
        
        em.getTransaction().begin();
        em.persist(profesor);
        em.getTransaction().commit();
        
        em.clear();
        
        System.out.println("Un profe");
        System.out.println("----------------------");
        Profe p = em.createQuery("SELECT p FROM Profe p WHERE id=7",Profe.class)
        								.getSingleResult(); 
        System.out.println("Profesor con Id 7=" + p.getNombre());
        
        
        
        
        System.out.println("Todos los profesores");
        System.out.println("----------------------");
        Query query = em.createQuery("SELECT p FROM Profe p");
        /*List<Profe> profesores = query.getResultList();
        for (Profe profe : profesores) 
            System.out.println(profe.toString()); 
        */
        query.getResultStream().forEach(System.out::println);
        
        System.out.println("Todos los correoElectronicos");
        System.out.println("----------------------");
        Query query1 = em.createQuery("SELECT c FROM CorreoElectronico c");
        List<CorreoElectronico> emails = query1.getResultList();
        for (CorreoElectronico correo : emails) 
            System.out.println(correo.toString()); 
        
        
        
        System.out.println("Cada profe con todos los correoElectronicos");
        System.out.println("----------------------");
        Query query2 = em.createQuery("SELECT p.id,correos FROM Profe p inner join p.correosElectronicos as correos");
        List<Object[]> listDatos = query2.getResultList();
        for (Object[] datos : listDatos) 
            System.out.println(datos[0] + "--" + datos[1]);
        

        /*
        System.out.println("Cada profe con todos los correoElectronicos usando tuplas");
        System.out.println("----------------------");
        Query query3 = em.createQuery("SELECT p.id as claveProfe,correos as emilios "
        		+ "FROM Profe p inner join p.correosElectronicos as correos",
        		Tuple.class);
  
        List<Tuple> tuplas = query3.getResultList();
        for (Tuple tuple : tuplas) 
            System.out.println(tuple.get("claveProfe") + "--" + tuple.get("emilios"));
         */

        
        
        System.out.println("correoElectronicos  con parámetros");
        System.out.println("----------------------");
        /*
        Query query4 = em.createQuery("SELECT c FROM CorreoElectronico c "
        		+ "WHERE c.direccionCorreo LIKE :direccion");
        query4.setParameter("direccion", "%yahoo%" );
        */
        Query query4 = em.createQuery("SELECT c FROM CorreoElectronico c "
        		+ "WHERE c.direccionCorreo LIKE ?1");
        query4.setParameter(1, "%yahoo%" );
        
        List<CorreoElectronico> yahoos = query4.getResultList();
        for (CorreoElectronico correo : yahoos) 
            System.out.println(correo.toString()); 
        
        
        System.out.println("consulta con nombre");
        System.out.println("----------------------");
        em.createNamedQuery("findAllProfesores").getResultList().forEach(System.out::println);
        
       
	}

}
