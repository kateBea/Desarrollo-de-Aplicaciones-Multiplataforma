package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.instirest.model.Email;

@Service
public interface EmailServ {
	Optional<Email> buscarPorId(String id);
	Set<Email> consultarTodos();
	boolean existePorId(String id);
	
	Optional<Email> insertar(Email email);
	Optional<Email> actualizar(Email email);
	
	boolean borrarPorId(String id);
}
