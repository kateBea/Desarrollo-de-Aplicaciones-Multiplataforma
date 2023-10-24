package ejemplos_de_uso.ejemplos_profe_colecciones;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Teclado;

public class AppColecciones {

	public static void main(String[] args) {
		Set<Alumno> alumnos,copia;
		Alumno alumno;
		
		alumnos = new TreeSet <>();
		
		// leer los alumnos
		
		do
		{
			
			alumno = new Alumno ();
			do
			{
				alumno.leerClave();
			}while (!alumnos.add(alumno));
			
			alumno.leerOtrosDatos();
			
		}while (Teclado.leerString("más?").equalsIgnoreCase("s"));
		
		Consumer<Alumno> consumidor;
		// Mostrar todos los alumnos
		/*
		for (Alumno a: alumnos)
			System.out.println(a);
		
		consumidor = new EscribirEnPantalla();
		
		alumnos.forEach(consumidor);
		*/
		consumidor = a -> System.out.println(a);
		alumnos.forEach(consumidor);
		
		
		// Listar los mayores de edad
		copia = new TreeSet<>(alumnos);
		
		/*
		for (Alumno a: copia)
			if (a.getEdad() < 18)
				copia.remove(a);
		*/
		
		Predicate<Alumno> menorDeEdad = a -> a.getEdad() < 18;
		//menorDeEdad = new MenorDeEdad();
		copia.removeIf(menorDeEdad);
		
		copia.forEach(consumidor);
		
		
		//alumnos.stream().filter(menorDeEdad).forEach(consumidor);
	}

}
