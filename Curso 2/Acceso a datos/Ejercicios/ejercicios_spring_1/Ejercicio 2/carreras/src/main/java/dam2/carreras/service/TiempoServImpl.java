package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Tiempo;
import dam2.carreras.repository.TiempoRepo;

@Service
public class TiempoServImpl implements TiempoService {

	@Autowired
	TiempoRepo repositorio;
	
	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Tiempo> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Tiempo> buscardPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Tiempo> insertar(Tiempo nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<Tiempo> actualizar(Tiempo nuevo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
