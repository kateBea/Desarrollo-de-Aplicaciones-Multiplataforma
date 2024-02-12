package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Tiempo;
import dam2.carreras.repository.ICarreraRepo;
import dam2.carreras.repository.ICorredorRepo;
import dam2.carreras.repository.ITiempoRepo;
import jakarta.transaction.Transactional;

@Service
public class TiempoServImpl implements ITiempoService {

	@Autowired
	ITiempoRepo repositorio;
	
	@Autowired
	ICorredorRepo repositorioCorredor;
	
	@Autowired
	ICarreraRepo repositorioCarrera;
	
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
	@Transactional
	public Optional<Tiempo> insertar(Tiempo nuevo) {
		// TODO Auto-generated method stub
		
		// Comprobamos la existencia del corredor, si no lo insrtamos
		// porque no hemos usado el cascade en el modelo
		if (nuevo.getCorredor() != null && !repositorioCorredor.existsById(nuevo.getCorredor().getDni())) {
			repositorioCorredor.save(nuevo.getCorredor());
		}
		
		// Comprobamos la existencia del carrera, si no la insrtamos
		// porque no hemos usado el cascade en el modelo
		if (nuevo.getCarrera() != null && !repositorioCorredor.existsById(nuevo.getCarrera().getNombre())) {
			repositorioCarrera.save(nuevo.getCarrera());
		}
		
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
