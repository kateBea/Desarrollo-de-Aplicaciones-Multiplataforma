package org.dam2.muchosamuchos;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMuchosAMuchos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Autores
		Autor autor1 = Autor.builder().
							name("Juan Perez").
							id(1).
							build();
		
				
		Autor autor2 = Autor.builder().
				name("Oscar Blancarte").
				id(2).
				build();
		
		
		Autor autor3 = Autor.builder().
				name("Arturo Fernandez").
				id(3).
				build();
		
		HashSet<Autor> autores = new HashSet<>();
		autores.add(autor1);
		autores.add(autor2);
		autores.add(autor3);
		
	
		
		//Libros
		Libro libro1 = Libro.builder().
					name("El lago y el pato").
					autores(autores).
					build();
		
		Libro libro2 = Libro.builder().
					name("Una mañana de verano").
					autores(autores).
					build();
				
		System.out.println(libro1);
		System.out.println(libro2);
		
		
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("muchosamuchos");
		
		EntityManager em = emFactory.createEntityManager();
		
		System.out.println("insertando libro 1...");
		em.getTransaction().begin();
		libro1 = em.merge(libro1);
		em.getTransaction().commit();
		em.detach(libro1);
		
		

		
		
		System.out.println("insertando libro 2...");
		em.getTransaction().begin();
		libro2 = em.merge(libro2);
		em.getTransaction().commit();
		em.detach(libro2);
				
		
		
		
		
		System.out.println("consultado libro...");
		
		
		
		Libro libro = em.find(Libro.class, libro2.getId());
		
		em.close(); // No cerrar aquí si son perezosas las 2 relaciones
		
		System.out.println(libro.getName());
	
		//em.close(); // Ojo no cerrar aquí si es perezosa la relación libro-autores
		
		System.out.println(libro);
		
	
		//em.close(); // Ojo no cerrar aquí si es perezosa la relación autor-libros
		
		libro.getAutores().forEach(System.out::println);
	
		
		//em.close(); // Cerrar aquí cuando son perezosas las dos relaciones
		
		

	}

}
