package org.dam2.examenspring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.dam2.examenspring.model.Trabajo;
import org.dam2.examenspring.model.TrabajoAsignado;
import org.dam2.examenspring.service.TrabajoAsignadoServImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ClienteRest {
	public static InputStreamReader input = new InputStreamReader(System.in);
	public static BufferedReader reader = new BufferedReader(input);
	
	public static final RestTemplate REST_TEMPLATE = new RestTemplate();
	
	public static final String URLBASE_TRABAJO = "http://localhost:8080/taller/trabajos/";
	
	public static void main(String[] args) {
		int opcion = -1;
		final int SALIR = 4;
		
		do {
			mostrarMenu();
			opcion = leerOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("Registrar trabajo: ");
		System.out.println("Aumentar horas/piezas de trabajo: ");
		System.out.println("Finalizar trabajo: ");
		
	}

	private static void procesarOpcion(int opcion) {
		// TODO Auto-generated method stub
		switch (opcion) {
			case 1 -> {
				String desc = leerCadena("Descripción trabajo: ");
				ResponseEntity<TrabajoAsignado> asignacion = REST_TEMPLATE.postForEntity(URLBASE_TRABAJO + "registrar", null, TrabajoAsignado.class, desc);
			}
			case 2 -> {
						
			}
			case 3 -> {
				String idTrabajo = leerCadena("Id trabajo: ");
				
				ResponseEntity<Trabajo> resupuesta = 
						REST_TEMPLATE.getForEntity(URLBASE_TRABAJO + "consultar/{id}", Trabajo.class, idTrabajo);
				
				// Si existe marcar el trabajo como acabado
				Trabajo tb = resupuesta.getBody();
				REST_TEMPLATE.put(URLBASE_TRABAJO + "finalizar", tb);
				
			}
		}
		
	}

	private static int leerOpcion() {
		// TODO Auto-generated method stub
		return Integer.parseInt(leerCadena("Introduce índice: "));
	}
	
	public static String leerCadena(String prompt) {
		String res = null;
		
		try {
			System.out.print(prompt);
			res = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		return res;
	}
}
