package org.utilidades;

import org.instituto.Estudiante;
import org.instituto.Persona;
import org.instituto.Profesor;

public class LecturaConsola {
	public static Persona leer() {
		final String tipoPersona = Input.leerCadena("Introduce el tipo de integrante (P -> Profesor, E -> Estudiante)");
		
		return switch (tipoPersona) {
			case "P" -> leerProfesor();
			case "E" -> leerEstudiante();
			default -> null;
		};
	}
	
	public static Estudiante leerEstudiante() {
		Estudiante resultado = null;
		
		
		return resultado;
	}
	
	public static Profesor leerProfesor() {
		Profesor resultado = null;
		
		
		return resultado;
	}
}
