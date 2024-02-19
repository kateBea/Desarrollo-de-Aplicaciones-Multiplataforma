package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dam2.examenspring.model.PiezaUsada;
import org.dam2.examenspring.repository.PiezaUsadaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PiezaUsadaServImpl implements PiezaUsadaServ {

	@Autowired
	PiezaUsadaRepo piezaUsadaRepo;
	
	@Override
	public Optional<PiezaUsada> consultarPorId(Long id) {
		// TODO Auto-generated method stub
		return piezaUsadaRepo.findById(id);
	}

	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return piezaUsadaRepo.existsById(id);
	}

	@Override
	public Set<PiezaUsada> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(piezaUsadaRepo.findAll().spliterator(), false).
			collect(Collectors.toSet());
	}

	@Override
	public Optional<PiezaUsada> insertar(PiezaUsada item) {
		// TODO Auto-generated method stub
		return Optional.of(piezaUsadaRepo.save(item));
	}

	@Override
	public Optional<PiezaUsada> actualizar(PiezaUsada item) {
		// TODO Auto-generated method stub
		return Optional.of(piezaUsadaRepo.save(item));
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		piezaUsadaRepo.deleteById(id);
		return existePorId(id);
	}

}
