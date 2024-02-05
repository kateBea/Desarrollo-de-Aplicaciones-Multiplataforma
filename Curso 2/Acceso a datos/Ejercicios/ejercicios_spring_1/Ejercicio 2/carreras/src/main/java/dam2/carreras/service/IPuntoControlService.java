package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import dam2.carreras.model.PuntoControl;

@Service
public interface IPuntoControlService {
	// Consultar
	boolean existePorId(Long id);
	Set<PuntoControl> buscarTodos();
	Optional<PuntoControl> buscardPorId(Long id);
	
	// Insertar
	Optional<PuntoControl> insertar(PuntoControl nuevo);
	
	// Modificar
	Optional<PuntoControl> actualizar(PuntoControl nuevo);
	
	// Borrar
	boolean borrarPorId(Long id);
}
