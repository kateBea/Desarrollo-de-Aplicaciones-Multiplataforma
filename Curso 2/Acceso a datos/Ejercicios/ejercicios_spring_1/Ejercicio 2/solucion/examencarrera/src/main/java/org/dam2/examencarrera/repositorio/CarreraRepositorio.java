package org.dam2.examencarrera.repositorio;

import java.util.List;

import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lombok.NonNull;

@Repository
public interface CarreraRepositorio extends CrudRepository<Carrera, String> {
	@Query("SELECT COUNT (*) FROM CarreraCorredor cc WHERE cc.carrera.nombre = ?1")
	int cuantosInscritos (String nombre);
	
	@Query ("SELECT c.maximo FROM Carrera c WHERE c.nombre = ?1 ")
	int maximoPermintido (String nombre);
	
	
	@Query ("SELECT cc.corredor FROM CarreraCorredor cc WHERE cc.carrera.nombre = ?1 "
			+ "ORDER BY cc.tiempo")
	List<Corredor> corredoresPorCarrera (String nombre);
	
	@Query ("SELECT cc.corredor FROM CarreraCorredor cc "
			+ "WHERE cc.carrera.fecha = (SELECT MIN(c.fecha) FROM Carrera c) "
			+ "ORDER BY cc.tiempo")
	List<Corredor> clasificacionCarreraMasAntigua ();
	
	@Query("SELECT carrera FROM Carrera carrera "
			+ "WHERE carrera.maximo > (SELECT COUNT (*) FROM CarreraCorredor cc WHERE cc.carrera.nombre = carrera.nombre) "
			 + "AND carrera.nombre NOT IN (SELECT cc1.carrera.nombre FROM CarreraCorredor cc1 WHERE cc1.corredor.dni = ?1)")
	List<Carrera> carrerasDisponiblesPorCorredor (String dni);

}
