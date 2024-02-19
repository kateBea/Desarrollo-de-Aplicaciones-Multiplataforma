package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.instirest.model.Estudiante;

@Service
public interface EstudianteServ {
	Optional<Estudiante> buscarPorId(String id);
	Set<Estudiante> consultarTodos();
	boolean existePorId(String id);
	
	Optional<Estudiante> insertar(Estudiante estudiante);
	Optional<Estudiante> actualizar(Estudiante estudiante);
	
	boolean borrarPorId(String id);
}
