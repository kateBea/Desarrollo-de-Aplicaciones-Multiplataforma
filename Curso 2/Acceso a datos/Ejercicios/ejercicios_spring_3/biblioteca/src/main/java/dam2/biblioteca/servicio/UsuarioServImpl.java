package dam2.biblioteca.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Usuario;
import dam2.biblioteca.repositorio.IUsuarioRepo;

@Service
public class UsuarioServImpl implements IUsuarioServ {
	
	@Autowired
	IUsuarioRepo usuarioRepo;

	@Override
	public Optional<Usuario> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return usuarioRepo.existsById(id);
	}

	@Override
	public Optional<Usuario> insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.of(usuarioRepo.save(usuario));
	}

	@Override
	public Optional<Usuario> modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.of(usuarioRepo.save(usuario));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		usuarioRepo.deleteById(id);
		
		return existePorId(id);
	}

}
