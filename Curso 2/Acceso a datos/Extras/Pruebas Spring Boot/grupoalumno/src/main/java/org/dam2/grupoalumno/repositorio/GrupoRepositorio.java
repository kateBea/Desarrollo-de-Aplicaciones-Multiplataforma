package org.dam2.grupoalumno.repositorio;

import java.util.List;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepositorio extends CrudRepository<Grupo, String> {

	@Query ("SELECT g.alumnos FROM Grupo g WHERE g.id =?1")
	public List<Alumno> buscarAlumnosPorGrupo (String grupo);
	
	@Query ("SELECT g.id FROM Grupo g")
	public List<String> buscarTodosIds ();
}
