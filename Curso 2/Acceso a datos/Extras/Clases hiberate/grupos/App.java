package org.dam2.grupos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.utilidadeshibernate.GenericJPADAO;

import daw.com.Teclado;

public class App {

	private static GenericJPADAO<Grupo,String> grupoDAO ;
	private static GenericJPADAO<Alumno, String> alumnoDAO;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grupoDAO = new GenericJPADAO(Grupo.class, "grupos");
		alumnoDAO = new GenericJPADAO(Alumno.class, "grupos");
		
		insertarGrupos ();
		insertarAlumno ();
		insertarAlumno ();
		insertarAlumno ();
		
		grupoDAO.findAll().forEach(System.out::println);
		//alumnoDAO.findAll().forEach(System.out::println);

		alumnoDAO.findAll().stream().
			filter(a -> a.getNota() > 5).
			forEach(System.out::println);
	}



	private static void insertarAlumno() {
		// TODO Auto-generated method stub
		String grupo,nia;
		Alumno alumno;
		Optional<Grupo> g;
		
		do
		{
			grupo = Teclado.leerString("grupo");
			g = grupoDAO.findById(grupo);
		}while (!g.isPresent());
		
		do
		{
			nia = Teclado.leerString("\nnia");
		}while (alumnoDAO.findById(nia).isPresent());
		
		
		alumno = Alumno.builder().
				nia(nia).
				nombre("alumno").
				fechaNacimiento(LocalDate.now()).
				nota(6f).
				build();
		
		g.get().getAlumnos().add(alumno);
		
		grupoDAO.update(g.get());
		
	}



	private static void insertarGrupos() {
		// TODO Auto-generated method stub
		Grupo g;
		
		g = Grupo.builder().
				id("DAM1").
				ciclo("DAM").
				curso(1).
				gradoSuperior(true).
				tutor(Tutor.builder().
							dni("001").
							nombre("tutor1").
							sueldo(1000).
							build()).
				build();
		
		grupoDAO.save(g);
		
		g = Grupo.builder().
				id("DAM2").
				ciclo("DAM").
				curso(2).
				gradoSuperior(true).
				tutor(Tutor.builder().
							dni("002").
							nombre("tutor2").
							sueldo(1100).
							build()).
				build();
		
		grupoDAO.save(g);
	}

}
