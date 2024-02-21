package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Sancion;
import dam2.biblioteca.modelo.Usuario;
import dam2.biblioteca.repositorio.ISancionRepo;
import dam2.biblioteca.repositorio.IUsuarioRepo;

@Service
public class SancionServImpl implements ISancionServ {

	@Autowired
	ISancionRepo sancionRepo;
	
	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@Override
	public Optional<Sancion> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return sancionRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return sancionRepo.existsById(id);
	}

	@Override
	public Optional<Sancion> insertar(Sancion sancion) {
		// TODO Auto-generated method stub
		return Optional.of(sancionRepo.save(sancion));
	}

	@Override
	public Optional<Sancion> modificar(Sancion sancion) {
		// TODO Auto-generated method stub
		return Optional.of(sancionRepo.save(sancion));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		sancionRepo.deleteById(id);
		
		// TODO: hay que borrar también aquellos préstamos
		// que lleve hayan quedado con restrasos para evitar
		// inconsitencias? i.e. porqué tenemos un usuario
		// con préstamos fuera de plazo pero no tiene sanción que corresponde.
		
		return existePorId(id);
	}

	@Override
	public Set<Sancion> consultarTodas() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(sancionRepo.findAll().spliterator(), false).
			collect(Collectors.toSet());
	}

	@Override
	public Set<Sancion> consultarTodasDeUsuario(String dni) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = usuarioRepo.findById(dni);
		
		if (usuario.isEmpty()) {
			return Set.of();
		}
		
		return usuario.get().getSanciones();
	}

}
