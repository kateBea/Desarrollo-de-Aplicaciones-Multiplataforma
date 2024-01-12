package org.dam2.grupoalumno.clientesrest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



public class ClienteRest {

	final static String URLBASE = "http://localhost:8080/grupos";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarDatos ();
		
		consultarDatos ();
		
		addAlumnoEnGrupo ();
		
		consultarDatos ();

	}

	private static void addAlumnoEnGrupo() {
		// TODO Auto-generated method stub
		String URLINSERTARALUMNO = URLBASE + "/alumno/insertaralumno/{idgrupo}";
		RestTemplate restTemplate = new RestTemplate();
		List<String> ids;
		String idgrupo;
		Alumno alumno = new Alumno ();
		
		
		// Pedir lista de idgrupos
		ids = obtenerIds ();
		// Pedir idgrupo y comprobar que exista
		do {
			ids.forEach(System.out::println);
			idgrupo = "DAM1";
		} while (!ids.contains(idgrupo));
		
		
		// Datos del alumno
		// Preguntar primero nia alumno
		do {
			alumno.setNia("005");
		}while (existeAlumno (alumno.getNia()));
		
		// Leer el resto de los datos
		alumno.setNombre("alumno05");
		alumno.setNota(5f);
		alumno.setFechaNacimiento(LocalDate.now());
		// enviar datos para la insercción
		
		try
		{
			restTemplate.postForEntity(URLINSERTARALUMNO,alumno, Alumno.class, idgrupo);
		}
		catch(HttpClientErrorException e)
		{
			System.out.println("Error insertandoa");
			
		}
		
		
	}
	
	

	private static boolean existeAlumno(String nia) {
		// TODO Auto-generated method stub
		boolean existe = true;
		
		String URLBUSCARALUMNOPORID = URLBASE + "/alumno/consultarid/{nia}";
		RestTemplate restTemplate = new RestTemplate();
		
		try
		{
			ResponseEntity<Alumno> response  = 
					restTemplate.getForEntity(URLBUSCARALUMNOPORID, Alumno.class,nia);
			
		}
		catch(HttpClientErrorException e)
		{
			existe = false;
			
		}
		
		return existe;
		
	}

	private static List<String> obtenerIds() {
		// TODO Auto-generated method stub
		String URLLISTAIDS = URLBASE + "/grupo/listarids";
		RestTemplate restTemplate = new RestTemplate();
		List<String> ids;
		
		try
		{
			ResponseEntity<String[]> response  = 
					restTemplate.getForEntity(URLLISTAIDS, String[].class);
			
			ids = Arrays.stream(response.getBody()).toList();
		}
		catch(HttpClientErrorException e)
		{
			ids = new ArrayList<>();
			
		}
		
		return ids;
	}

	private static void consultarDatos() {
		// TODO Auto-generated method stub
		String URLCONSULTARTODOS = URLBASE + "/grupo/consultar";
		RestTemplate restTemplate = new RestTemplate();
		Grupo[] grupos;
		
		try
		{
			
			ResponseEntity<Grupo[]> response  = 
					restTemplate.getForEntity(URLCONSULTARTODOS, Grupo[].class);
			
			grupos = response.getBody();
			System.out.println("Listado de grupos");
			Arrays.stream(grupos).forEach (System.out::println);
		}
		catch(HttpClientErrorException e)
		{
			System.out.println("error recuperando grupos");
			
		}
		
	}

	private static void cargarDatos() {
		// TODO Auto-generated method stub
		String URLCARGARDATOS = URLBASE + "/grupo/cargardatos";
		RestTemplate restTemplate = new RestTemplate();
		String mensaje;
		
		try
		{
			
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLCARGARDATOS, String.class);
			
			mensaje = response.getBody();
			
		}
		catch(HttpClientErrorException e)
		{
			mensaje = "error cargando datos..." + e.getStatusCode();
		}
		
		System.out.println(mensaje);
		
	}

}
