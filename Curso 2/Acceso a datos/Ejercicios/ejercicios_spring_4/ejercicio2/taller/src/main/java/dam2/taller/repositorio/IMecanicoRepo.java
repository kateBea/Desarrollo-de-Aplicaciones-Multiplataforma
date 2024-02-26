package dam2.taller.repositorio;

import dam2.taller.modelo.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMecanicoRepo extends CrudRepository<Mecanico, String> {

}
