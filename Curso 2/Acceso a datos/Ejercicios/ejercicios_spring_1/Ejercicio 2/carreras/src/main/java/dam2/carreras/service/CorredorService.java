package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.carreras.model.Corredor;

@Service
public interface CorredorService {
	// Consultar
	boolean existePorId(String nombre);
	Set<Corredor> buscarTodos();
	Optional<Corredor> buscardPorId(String nombre);
	
	// Insertar
	Optional<Corredor> insertar(Corredor nuevo);
	
	// Modificar
	Optional<Corredor> actualizar(Corredor nuevo);
	
	// Borrar
	boolean borrarPorId(String nombre);
}
