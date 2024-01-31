package dam2.repoqueries.app.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dam2.repoqueries.app.modelo.Empleado;
import dam2.repoqueries.app.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

	// Inyección. Insertamos nuestros DAOs 
	@Autowired
	EmpleadoRepositorio repositorio;
	
	@Override
	public Optional<Empleado> buscarPorClave(Integer id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Optional<Empleado> insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(empleado));
	}

	@Override
	public Optional<Empleado> actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		return Optional.of(repositorio.save(empleado));
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
	public Set<Empleado> findAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(repositorio.findAll().spliterator(), false).
				collect(Collectors.toSet());
	}

	@Override
	public Set<Empleado> buscarPorCargo(String cargo) {
		// TODO Auto-generated method stub
		return repositorio.findByCargo(cargo);
	}
}
