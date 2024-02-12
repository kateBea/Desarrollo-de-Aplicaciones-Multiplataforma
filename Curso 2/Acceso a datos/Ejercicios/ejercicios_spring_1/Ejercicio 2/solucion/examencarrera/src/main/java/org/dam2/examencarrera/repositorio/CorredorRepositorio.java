package org.dam2.examencarrera.repositorio;

import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepositorio extends CrudRepository<Corredor, String> {

}
