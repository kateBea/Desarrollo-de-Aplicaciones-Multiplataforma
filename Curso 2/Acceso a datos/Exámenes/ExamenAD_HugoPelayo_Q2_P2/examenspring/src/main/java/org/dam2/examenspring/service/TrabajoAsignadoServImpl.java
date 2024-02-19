package org.dam2.examenspring.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.dam2.examenspring.model.PiezaUsada;
import org.dam2.examenspring.model.Trabajo;
import org.dam2.examenspring.model.TrabajoAsignado;
import org.dam2.examenspring.repository.MecanicoRepo;
import org.dam2.examenspring.repository.PiezaUsadaRepo;
import org.dam2.examenspring.repository.TrabajoAsignadoRepo;
import org.dam2.examenspring.repository.TrabajoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TrabajoAsignadoServImpl implements TrabajoAsignadoServ {

	@Autowired
	TrabajoAsignadoRepo trabajoAsigRepo;
	
	@Autowired
	TrabajoRepo trabajoRepo;
	
	@Autowired
	MecanicoRepo mecanicoRepo;
	
	@Autowired
	PiezaUsadaRepo piezaUsadaRepo;

	@Override
	public Optional<TrabajoAsignado> consultarPorId(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return Optional.empty();
		}
		
		return trabajoAsigRepo.findById(id);
	}

	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return false;
		}
		
		return trabajoAsigRepo.existsById(id);
	}

	@Override
	public Set<TrabajoAsignado> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(trabajoAsigRepo.findAll().spliterator(), false).
			collect(Collectors.toSet());
	}

	@Override
	@Transactional
	public Optional<TrabajoAsignado> insertar(TrabajoAsignado item) {
		// TODO Auto-generated method stub
		if (item.getMecanico() != null && !mecanicoRepo.existsById(item.getMecanico().getNickname())) {
			mecanicoRepo.save(item.getMecanico());
		}
		
		if (item.getTrabajo() != null && 
				item.getTrabajo().getId() != null &&
				!trabajoRepo.existsById(item.getTrabajo().getId())) {
			trabajoRepo.save(item.getTrabajo());
		}
		
		if (item.getPiezasUsadas() != null) {
			for (PiezaUsada pieza : item.getPiezasUsadas()) {
				if (pieza.getId() == null || !piezaUsadaRepo.existsById(pieza.getId())) {
					piezaUsadaRepo.save(pieza);
				}
			}
		}
		
		return Optional.of(trabajoAsigRepo.save(item));
	}

	@Override
	public Optional<TrabajoAsignado> actualizar(TrabajoAsignado item) {
		// TODO Auto-generated method stub
		return Optional.of(trabajoAsigRepo.save(item));
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return false;
		}
		
		trabajoAsigRepo.deleteById(id);
		
		return existePorId(id);
	}
	
	

}
