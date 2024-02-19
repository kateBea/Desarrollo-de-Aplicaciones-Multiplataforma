package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.instirest.model.Instituto;
import dam2.instirest.repository.InstitutoRepo;

@Service
public class InstitutoServImpl implements InstitutoServ {
	
	@Autowired
	InstitutoRepo institutoRepo;

	@Override
	public Optional<Instituto> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return institutoRepo.findById(id);
	}

	@Override
	public Set<Instituto> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(institutoRepo.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return institutoRepo.existsById(id);
	}

	@Override
	public Optional<Instituto> insertar(Instituto instituto) {
		// TODO Auto-generated method stub
		return Optional.of(institutoRepo.save(instituto));
	}

	@Override
	public Optional<Instituto> actualizar(Instituto instituto) {
		// TODO Auto-generated method stub
		return Optional.of(institutoRepo.save(instituto));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		institutoRepo.deleteById(id);
		
		return existePorId(id);
	}

}
