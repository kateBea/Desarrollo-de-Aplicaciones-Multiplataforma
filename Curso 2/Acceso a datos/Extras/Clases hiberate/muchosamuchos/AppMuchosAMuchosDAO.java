package org.dam2.muchosamuchos;

import java.util.HashSet;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppMuchosAMuchosDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericJPADAO<Libro,Integer> libroDAO;
		String PERSISTENCE_UNIT = "muchosamuchos";
		
		libroDAO = new GenericJPADAO<>(Libro.class, PERSISTENCE_UNIT);
		
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
						autore(autor1).
						autore(autor2).
						build();
			
			Libro libro2 = Libro.builder().
						name("Una mañana de verano").
						autores(autores).
						build();
					
			System.out.println(libro1);
			System.out.println(libro2);
				
			// Guardar Libros
			System.out.println("Insertando libro 1");
			libroDAO.save(libro1);
			System.out.println("Insertando libro 2");
			libroDAO.save(libro2);
			
			System.out.println("Buscando libros");
			libroDAO.findAll().forEach(System.out::println);
			
			
			

	}

}
