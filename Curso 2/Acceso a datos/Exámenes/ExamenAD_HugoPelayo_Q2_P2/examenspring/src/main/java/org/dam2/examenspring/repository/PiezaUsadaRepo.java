package org.dam2.examenspring.repository;

import org.dam2.examenspring.model.PiezaUsada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiezaUsadaRepo extends CrudRepository<PiezaUsada, Long>{

}
