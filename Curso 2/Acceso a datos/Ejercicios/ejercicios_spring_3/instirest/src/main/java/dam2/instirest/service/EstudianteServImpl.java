package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.instirest.model.Estudiante;
import dam2.instirest.repository.EstudianteRepo;

@Service
public class EstudianteServImpl implements EstudianteServ {
	
	@Autowired
	EstudianteRepo estudianteRepo;

	@Override
	public Optional<Estudiante> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return estudianteRepo.findById(id);
	}

	@Override
	public Set<Estudiante> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(estudianteRepo.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return estudianteRepo.existsById(id);
	}

	@Override
	public Optional<Estudiante> insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return Optional.of(estudianteRepo.save(estudiante));
	}

	@Override
	public Optional<Estudiante> actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return Optional.of(estudianteRepo.save(estudiante));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		
		estudianteRepo.deleteById(id);
		
		return existePorId(id);
	}

}
