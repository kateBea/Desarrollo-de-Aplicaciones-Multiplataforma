package org.dam2.noticias.clienteREST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class HacerQuerys {

	final static String URLBASE = "http://localhost:8080/noticias/utilidades";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UtilidadesCliente.cargarDatos ();
		query1 ();

	}
	
	private static void query1() {
		// TODO Auto-generated method stub
		String URLQUERY1 = URLBASE + "/query1";
		RestTemplate restTemplate = new RestTemplate();
		String mensaje;
		
		try
		{
			
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLQUERY1, String.class);
			
			mensaje = response.getBody();
			
		}
		catch(HttpClientErrorException e)
		{
			mensaje = "error cargando datos..." + e.getStatusCode();
		}
		
		System.out.println(mensaje);
		
		
	}

	

}
