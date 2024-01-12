package org.dam2.grupoalumno.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.dam2.grupoalumno.repositorio.AlumnoRepositorio;
import org.dam2.grupoalumno.repositorio.GrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServicioImpl implements IGrupoServicio{

	@Autowired GrupoRepositorio grupoDao;
	@Autowired AlumnoRepositorio alumnoDao;
	@Override
	public List<Grupo> findAll() {
		// TODO Auto-generated method stub
		return (List<Grupo>) grupoDao.findAll();
	}

	@Override
	public Optional<Grupo> findById(String id) {
		// TODO Auto-generated method stub
		return grupoDao.findById(id);
	}

	@Override
	public List<Alumno> buscarAlumnosPorGrupo(String grupo) {
		// TODO Auto-generated method stub
		
		return grupoDao.buscarAlumnosPorGrupo(grupo);
	}

	@Override
	public boolean insertarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!grupoDao.existsById(grupo.getId()))
		{
			exito = true;
			grupoDao.save(grupo);
		}
		return exito;
	}

	@Override
	public boolean actualizarGrupo(Grupo grupo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (grupoDao.existsById(grupo.getId()))
		{
			exito = true;
			grupoDao.save(grupo);
		}
		return exito;
	}

	@Override
	public boolean borrarGrupo(String grupo) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (grupoDao.existsById(grupo))
		{
			exito = true;
			grupoDao.deleteById(grupo);
		}
		return exito;
	}

	@Override
	public List<String> listarTodosIds() {
		// TODO Auto-generated method stub
		return grupoDao.buscarTodosIds();
	}

}
