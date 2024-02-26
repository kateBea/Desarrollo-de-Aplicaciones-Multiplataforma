package dam2.taller.repositorio;

import dam2.taller.modelo.Trabajo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajoRepo extends CrudRepository<Trabajo, Long> {

}
