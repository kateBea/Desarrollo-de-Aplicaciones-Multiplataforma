package org.dam2.clavecompuesta;

import java.time.LocalDate;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppClaveCompuestaConRelaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericJPADAO<Alumno,String> alumnoDAO = new GenericJPADAO (Alumno.class, "clavecompuesta");
		GenericJPADAO<Modulo,String> moduloDAO = new GenericJPADAO (Modulo.class, "clavecompuesta");
		GenericJPADAO<Calificacion,CalificacionPK> calificacionDAO = new GenericJPADAO (Calificacion.class, "clavecompuesta");
		
		Alumno alumno = Alumno.builder().dni("001").
						nombre("alumno").
						fechaNacimiento(LocalDate.now()).
						build();
		
		Modulo modulo = Modulo.builder().id("MOD01").nombre("Modulo1").build();
		
		CalificacionPK calificacionPK = CalificacionPK.builder().
						alumno(alumno).
						modulo(modulo).
						build();
		
		Calificacion calificacion = Calificacion.builder().
					calificacionPK(calificacionPK).
					nota(6).
					build();
		
		alumnoDAO.save(alumno);
		moduloDAO.save(modulo);
		
		calificacionDAO.save(calificacion);
		
		
		calificacionDAO.findAll().forEach(System.out::println);
		
	}

}
