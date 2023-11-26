package org.dam2.muchosamuchosconpropiedades;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class LibroListener {

	String PERSISTENCE_UNIT = "muchosamuchosconpropiedades";

	@PreRemove
	public void antesDeBorrarLibro (Libro libro)
	{
		GenericJPADAO<LibroAutor, Integer> libroAutorDAO;
		libroAutorDAO = new GenericJPADAO<>(LibroAutor.class, PERSISTENCE_UNIT);

		System.out.println("voy a borrar " + libro);
		// borrado en cascada
		libroAutorDAO.findAll().stream().
				filter(la -> la.getLibro().equals(libro)).
				forEach(la -> libroAutorDAO.delete(la));
		
		// borrado de puesta a nulos
		/*
		libroAutorDAO.findAll().stream().
		filter(la -> la.getLibro().equals(libro)).
		forEach(la -> {la.setLibro(null);libroAutorDAO.update(la);});
		*/

		
		
	}
}
