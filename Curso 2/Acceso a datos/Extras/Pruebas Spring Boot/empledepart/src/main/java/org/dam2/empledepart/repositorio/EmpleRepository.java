package org.dam2.empledepart.repositorio;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Tuple;


import org.dam2.empledepart.modelo.Emple;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface EmpleRepository extends PagingAndSortingRepository<Emple, String> {
	//@Query("SELECT e.nomemp as nomemp, e.salEmp as salEmp  FROM Emple e")
	//List<Tuple> buscarNombreYSaldo ();
	//List<NombreYSaldo> buscarNombreYSaldo ();
	//List<Object[]> buscarNombreYSaldo ();
	
	//List<Emple> findByNomemp (String nomemp);
	@Query ("SELECT e FROM Emple e")
	Stream<Emple> buscaTodos ();
	
	@Modifying
	@Query("UPDATE Emple e SET e.comisionE = ?1 WHERE e.comisionE > ?2")
	int modificarPorCargo (float nuevaComision,float comisionE);
	
	@Modifying
	@Query("DELETE FROM Emple e WHERE e.nidemp=?1")
	int borrarEmpleado (String id);
}
