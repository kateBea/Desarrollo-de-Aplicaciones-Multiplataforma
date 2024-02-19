package org.dam2.examenspring.repository;

import java.util.Optional;

import org.dam2.examenspring.model.Mecanico;
import org.dam2.examenspring.model.Trabajo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepo extends CrudRepository<Trabajo, Long>{

}
