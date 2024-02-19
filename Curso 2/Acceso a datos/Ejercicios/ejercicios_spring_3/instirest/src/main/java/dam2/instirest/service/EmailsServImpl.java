package dam2.instirest.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.instirest.model.Email;
import dam2.instirest.repository.EmailRepo;

@Service
public class EmailsServImpl implements EmailServ {
	
	@Autowired
	EmailRepo repositorio;

	@Override
	public Optional<Email> buscarPorId(String id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Set<Email> consultarTodos() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).collect(Collectors.toSet());
	}

	@Override
	public boolean existePorId(String id) {
		// TODO Auto-generated method stub
		return repositorio.existsById(id);
	}

	@Override
	public Optional<Email> insertar(Email email) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(email));
	}

	@Override
	public Optional<Email> actualizar(Email email) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(email));
	}

	@Override
	public boolean borrarPorId(String id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
		return existePorId(id);
	}

}
