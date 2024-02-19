package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;

import org.dam2.examenspring.model.Pieza;
import org.springframework.stereotype.Service;

@Service
public interface PiezaServ {
	public Optional<Pieza> consultarPorId(String id);
	public boolean existePorId(String id);
	public Set<Pieza> consultarTodos();
	
	public Optional<Pieza> insertar(Pieza pieza);
	public Optional<Pieza> actualizar(Pieza pieza);
	
	public boolean borrarPorId(String id);
}
