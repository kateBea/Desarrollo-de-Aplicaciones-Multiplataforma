package com.dam2.ventas.repositorio;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dam2.ventas.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

	//@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.saldo = u.saldo * 1.1")
	Integer actualizarSaldo ();
	
	@Query("SELECT u.nombre, u.nif FROM Usuario u WHERE u.saldo > 1000")
	List<Object[]> saldosMayoresDe1000 ();
	
	
	
	Page<Usuario> findByNombre (String nombre,Pageable pageable);
	List<NombreYSaldo> findByNombreAndSaldoLessThan(String nombre, float saldo);
}
