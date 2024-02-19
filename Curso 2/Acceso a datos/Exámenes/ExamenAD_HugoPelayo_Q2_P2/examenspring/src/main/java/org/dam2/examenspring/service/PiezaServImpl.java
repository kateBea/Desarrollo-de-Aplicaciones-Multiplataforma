package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dam2.examenspring.model.Pieza;
import org.dam2.examenspring.repository.PiezaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiezaServImpl implements PiezaServ {

	@Autowired
	PiezaRepo piezaRepo;
	
	@Override
	public Optional<Pieza> consultarPorId(String id) {
		// TODO Auto-generated method stub
		return piezaRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return piezaRepo.existsById(id);
	}

	@Override
	public Set<Pieza> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(piezaRepo.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Optional<Pieza> insertar(Pieza pieza) {
		// TODO Auto-generated method stub
		return Optional.of(piezaRepo.save(pieza));
	}

	@Override
	public Optional<Pieza> actualizar(Pieza pieza) {
		// TODO Auto-generated method stub
		return Optional.of(piezaRepo.save(pieza));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		piezaRepo.deleteById(id);
		
		return existePorId(id);
	}

}
