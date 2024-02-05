package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.PuntoControl;
import dam2.carreras.repository.IPuntoControlRepo;

@Service
public class PuntoControlServImpl implements IPuntoControlService {
	
	@Autowired
	IPuntoControlRepo repositorio;

	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.existsById(id);
	}

	@Override
	public Set<PuntoControl> buscarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Optional<PuntoControl> buscardPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Optional<PuntoControl> insertar(PuntoControl nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<PuntoControl> actualizar(PuntoControl nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
		return existePorId(id);
	}

}
