package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.instirest.model.Instituto;

@Service
public interface InstitutoServ {
	Optional<Instituto> buscarPorId(String id);
	Set<Instituto> consultarTodos();
	boolean existePorId(String id);
	
	Optional<Instituto> insertar(Instituto instituto);
	Optional<Instituto> actualizar(Instituto instituto);
	
	boolean borrarPorId(String id);
}
