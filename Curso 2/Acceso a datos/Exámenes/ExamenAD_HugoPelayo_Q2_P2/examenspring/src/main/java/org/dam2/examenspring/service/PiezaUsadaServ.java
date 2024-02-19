package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;

import org.dam2.examenspring.model.PiezaUsada;
import org.springframework.stereotype.Service;

@Service
public interface PiezaUsadaServ {
	public Optional<PiezaUsada> consultarPorId(Long id);
	public boolean existePorId(Long id);
	public Set<PiezaUsada> consultarTodos();
	
	public Optional<PiezaUsada> insertar(PiezaUsada item);
	public Optional<PiezaUsada> actualizar(PiezaUsada item);
	
	public boolean borrarPorId(Long id);
}
