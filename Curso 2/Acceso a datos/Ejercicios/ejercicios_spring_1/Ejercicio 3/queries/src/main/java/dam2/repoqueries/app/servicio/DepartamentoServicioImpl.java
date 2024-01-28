package dam2.repoqueries.app.servicio;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam2.repoqueries.app.modelo.Departamento;
import dam2.repoqueries.app.repositorio.DepartamentoRepositorio;

@Service
public class DepartamentoServicioImpl implements DepartamentoServicio {
	
	// Inyección. Insertamos nuestros DAOs 
	@Autowired
	DepartamentoRepositorio repositorio;

	@Override
	public Optional<Departamento> buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Optional<Departamento> insertar(Departamento departamento) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(departamento));
	}

	@Override
	public Optional<Departamento> actualizar(Departamento departamento) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(departamento));
	}

	@Override
	public boolean borrarPorClave(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
		return existePorClave(id);
	}

	@Override
	public boolean existePorClave(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.existsById(id);
	}

	@Override
	public Set<Departamento> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

}
