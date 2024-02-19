package dam2.instirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dam2.instirest.model.Instituto;

@Repository
public interface InstitutoRepo extends CrudRepository<Instituto, String> {

}
