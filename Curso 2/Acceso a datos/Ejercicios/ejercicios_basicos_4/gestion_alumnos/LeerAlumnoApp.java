package interfacesFuncionales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Pantalla;

public class LeerAlumnoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <Alumno> alumnos;
		Alumno alumno;
		Predicate <Alumno> predicado;
		Consumer <Alumno> consumidor;
		
		alumnos = new HashSet<> ();
		
		// Leer alumnos de fichero
		try (BufferedReader fichero = new BufferedReader (new FileReader ("alumnos.csv")) )
		{
			
			while (fichero.ready())
			{
				alumno = Alumno.fromCSV(fichero.readLine());
				alumnos.add(alumno);
			}
			
			
			// filtrar alumnos
			predicado = new Aprobado();
			//predicado = Alumno::estaAprobado;
			
			alumnos.removeIf(predicado.negate());
			
			
			
			// mostrar alumnos
			consumidor = new MostrarEnPantalla ();
			//consumidor = System.out::println;
			
			alumnos.forEach(consumidor);

			 
			/* 
			//Usando streams
			fichero.lines(). //Leer el fichero y guardar en un stream de String
					map(Alumno::fromCSV). // convertir cada String en un Alumno
					filter(Alumno::estaAprobado). // filtrar los alumnos que están aprobados
					forEach(System.out::println); // mostrar los alumnos
			*/
		}
		
		catch (IOException e)
		{
			Pantalla.escribirString("\nError accediendo al fichero...");
			
		}
		
		
		
	}

}
