package dam2.ejercicio2;

import java.util.function.Consumer;
import java.util.function.Function;

import utilidades_hibernate.GenericJPADAO;

public class App {

	public static void main(String... args) {		
		// creamos conexión a la BD
		final GenericJPADAO <Alumno, String> daoAlumno = new GenericJPADAO<>(Alumno.class, "dam2.ejercicio2");

	}

}
