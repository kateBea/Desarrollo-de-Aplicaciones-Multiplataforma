package ejercicios_basicos_4.lambdas_y_colecciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EjercicioLambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Alumno> alumnos;
		Comparator<Alumno> comparador1,comparador2, comparador3;
		final Set<String> cursos;
		String curso;

		// Cargar alumnos
		alumnos = cargarAlumnos ();
		
		alumnos.forEach(System.out::println);
		
		// ordenar por nombre
		comparador1 = (a,b) -> a.getNombre().compareToIgnoreCase(b.getNombre());
		alumnos.sort(comparador1);
		
		// ordenar por nombre inverso
		alumnos.sort(comparador1.reversed());
		
		// ordenar por fecha y nombre
		comparador2 = (a,b) -> a.getFecha().compareTo(b.getFecha());
		
		alumnos.sort(comparador2.thenComparing(comparador1));
		
		// ordenar por curso y nota
		comparador3 = (a,b) -> Float.compare(a.getNota(), b.getNota());
		alumnos.sort(comparador3.thenComparing(comparador2));
		
		cursos = new HashSet<String> ();
		
		alumnos.forEach((a) -> cursos.add(a.getCurso()));
		
		// Crear stream a partir de lista
		Stream <Alumno> streamAlumno = alumnos.stream();
		
		
		
		// lectura del curso
		do
		{
			curso = Teclado.leerString("curso");		
		}while (!cursos.contains(curso));
		
		String cursoActual = curso;
		
		Predicate <Alumno> predicado1 = (a) -> a.getCurso().equals(cursoActual);
		Predicate <Alumno> predicado2 = Alumno::estaAprobado;
		
		List <Alumno> copiaAlumnos = new ArrayList<>(alumnos);
		copiaAlumnos.removeIf(predicado1.negate().and(predicado2.negate()));
		
		copiaAlumnos.forEach(a-> Pantalla.escribirString(a.getNombre() + " " + a.getNota() + "\n"));

		/*
		alumnos.sort(comparador2);
		Pantalla.escribirString(alumnos.get(0) + "\n");
		Pantalla.escribirString(alumnos.get(alumnos.size()-1) + "\n");
		*/
		Pantalla.escribirString(Collections.max(alumnos, comparador2)+"\n");
		Pantalla.escribirString(Collections.min(alumnos, comparador2)+"\n");
	}
	
	public static List<Alumno> cargarAlumnos ()
	{
		List <Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno;
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos.csv")) )
		{
			
			while (fichero.ready())
			{
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}
			
		}
		
		catch (IOException e)
		{
			Pantalla.escribirString("\nError accediendo al fichero...");
			
		}
		
		return alumnos;
	}

}
