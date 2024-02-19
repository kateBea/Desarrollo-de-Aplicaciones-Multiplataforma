package org.dam2.examenspring.repository;

import org.dam2.examenspring.model.Pieza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiezaRepo extends CrudRepository<Pieza, String>{

}
