package interfacesFuncionales;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EscribirAlumnoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <Alumno> alumnos;
		List <Alumno> ordenados;
		Comparator <Alumno> comparador;
		Consumer <Alumno> consumidor;
		
		
		// leer alumnos del teclado
		alumnos = cargarAlumnos ();
		
		// Ordenar alumnos
		ordenados = new ArrayList<Alumno>();
		ordenados.addAll(alumnos);
		
		comparador = new ComparadorPorNombre ();
		//comparador = (a,b) -> a.getNombre().compareToIgnoreCase(b.getNombre());
				
		ordenados.sort(comparador);
		
		
		
		
		
		
		// Mostrar alumnos ordenados por pantalla
		consumidor = new MostrarEnPantalla();
		//consumidor = a -> Pantalla.escribirString("\n" + a);
		ordenados.forEach(consumidor);
		
		// Escribir alumnos en fichero CSV		
		try (PrintWriter fichero = new PrintWriter(new FileWriter("alumnos.csv")))
		{
			consumidor = new EscribirEnFicheroCSV (fichero);
			//consumidor = a -> fichero.print(a.toCSV());
			ordenados.forEach(consumidor);
		}
		catch (IOException e)
		{
			Pantalla.escribirString("\nError escribiendo fichero");
		}
		
	}
	
	public static Set <Alumno> cargarAlumnos ()
	{
		HashSet <Alumno> alumnos = new HashSet<Alumno> ();
		Alumno alumno;
		boolean insertado;
		
		do
		{
			alumno = new Alumno ();
			insertado = false;
			do
			{
				alumno.leerClave();
				
				if (alumnos.add(alumno))
					insertado = true;
				else
					Pantalla.escribirString("\nAlumno ya existente\n");
				
				
			}while (!insertado);
			
			alumno.leerOtrosDatos();
			
		}while (Teclado.leerString("otro alumno? (S/N)").equalsIgnoreCase("S"));
		
		return alumnos;
		
	}
	

}
