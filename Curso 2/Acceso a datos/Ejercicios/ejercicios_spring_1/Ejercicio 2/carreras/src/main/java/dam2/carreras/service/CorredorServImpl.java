package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Corredor;
import dam2.carreras.repository.ICorredorRepo;

@Service
public class CorredorServImpl implements ICorredorService {

	@Autowired
	ICorredorRepo repositorio;
	
	@Override
	public boolean existePorId(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.existsById(nombre);
	}

	@Override
	public Set<Corredor> buscarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Optional<Corredor> buscardPorId(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findById(nombre);
	}

	@Override
	public Optional<Corredor> insertar(Corredor nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<Corredor> actualizar(Corredor nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public boolean borrarPorId(String nombre) {
		// TODO Auto-generated method stub
		repositorio.deleteById(nombre);
		
		return existePorId(nombre);
	}

}
