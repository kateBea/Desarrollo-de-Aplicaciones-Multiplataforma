package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Cuenta;


@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, String> {
	
	@Query("SELECT SUM(c.saldo) FROM Cuenta c ")
	public float findSaldoTotal();
	
	@Query("SELECT cliente, SUM(cuenta.saldo) FROM Cuenta cuenta INNER JOIN cuenta.clientes cliente "
			+ "GROUP BY cliente.nif ORDER BY SUM(cuenta.saldo) DESC" )
	public List<Object[]> findClienteMasRico ();
}
