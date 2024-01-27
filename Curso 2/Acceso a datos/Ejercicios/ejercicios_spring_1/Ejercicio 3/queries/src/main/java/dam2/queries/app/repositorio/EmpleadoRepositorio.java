package dam2.queries.app.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dam2.queries.app.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends CrudRepository<Empleado, Integer>{
	
}
