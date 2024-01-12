package org.dam2.grupoalumno.repositorio;

import org.dam2.grupoalumno.modelo.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {

}
