package org.dam2.controllers.repositorio;

import org.dam2.controllers.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente, String>{

}
