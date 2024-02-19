package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.instirest.model.Profesor;
import dam2.instirest.repository.EstudianteRepo;
import dam2.instirest.repository.ProfesorRepo;
import jakarta.transaction.Transactional;

@Service
public class ProfesorServImpl implements ProfesorServ {
	
	@Autowired
	ProfesorRepo profesorRepo;
	
	@Autowired
	EstudianteRepo estudianteRepo;

	@Override
	public Optional<Profesor> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return profesorRepo.findById(id);
	}

	@Override
	public Set<Profesor> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(profesorRepo.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return profesorRepo.existsById(null);
	}

	@Override
	@Transactional
	public Optional<Profesor> insertar(Profesor profe) {
		// TODO Auto-generated method stub
		
		if (profe.getEstudiantes() != null && profe.getEstudiantes().size() > Profesor.getMaxEstudiantesPorProfe()) {
			throw new RuntimeException("Límite de estudiantes superado");
		}
		
		// Comprobar si existen los estudiantes, sino darlos de alta
		// La operación se aplica en cascada a los emails
		
		if (profe.getEstudiantes() != null) {
			profe.getEstudiantes().forEach(est -> estudianteRepo.save(est));
		}
		
		return Optional.of(profesorRepo.save(profe));
	}

	@Override
	public Optional<Profesor> actualizar(Profesor profe) {
		// TODO Auto-generated method stub
		if (profe.getEstudiantes() != null && profe.getEstudiantes().size() > Profesor.getMaxEstudiantesPorProfe()) {
			throw new RuntimeException("Límite de estudiantes superado");
		}
		
		return Optional.of(profesorRepo.save(profe));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		profesorRepo.deleteById(id);
		
		return existePorId(id);
	}

}
