package org.dam2.examencarrera.repositorio;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraCorredorRepositorio extends CrudRepository<CarreraCorredor, Long> {
	@Query("SELECT cc.carrera FROM CarreraCorredor cc WHERE cc.corredor.dni = ?1 AND  cc.tiempo > 0")
	List<Carrera> carrerasCorridasPorCorredor (String dni);
	

	@Query("SELECT carrera FROM Carrera carrera WHERE carrera.nombre NOT IN "
			+ "(SELECT cc.carrera FROM CarreraCorredor cc "
			+ "WHERE cc.corredor.dni = ?1)")
	List<Carrera> carrerasNoInscritasDelCorredor (String dni);
	
	Optional<CarreraCorredor> findByCarreraAndCorredor(Carrera carrera,Corredor corredor);
	
}
