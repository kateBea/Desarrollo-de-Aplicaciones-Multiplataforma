package dam2.blog.app.servicio;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.blog.app.modelo.Usuario;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Override
	public Optional<Usuario> buscarPorClave(String nick) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Usuario> actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Set<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existePorClave(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarPorClave(String nick) {
		// TODO Auto-generated method stub
		return false;
	}

}
