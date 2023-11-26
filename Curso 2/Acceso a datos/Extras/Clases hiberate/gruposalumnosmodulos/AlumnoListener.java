package org.dam2.gruposalumnosmodulos;
import java.util.List;

import javax.persistence.PreRemove;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AlumnoListener {
	private final String UNIDADPERSISTENCIA = "gruposalumnosmodulos";
	@PreRemove
	public void borradoAlumno (Alumno alumno)
	{
		GenericJPADAO <Calificacion,Integer> calificacionDAO;
		calificacionDAO = new GenericJPADAO(Calificacion.class,UNIDADPERSISTENCIA);
		
		List<Calificacion> calificaciones  = (List<Calificacion>) calificacionDAO.findAll();
		
		calificaciones.stream().
				filter(c ->c.getAlumno().equals(alumno)).
				forEach(calificacionDAO::delete);
	}

}
