package dam2.biblioteca.servicio;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.biblioteca.modelo.Ejemplar;
import dam2.biblioteca.repositorio.IEjemplarRepo;

@Service
public class EjemplarServImpl implements IEjemplarServ {
	
	@Autowired
	IEjemplarRepo ejemplarRepo;

	@Override
	public Optional<Ejemplar> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return ejemplarRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return ejemplarRepo.existsById(id);
	}

	@Override
	public Optional<Ejemplar> insertar(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		return Optional.of(ejemplarRepo.save(ejemplar));
	}

	@Override
	public Optional<Ejemplar> modificar(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		return Optional.of(ejemplarRepo.save(ejemplar));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		ejemplarRepo.deleteById(id);
		
		return existePorId(id);
	}

	@Override
	public Set<Ejemplar> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(ejemplarRepo.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}
	
	
}
