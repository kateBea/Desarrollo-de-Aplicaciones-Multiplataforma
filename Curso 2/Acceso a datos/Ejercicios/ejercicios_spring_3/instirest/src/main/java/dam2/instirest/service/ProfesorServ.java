package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.instirest.model.Profesor;

@Service
public interface ProfesorServ {
	Optional<Profesor> buscarPorId(String id);
	Set<Profesor> consultarTodos();
	boolean existePorId(String id);
	
	Optional<Profesor> insertar(Profesor profe);
	Optional<Profesor> actualizar(Profesor profe);
	
	boolean borrarPorId(String id);
	
}
