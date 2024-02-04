package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Corredor;
import dam2.carreras.repository.CorredorRepo;

@Service
public class CorredorServImpl implements CorredorService {

	@Autowired
	CorredorRepo repositorio;
	
	@Override
	public boolean existePorId(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Corredor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Corredor> buscardPorId(String nombre) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Corredor> insertar(Corredor nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<Corredor> actualizar(Corredor nuevo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean borrarPorId(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
