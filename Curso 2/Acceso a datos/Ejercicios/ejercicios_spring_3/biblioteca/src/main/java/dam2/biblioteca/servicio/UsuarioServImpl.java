package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Usuario;
import dam2.biblioteca.repositorio.IPrestamoRepo;
import dam2.biblioteca.repositorio.IUsuarioRepo;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServImpl implements IUsuarioServ {
	
	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@Autowired
	IPrestamoRepo prestamoRepo;

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
	@Transactional
	public Optional<Usuario> insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		// Las sanciones del usuario ya se añaden porque
		// utilizamos el cascade ALL. Al utilizar cascade.ALL
		// en Usuario respecto Sancion, necesitamos que este
		// servicio sea Transactional, lo mismo aplica a modificaciones
		
		return Optional.of(usuarioRepo.save(usuario));
	}

	@Override
	@Transactional
	public Optional<Usuario> modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		return Optional.of(usuarioRepo.save(usuario));
	}

	@Override
	@Transactional
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		usuarioRepo.deleteById(id);
		
		// Las sanciones del usuario ya se borran porque
		// utilizamos el cascade ALL
		
		// Borramos todos sus préstamos, el enunciado no especifica
		prestamoRepo.deletePrestamosFromUser(id);
		
		return existePorId(id);
	}

	@Override
	public Set<Usuario> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(usuarioRepo.findAll().spliterator(), false).
			collect(Collectors.toSet());
	}

}
