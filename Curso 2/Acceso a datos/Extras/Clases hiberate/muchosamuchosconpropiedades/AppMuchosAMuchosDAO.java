package org.dam2.muchosamuchosconpropiedades;

import java.util.HashSet;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppMuchosAMuchosDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericJPADAO<Libro,Integer> libroDAO;
		GenericJPADAO<LibroAutor,Integer> libroAutorDAO;
		GenericJPADAO<Autor,Integer> autorDAO;
		
		String PERSISTENCE_UNIT = "muchosamuchosconpropiedades";
		
		libroDAO = new GenericJPADAO<>(Libro.class, PERSISTENCE_UNIT);
		autorDAO = new GenericJPADAO<>(Autor.class, PERSISTENCE_UNIT);
		libroAutorDAO = new GenericJPADAO<>(LibroAutor.class, PERSISTENCE_UNIT);
		
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
			
			autorDAO.save(autor1);
			autorDAO.save(autor2);
			autorDAO.save(autor3);
			
	
			//Libros
			Libro libro1 = Libro.builder().
						name("El lago y el pato").
						build();
			
			Libro libro2 = Libro.builder().
						name("Una mañana de verano").
						build();
					
				
			// Guardar Libros
			System.out.println("Insertando libro 1");
			libro1 = libroDAO.save(libro1).orElseGet(Libro::new);
			System.out.println("Insertando libro 2");
			libro2 = libroDAO.save(libro2).orElseGet(Libro::new);
			
			LibroAutor la1 = LibroAutor.builder().
							id(1).
							autor(autor1).
							libro(libro1).
							ncapitulos(3).
							build();
			LibroAutor la2 = LibroAutor.builder().
					id(2).
					autor(autor2).
					libro(libro1).
					ncapitulos(7).
					build();
			
			libroAutorDAO.save(la1);
			libroAutorDAO.save(la2);

			libroAutorDAO.findAll().forEach(System.out::println);
			
			System.out.println("Voy a borrar un libro...");
			libroDAO.delete(libro1);
			
			
	}

}
