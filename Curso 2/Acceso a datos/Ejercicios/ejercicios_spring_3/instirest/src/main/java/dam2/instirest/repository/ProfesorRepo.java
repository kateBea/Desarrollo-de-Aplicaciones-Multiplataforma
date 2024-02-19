package dam2.instirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dam2.instirest.model.Profesor;

@Repository
public interface ProfesorRepo extends CrudRepository<Profesor, String>{

}
