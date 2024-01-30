package dam2.blog.app.repositorio;

import org.springframework.data.repository.CrudRepository;

import dam2.blog.app.modelo.Comentario;

public interface ComentarioRepositorio extends CrudRepository<Comentario, Integer>{

}
