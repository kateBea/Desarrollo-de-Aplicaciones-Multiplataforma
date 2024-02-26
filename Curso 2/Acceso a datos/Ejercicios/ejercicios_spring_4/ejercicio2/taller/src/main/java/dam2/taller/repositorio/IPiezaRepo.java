package dam2.taller.repositorio;

import dam2.taller.modelo.Pieza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPiezaRepo extends CrudRepository<Pieza, String> {

}
