package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.PuntoControl;
import dam2.carreras.repository.PuntoControlRepo;

@Service
public class PuntoControlServImpl implements PuntoDeControlService {
	@Autowired
	PuntoControlRepo repositorio;

	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<PuntoControl> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PuntoControl> buscardPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<PuntoControl> insertar(PuntoControl nuevo) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(nuevo));
	}

	@Override
	public Optional<PuntoControl> actualizar(PuntoControl nuevo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
