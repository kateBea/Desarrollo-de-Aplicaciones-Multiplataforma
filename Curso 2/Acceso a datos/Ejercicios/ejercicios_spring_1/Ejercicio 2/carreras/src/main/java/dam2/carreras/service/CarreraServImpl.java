package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Carrera;
import dam2.carreras.repository.CarreraRepo;

@Service
public class CarreraServImpl implements CarreraService {

	@Autowired
	CarreraRepo repositorio;
	
	@Override
	public boolean existePorId(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Carrera> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Carrera> buscardPorId(String nombre) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Carrera> insertar(Carrera nueva) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nueva));
	}

	@Override
	public Optional<Carrera> actualizar(Carrera nueva) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean borrarPorId(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

}
