import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EjemploAlumnoOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<AlumnoConOptional> alumnos = cargarAlumnos();
		Optional<AlumnoConOptional> alumno;
		String nombre;
		
		// Mostrar todos los alumnos
		alumnos.forEach(System.out::println);
		
		
		// Buscar un alumno por nombre y mostrarlo
		nombre = Teclado.leerString("nombre del alumno a buscar: ");
		System.out.println("alumno buscado");
		alumno = buscarAlumno(alumnos, nombre);
		System.out.println(alumno.map(AlumnoConOptional::toString).orElse("No existe el alumno"));
		
		// Buscar un alumno por nombre y mostrar su fecha de nacimiento
		System.out.println("fecha de nacimiento del alumno buscado");
		alumno = buscarAlumno(alumnos, nombre);
		
		System.out.println(alumno.isPresent() // Comporar si existe el alumno
									?// El alumno está en la lista
									alumno.flatMap (AlumnoConOptional::getFecha). // Obtener la fecha, es un optional
												map(LocalDate::toString).orElse("SIN DATOS") // comprobar si hay datos de la fecha
									:// El alumno no está en la lista
									"Alumno no está en lista");
	}
	
	public static Optional<AlumnoConOptional> buscarAlumno (List<AlumnoConOptional> lista, String nombre)
	{
		
		List <AlumnoConOptional> copia = new ArrayList<>(lista); 
		
		copia.removeIf (a -> !a.getNombre().equals(nombre));
		
		
		return copia.isEmpty() ? Optional.empty(): Optional.of(copia.get(0));
	
	}
	
	public static List<AlumnoConOptional> cargarAlumnos ()
	{
		List <AlumnoConOptional> alumnos = new ArrayList<>();
		AlumnoConOptional alumno;
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos1.csv")) )
		{
			
			while (fichero.ready())
			{
				alumno = AlumnoConOptional.fromCSV(fichero.readLine());
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
