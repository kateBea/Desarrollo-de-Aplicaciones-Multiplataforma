package dam2.blog.app.repositorio;

import org.springframework.data.repository.CrudRepository;

import dam2.blog.app.modelo.Noticia;

public interface NoticiaRepositorio extends CrudRepository<Noticia, String>{

}
