package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dam2.examenspring.model.Mecanico;
import org.dam2.examenspring.repository.MecanicoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MecanicoServImpl implements MecanicoServ {

	@Autowired
	MecanicoRepo mecanicoRepo;
	
	@Override
	public Optional<Mecanico> consultarPorId(String id) {
		// TODO Auto-generated method stub
		return mecanicoRepo.findById(id);
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return mecanicoRepo.existsById(id);
	}

	@Override
	public Set<Mecanico> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(mecanicoRepo.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public Optional<Mecanico> insertar(Mecanico mecanico) {
		// TODO Auto-generated method stub
		return Optional.of(mecanicoRepo.save(mecanico));
	}

	@Override
	public Optional<Mecanico> actualizar(Mecanico mecanico) {
		// TODO Auto-generated method stub
		return Optional.of(mecanicoRepo.save(mecanico));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		mecanicoRepo.deleteById(id);
		
		return existePorId(id);
	}

}
