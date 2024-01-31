package dam2.repoqueries.app.repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dam2.repoqueries.app.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends CrudRepository<Empleado, Integer>{
	
	@Query("SELECT e FROM Empleado e WHERE e.cargo = :cargoe")
	Set<Empleado> findByCargo(@Param("cargoe") String cargo);
}
