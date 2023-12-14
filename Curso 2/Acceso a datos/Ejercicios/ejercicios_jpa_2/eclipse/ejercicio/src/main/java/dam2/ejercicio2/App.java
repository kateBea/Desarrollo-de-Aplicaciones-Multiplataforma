package dam2.ejercicio2;

import utilidades_hibernate.GenericJPADAO;

public class App {

	public static void main(String... args) {		
		// creamos conexión a la BD
		final GenericJPADAO <Alumno, String> daoAlumno = new GenericJPADAO<>(Alumno.class, "dam2.ejercicio2");
		
		

	}

}
