package org.dam2.examenspring.repository;

import org.dam2.examenspring.model.Mecanico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepo extends CrudRepository<Mecanico, String>{

}
