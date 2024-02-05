package org.dam2.noticias.repositorio;

import java.util.List;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends CrudRepository<Noticia, Long> {
	List<Noticia> findByTitulo (String titulo);
	
	
	long deleteByTitulo(String titulo);
	
	List<Noticia> findByRedactor(Usuario redactor);
	
	List<Noticia> findByCategoria (Categoria categoria);
	
	
	@Query ("SELECT n FROM Noticia n WHERE n.redactor.puntos = "
			+ "(SELECT MAX(usu.puntos) FROM Usuario usu)")
	List<Noticia> buscarNoticiasDelRedactorConMasPuntos();
	
	
	@Modifying
	@Query ("DELETE FROM Noticia WHERE id NOT IN"
			+ "(SELECT c.noticia.id FROM Comentario c GROUP BY c.noticia)")
	

	long deleteNoticiasSinComentarios ();
	
}
