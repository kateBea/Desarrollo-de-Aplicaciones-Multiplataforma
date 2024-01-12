package org.dam2.clientebanco.repository;

import org.dam2.clientebanco.modelo.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends CrudRepository<Cliente,String>{
	@Modifying
	@Query("UPDATE Cliente c SET c.aval = c.aval + 1000 WHERE c.nif = ?1")
	int modificaAval (String nif);
	
	

}