package org.dam2.grupoalumno.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServicioImpl implements IAlumnoServicio {

	@Autowired AlumnoRepositorio alumnoDao;
	@Override
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	public Optional<Alumno> findById(String nia) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(nia);
	}

	@Override
	public boolean eliminarAlumno(String nia) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (alumnoDao.existsById(nia))
		{
			exito = true;
			alumnoDao.deleteById(nia);
		}
		
		return exito;
	}

	@Override
	public boolean actualizarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (alumnoDao.existsById(alumno.getNia()))
		{
			exito = true;
			alumnoDao.save(alumno);
		}
		
		return exito;
	}

	@Override
	public boolean insertarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!alumnoDao.existsById(alumno.getNia()))
		{
			exito = true;
			alumnoDao.save(alumno);
		}
		
		return exito;
	}
}
