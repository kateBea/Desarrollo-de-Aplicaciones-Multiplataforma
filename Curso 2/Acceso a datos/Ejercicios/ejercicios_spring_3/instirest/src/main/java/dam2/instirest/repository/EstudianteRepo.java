package dam2.instirest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dam2.instirest.model.Estudiante;

@Repository
public interface EstudianteRepo extends CrudRepository<Estudiante, String>{

}
