package org.dam2.grupoalumno.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.springframework.stereotype.Service;


public interface IGrupoServicio {
	public List<Grupo> findAll ();
	
	public Optional<Grupo> findById (String id);
	
	public List<Alumno> buscarAlumnosPorGrupo (String grupo);
	
	public boolean insertarGrupo (Grupo grupo);
	
	public boolean actualizarGrupo (Grupo grupo);
	
	public boolean borrarGrupo (String grupo);
	
	public List<String> listarTodosIds ();

}
