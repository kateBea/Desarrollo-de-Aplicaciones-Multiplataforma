package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;

import org.dam2.examenspring.model.Mecanico;
import org.springframework.stereotype.Service;

@Service
public interface MecanicoServ {
	public Optional<Mecanico> consultarPorId(String id);
	public boolean existePorId(String id);
	public Set<Mecanico> consultarTodos();
	
	public Optional<Mecanico> insertar(Mecanico mecanico);
	public Optional<Mecanico> actualizar(Mecanico mecanico);
	
	public boolean borrarPorId(String id);
}
