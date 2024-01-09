package org.utilidades;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.app.Contexto;
import org.instituto.Direccion;
import org.instituto.Email;
import org.instituto.Estudiante;
import org.instituto.Instituto;
import org.instituto.Persona;
import org.instituto.Profesor;
import org.instituto.TipoEstudio;

public class LecturaConsola {
	public static Persona leerPersona() {
		final String tipoPersona = Input.leerCadena("Introduce el tipo de integrante (P -> Profesor, E -> Estudiante)");
		
		
		return switch (tipoPersona) {
			case "P" -> leerProfesor();
			case "E" -> leerEstudiante();
			default -> null;
		};
	}
	
	public static Estudiante leerEstudiante() {
		Estudiante resultado = null;
		
		final String nif = Input.leerCadena("NIF: ");
		if (Contexto.getDaoEstudiante().findById(nif).isPresent()) {
			System.err.println("El estudiante con NIF " + nif + " ya existe.");
			
			// Ver NOTA 1 en leerProfesor()
			return null;
		}
		
		final String nombre = Input.leerCadena("Nombre: ");
		final String poblacion = Input.leerCadena("Población: ");
		final String nacimiento = Input.leerCadena("Fecha nacimiento (YYYY-MM-DD): ");
		
		final Set<Email> emails = leerEmails();
		
		final String curso = Input.leerCadena("Curso: ");
		final String grupo = Input.leerCadena("Grupo: ");
		final String esDelegado = Input.leerCadena("¿Es delegado? (S/n): ");
		final String tipoEstudios = Input.leerCadena("Estudios (ESO, BACH, FPS, FPM): ");
		
		resultado = Estudiante.builder()
			.nif(nif)
			.nombre(nombre)
			.poblacion(poblacion)
			.fechaNacimiento(LocalDate.parse(nacimiento))
			.emails(emails)
			.curso(curso)
			.grupo(grupo)
			.delegado(esDelegado.equalsIgnoreCase("S"))
			.tipoEstudios(TipoEstudio.fromStr(tipoEstudios))
			.build();
		
		return resultado;
	}
	
	private static Set<Email> leerEmails() {
		Set<Email> emails = new TreeSet<Email>();
		
		final Integer limit = Input.leerEntero("Introduce el total de emails: ");
		
		if (limit != null) {
			for (int count = 0; count < limit; ++count) {
				final String tipo = Input.leerCadena("Tipo de email: ");
				final String direccion = Input.leerCadena("Dirección de correo: ");
				
				Optional<Email> result = Contexto.getDaoEmail().findById(direccion);
				
				emails.add(result.orElse(Email.builder().tipo(tipo).direccion(direccion).build()));
			}
		}
		
		
		return emails;
	}

	public static Profesor leerProfesor() {
		Profesor resultado = null;
		
		final String nif = Input.leerCadena("NIF: ");
		if (Contexto.getDaoProfesor().findById(nif).isPresent()) {
			System.err.println("El profesor con NIF " + nif + " ya existe.");
			
			// NOTA 1: Si los profesores pueden estar en más de un isntituto
			// en vez de retornar null retornamos Contexto.getDaoProfesor().findById(nif).get()
			// este profesor (ya existente) es el que se va a retornar. Los
			// mismo aplica para estudiantes.
			return null;
		}
		
		final String nombre = Input.leerCadena("Nombre: ");
		final String poblacion = Input.leerCadena("Población: ");
		final String nacimiento = Input.leerCadena("Fecha nacimiento (YYYY-MM-DD): ");
		
		final String nombreDpt = Input.leerCadena("Nombre departamento: ");
		final String despacho = Input.leerCadena("Nombre despacho: ");
		
		resultado = Profesor.builder()
			.nif(nif)
			.nombre(nombre)
			.poblacion(poblacion)
			.fechaNacimiento(LocalDate.parse(nacimiento))
			.nombreDept(nombreDpt)
			.despacho(despacho)
			.build();
		
		return resultado;
	}
	
	public static Instituto leerInstituto() {
		Instituto insti = null;
		
		// Leer datos del instituto
		final String codigo = Input.leerCadena("Código de instituto: ");
		
		if (Contexto.getDaoInstituto().findById(codigo).isPresent()) {
			System.err.println("El instituto con código " + codigo + " ya existe.");
			return insti;
		}
		
		final String nombre = Input.leerCadena("Nombre de instituto: ");
		final String telefono = Input.leerCadena("Teléfono de instituto: ");
		
		final String cp = Input.leerCadena("Código postal: ");
		final String poblacion = Input.leerCadena("Población: ");
		final String calle = Input.leerCadena("Calle: ");
			
		// Leer integrantes
		String seguir = null;
		Set<Persona> personas = new TreeSet<>();
		do {
			Persona resultado = leerPersona();
			
			if (resultado != null) {
				personas.add(resultado);
			} else {
				System.err.println("Persona inválida");
			}
			
			seguir = Input.leerCadena("Leer otro integrante (S/n)");
		} while (seguir.equalsIgnoreCase("S"));
		
		insti = Instituto.builder()
			.codigo(codigo)
			.nombre(nombre)
			.telefono(telefono)
			.direccion(Direccion.builder().
				cp(cp).
				poblacion(poblacion).
				calle(calle).
				build())
			.integrantes(personas)
			.build();
		
		return insti;
	}
}
