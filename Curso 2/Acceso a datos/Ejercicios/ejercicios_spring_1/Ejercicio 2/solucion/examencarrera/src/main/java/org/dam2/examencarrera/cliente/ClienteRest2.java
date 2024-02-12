package org.dam2.examencarrera.cliente;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import daw.com.Teclado;

public class ClienteRest2 {

	final static String URLBASE = "http://localhost:8080/carreras";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<CarreraDto> carrera = leerCarrera ();
		List<CorredorDto> corredores;
		
		if (carrera.isPresent())
		{
			corredores = corredoresPorCarrera (carrera);
			corredores.forEach(c -> anotarTiempoCorredorCarrera (c,carrera.get()));
		}
		else
			System.out.println("Carrera inexistente");

	}

	
	private static void anotarTiempoCorredorCarrera(CorredorDto corredor, CarreraDto carrera) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CorredorDto[]> response;
		CorredorDto[] corredores = null;
		String URL = URLBASE + "/carrera/anotartiempo";
		
		int tiempo = Teclado.leerInt("\ntiempo de " + corredor.getNombre());
		
		CarreraCorredorDto carreraCorredor = CarreraCorredorDto.builder().
				carreraNombre(carrera.getNombre()).
				corredorDni(corredor.getDni()).		
				tiempo(tiempo).
				build();

		try {
			restTemplate.put(URL, carreraCorredor);
			System.out.println("tiempo anotado correctamente a " + corredor.getNombre());
		}
		catch (RestClientException e)
		{
			System.out.println("error anotando tiempo a " + corredor.getNombre());
		}
		
	}


	private static List<CorredorDto> corredoresPorCarrera(Optional<CarreraDto> carrera) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CorredorDto[]> response;
		CorredorDto[] corredores = null;
		String URL = URLBASE + "/carrera/consultarcorredores/{nombre}";
		
		try {
			response = restTemplate.getForEntity(URL, CorredorDto[].class,carrera.get().getNombre());
			corredores = response.getBody();
		}		
				
		catch (RestClientException e)
		{
			System.out.println("Error obteniendo lista de corredores");
		}
		
		return Arrays.asList(corredores);
	}


	private static Optional<CarreraDto> leerCarrera() {
		// TODO Auto-generated method stub
		Optional<CarreraDto> carrera = Optional.empty();
	
		CarreraDto[] carreras;
		String nombre;
		int cual;
		
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CarreraDto[]> response;
		String URL = URLBASE + "/carrera/consultar";
		
		try {
			response = restTemplate.getForEntity(URL, CarreraDto[].class);
			carreras = response.getBody();
			
		
			Arrays.stream(carreras).map(CarreraDto::getNombre).forEach(System.out::println);
			nombre = Teclado.leerString("\nElegir una carrera");
			cual = Arrays.asList(carreras).indexOf(new CarreraDto (nombre));

			if (cual >= 0)
				carrera = Optional.of(carreras[cual]);
		}
				
		catch (RestClientException e)
		{
			System.out.println("Error obteniendo lista de carreras");
			carrera = Optional.empty();
		}
		
		return carrera;
	}

	
}
