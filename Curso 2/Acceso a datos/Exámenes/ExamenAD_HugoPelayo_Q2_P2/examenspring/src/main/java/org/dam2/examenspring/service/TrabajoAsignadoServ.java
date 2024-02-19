package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;

import org.dam2.examenspring.model.TrabajoAsignado;
import org.springframework.stereotype.Service;

@Service
public interface TrabajoAsignadoServ {
	public Optional<TrabajoAsignado> consultarPorId(Long id);
	public boolean existePorId(Long id);
	public Set<TrabajoAsignado> consultarTodos();
	
	public Optional<TrabajoAsignado> insertar(TrabajoAsignado item);
	public Optional<TrabajoAsignado> actualizar(TrabajoAsignado item);
	
	public boolean borrarPorId(Long id);
}
