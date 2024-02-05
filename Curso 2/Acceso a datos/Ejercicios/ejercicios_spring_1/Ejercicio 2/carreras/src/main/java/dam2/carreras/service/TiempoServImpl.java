package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Tiempo;
import dam2.carreras.repository.ITiempoRepo;

@Service
public class TiempoServImpl implements ITiempoService {

	@Autowired
	ITiempoRepo repositorio;
	
	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.existsById(id);
	}

	@Override
	public Set<Tiempo> buscarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Optional<Tiempo> buscardPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Optional<Tiempo> insertar(Tiempo nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<Tiempo> actualizar(Tiempo nuevo) {
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
