package dam2.carreras.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.carreras.model.Carrera;
import dam2.carreras.repository.ICarreraRepo;
import dam2.carreras.repository.ICorredorRepo;
import dam2.carreras.repository.IPuntoControlRepo;
import jakarta.transaction.Transactional;

@Service
public class CarreraServImpl implements ICarreraService {

	@Autowired
	ICarreraRepo repositorio;
	
	@Autowired
	IPuntoControlRepo repoPuntoControl;
	
	@Autowired
	ICorredorRepo repoCorredor;
	
	@Override
	public boolean existePorId(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.existsById(nombre);
	}

	@Override
	public Set<Carrera> buscarTodas() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Optional<Carrera> buscardPorId(String nombre) {
		// TODO Auto-generated method stub
		return repositorio.findById(nombre);
	}

	@Override
	@Transactional
	public Optional<Carrera> insertar(Carrera nueva) {
		// TODO Auto-generated method stub
		
		// Comprobamos si existen los puntos de control, sino los añadimos
		// A lo mejor lo hace el cliente, eso no lo sabemos.
		if (nueva.getPuntosControl() != null) {
			nueva.getPuntosControl().stream().forEach(punto -> {
				if (!repoPuntoControl.existsById(punto.getId()) ) {
					repoPuntoControl.save(punto);
				}
			});
		}
		
		if (nueva.getCorredores() != null) {
			// Comprobamos si existen los corredores
			nueva.getCorredores().stream().forEach(corredor -> {
				if (!repoCorredor.existsById(corredor.getDni()) ) {
					repoCorredor.save(corredor);
				}
			});
		}
		
		return Optional.of(repositorio.save(nueva));
	}

	@Override
	public Optional<Carrera> actualizar(Carrera nueva) {
		// TODO Auto-generated method stub
		return insertar(nueva);
	}

	@Override
	public boolean borrarPorId(String nombre) {
		// TODO Auto-generated method stub
		repositorio.deleteById(nombre);
		
		return existePorId(nombre);
	}

}
