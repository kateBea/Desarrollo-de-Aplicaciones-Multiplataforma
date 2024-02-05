package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.carreras.model.Tiempo;

@Service
public interface ITiempoService {
	// Consultar
	boolean existePorId(Long id);
	Set<Tiempo> buscarTodos();
	Optional<Tiempo> buscardPorId(Long id);
	
	// Insertar
	Optional<Tiempo> insertar(Tiempo nuevo);
	
	// Modificar
	Optional<Tiempo> actualizar(Tiempo nuevo);
	
	// Borrar
	boolean borrarPorId(Long id);
}
