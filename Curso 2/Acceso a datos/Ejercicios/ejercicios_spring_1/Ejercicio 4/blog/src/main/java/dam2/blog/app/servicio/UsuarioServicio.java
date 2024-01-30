package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Usuario;

@Service
public interface UsuarioServicio {
	Optional<Usuario> buscarPorClave(String nick);
	Optional<Usuario> insertar(Usuario usuario);
	Optional<Usuario> actualizar(Usuario usuario);
	
	Set<Usuario> buscarTodos();
	
	boolean existePorClave(String nick);
	boolean borrarPorClave(String nick);
}
