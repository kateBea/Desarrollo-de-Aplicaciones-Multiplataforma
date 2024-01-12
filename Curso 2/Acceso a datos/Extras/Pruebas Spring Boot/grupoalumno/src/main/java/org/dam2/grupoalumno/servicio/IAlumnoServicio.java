package org.dam2.grupoalumno.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.grupoalumno.modelo.Alumno;
import org.springframework.stereotype.Service;


public interface IAlumnoServicio {
	public List<Alumno> findAll ();
	public Optional<Alumno> findById (String nia);
	
	public boolean eliminarAlumno (String nia);
	
	public boolean actualizarAlumno (Alumno alumno);
	boolean insertarAlumno(Alumno alumno);

}
