package dam2.blog.app.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dam2.blog.app.modelo.Comentario;


public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer>{
	
	@Query("SELECT c FROM Comentario c WHERE c.autor = :userNick")
	Set<Comentario> findUserCommentsById(@Param("userNick") String nick);
}
