package dam2.taller.repositorio;

import dam2.taller.modelo.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaterialRepo extends CrudRepository<Material, Long> {

}
