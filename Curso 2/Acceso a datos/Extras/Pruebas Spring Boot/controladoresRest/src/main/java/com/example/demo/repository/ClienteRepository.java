package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,String>{
	
	
	@Query("SELECT t.proveedor, COUNT(t) FROM Cliente cliente INNER JOIN cliente.telefonos t "
			+ "GROUP BY t.proveedor ORDER BY COUNT(t) DESC" )
	public List<Object[]> findProveedorMasUsado ();
	
	public List<Cliente> findByNombre (String nombre);


}
