package org.dam2.examenspring.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.management.RuntimeErrorException;

import org.dam2.examenspring.model.Estado;
import org.dam2.examenspring.model.Mecanico;
import org.dam2.examenspring.model.PiezaUsada;
import org.dam2.examenspring.model.Trabajo;
import org.dam2.examenspring.model.TrabajoAsignado;
import org.dam2.examenspring.repository.MecanicoRepo;
import org.dam2.examenspring.repository.TrabajoAsignadoRepo;
import org.dam2.examenspring.repository.TrabajoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TrabajoServImpl implements TrabajoServ {

	@Autowired
	private TrabajoRepo trabajoRepo;
	
	@Autowired
	private MecanicoServ mecanicoServ;
	
	@Autowired
	private TrabajoAsignadoServ trabajoAsignadoServ;
	
	@Override
	public Optional<Trabajo> consultarPorId(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return Optional.empty();
		}
		
		return trabajoRepo.findById(id);
	}

	@Override
	public boolean existePorId(Long id) {
		// TODO Auto-generated method stub
		return trabajoRepo.existsById(id);
	}

	@Override
	public Set<Trabajo> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(trabajoRepo.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	@Transactional
	public Optional<Trabajo> insertar(Trabajo trabajo) {
		// TODO Auto-generated method stub		
		trabajo.setFechaRegistro(LocalDate.now());
		Optional<Trabajo> resultado = Optional.of(trabajoRepo.save(trabajo));
		
		// buscar mecanico libre
		Set<Mecanico> asigns = trabajoAsignadoServ.consultarTodos().stream().
			filter(asign -> asign.getMecanico() == null).map(asign -> asign.getMecanico()).collect(Collectors.toSet());
		Set<Mecanico> libres = mecanicoServ.consultarTodos();
		
		if (libres != null) {
			libres.removeAll(asigns);
			
			Optional<Mecanico> mec = libres.stream().findFirst();
			
			if (libres.size() > 1) {
				mec = libres.stream().sorted((m1, m2) -> m1.getFechaAlta().compareTo(m2.getFechaAlta())).findFirst();
			} else {
				mec = libres.stream().findFirst();
			}

			Optional<TrabajoAsignado> asignacion = Optional.empty();
			
			if (mec.isPresent()) {
				// Hay mecanico libre
				TrabajoAsignado asign = TrabajoAsignado.builder().
					estado(Estado.EN_PROCESO).
					horasDedicadas(0).
					trabajo(trabajo).
					mecanico(mec.get()).
					piezasUsadas(Set.of()).
					build();
				
				asignacion = trabajoAsignadoServ.insertar(asign);
			} else {
				// No hay mecanico libre
				TrabajoAsignado asign = TrabajoAsignado.builder().
					estado(Estado.ESPERA).
					horasDedicadas(0).
					trabajo(trabajo).
					mecanico(null).
					piezasUsadas(Set.of()).
					build();
				
				asignacion = trabajoAsignadoServ.insertar(asign);
			}
			
			if (asignacion.isPresent()) {
				resultado = Optional.of(asignacion.get().getTrabajo());
			}
		}
		
		return resultado;
	}

	@Override
	public Optional<Trabajo> actualizar(Trabajo trabajo) {
		// TODO Auto-generated method stub
		Optional<Trabajo> result = consultarPorId(trabajo.getId());
		
		if (result.isEmpty()) {
			throw new RuntimeException("El trabajo con id " + trabajo.getId() + " no existe"); 
		}
		
		return Optional.of(trabajoRepo.save(trabajo));
	}

	@Override
	public boolean borrarPorId(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			return false;
		}
		
		trabajoRepo.deleteById(id);
		
		return existePorId(id);
	}

}
