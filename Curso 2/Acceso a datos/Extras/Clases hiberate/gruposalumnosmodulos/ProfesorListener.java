package org.dam2.gruposalumnosmodulos;

import java.util.List;

import javax.persistence.PreRemove;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class ProfesorListener {
	private final String UNIDADPERSISTENCIA = "gruposalumnosmodulos";
	private final Profesor PROFESORPORDEFECTO = Profesor.builder().
								dni("INDEFINIDO").
								nombre("SIN NOMBRE").
								especialidad("SIN ESPECIALIDAD").
								build();
	
	@PreRemove
	public void borrarProfesor (Profesor profesor)
	{
		tratarModulos (profesor);
		tratarTutoria (profesor);
		
	}
	
	private void tratarModulos(Profesor profesor)
	{
		GenericJPADAO <Modulo,String> moduloDAO;
		moduloDAO = new GenericJPADAO(Modulo.class,UNIDADPERSISTENCIA);
		
		List<Modulo> modulos = (List<Modulo>) moduloDAO.findAll();
		
		// Borrado de puesta a nulos para modulos
		modulos.stream().
				filter(m-> m.getProfesor().equals(profesor)).
				forEach(m-> {m.setProfesor(null);moduloDAO.update(m);});
		
		// Borrado de puesta a valor por defecto para modulos
		/*
		modulos.stream().
				filter(m-> m.getProfesor().equals(profesor)).
				forEach(m-> {m.setProfesor(PROFESORPORDEFECTO);moduloDAO.update(m);});
		*/
	}
	
	private void tratarTutoria (Profesor profesor)
	{
		GenericJPADAO <Grupo,String> grupoDAO;
		grupoDAO = new GenericJPADAO(Grupo.class,UNIDADPERSISTENCIA);
		
		List<Grupo> grupos = (List<Grupo>) grupoDAO.findAll();
		
		// Borrado de puesta a nulos
		grupos.stream().
				filter(g -> g.getTutor().equals(profesor)).
				findFirst().
				ifPresent(g -> {g.setTutor(null); grupoDAO.update(g);});
		
		// Borrado de puesta a profe por defecto
		/*
		grupos.stream().
				filter(g -> g.getTutor().equals(profesor)).
				findFirst().
				bifPresent(g -> {g.setTutor(PROFESORPORDEFECTO); grupoDAO.update(g);});
		*/
	}

}
