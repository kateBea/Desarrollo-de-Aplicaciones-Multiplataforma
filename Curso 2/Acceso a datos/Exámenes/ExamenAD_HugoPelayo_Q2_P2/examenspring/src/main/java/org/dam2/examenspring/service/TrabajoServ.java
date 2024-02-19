package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;

import org.dam2.examenspring.model.Trabajo;
import org.springframework.stereotype.Service;

@Service
public interface TrabajoServ {
	public Optional<Trabajo> consultarPorId(Long id);
	public boolean existePorId(Long id);
	public Set<Trabajo> consultarTodos();
	
	public Optional<Trabajo> insertar(Trabajo trabajo);
	public Optional<Trabajo> actualizar(Trabajo trabajo);
	
	public boolean borrarPorId(Long id);
}
