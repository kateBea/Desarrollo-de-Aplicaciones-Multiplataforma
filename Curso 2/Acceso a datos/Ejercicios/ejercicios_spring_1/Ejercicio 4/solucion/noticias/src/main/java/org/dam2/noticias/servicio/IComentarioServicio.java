package org.dam2.noticias.servicio;



import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.Comentario;



public interface IComentarioServicio {

	public Comentario insertar (Comentario comentario);
	public Optional<Comentario> findById (Long id);
	public List<Comentario> findByNoticia (String titulo);
	public List<Comentario> findAll ();
	public boolean update (Comentario Comentario);
	public boolean delete (Long id);
	
}
