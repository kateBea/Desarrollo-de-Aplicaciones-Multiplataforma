package org.dam2.examencarrera.cliente;

import java.util.Arrays;

import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ClienteRest3 {

	final static String URLBASE = "http://localhost:8080/carreras";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CorredorDto[]> response;
		CorredorDto[] corredores = null;
		String URL = URLBASE + "/carrera/consultarmasantigua";
		
		try {
			response = restTemplate.getForEntity(URL, CorredorDto[].class);
			corredores = response.getBody();
			
			Arrays.stream(corredores).forEach(System.out::println);
		}		
				
		catch (RestClientException e)
		{
			System.out.println("Error obteniendo lista de corredores");
		}

		
		

	}

}
