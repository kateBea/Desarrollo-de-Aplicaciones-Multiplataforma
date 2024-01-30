package dam2.blog.app.repositorio;

import org.springframework.data.repository.CrudRepository;

import dam2.blog.app.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

}
