package org.dam2.examenspring.repository;

import org.dam2.examenspring.model.TrabajoAsignado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoAsignadoRepo extends CrudRepository<TrabajoAsignado, Long>{

}
