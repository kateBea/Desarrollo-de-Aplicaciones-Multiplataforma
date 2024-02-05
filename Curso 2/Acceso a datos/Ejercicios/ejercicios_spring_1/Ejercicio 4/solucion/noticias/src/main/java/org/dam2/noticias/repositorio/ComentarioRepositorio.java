package org.dam2.noticias.repositorio;

import java.util.List;
import java.util.Optional;

import org.dam2.noticias.modelo.Comentario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepositorio extends CrudRepository<Comentario, Long> {
	@Query ("SELECT c FROM Comentario c WHERE c.noticia.titulo = ?1")
	List<Comentario> findByTituloNoticia (String titulo);
	
	
	
	@Query ("SELECT c.noticia.titulo FROM Comentario c GROUP BY c.noticia HAVING COUNT(c.id)>="  
			+ "ALL(SELECT COUNT(c) FROM Comentario c GROUP BY c.noticia)")
	
	
	
	//@Query ("SELECT c.noticia.titulo FROM Comentario c GROUP BY c.noticia ORDER BY COUNT(c.id) DESC ")
	Optional<String> buscarNoticiaConMasComentarios ();

	
}
