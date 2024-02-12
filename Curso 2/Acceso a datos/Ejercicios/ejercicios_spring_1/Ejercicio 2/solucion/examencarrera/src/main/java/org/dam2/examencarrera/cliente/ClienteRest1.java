package org.dam2.examencarrera.cliente;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
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

public class ClienteRest1 {

	final static String URLBASE = "http://localhost:8080/carreras";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dorsal;
		
		CorredorDto corredor = leerCorredor ();
		Optional<CarreraDto> carrera = leerCarrera (corredor);
		
		if (carrera.isPresent())
		{
			dorsal = inscribirCorredorCarrera (corredor, carrera.get());
			
			System.out.println(corredor.getNombre() + " ha sido inscrito en carrera "+ 
								carrera.get().getNombre() + " con el dorsal " + dorsal);
		}
		else
			System.out.println("corredor no inscrito");

	}

	private static CorredorDto leerCorredor() {
		// TODO Auto-generated method stub
		
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CorredorDto> response;
		String URL = URLBASE + "/corredor/consultar/{dni}";
		
		CorredorDto corredor;
		corredor = CorredorDto.builder().
						dni(Teclado.leerString("\ndni:")).
						build();
		
		try {
			response = restTemplate.getForEntity(URL, CorredorDto.class, corredor.getDni());
			corredor = response.getBody();
		}
		catch (RestClientException e)
		{
			corredor.setNombre(Teclado.leerString("\nnombre"));
			corredor.setSexo(Teclado.leerString("\nHombre?").equalsIgnoreCase("s"));
			// insertar corredor en bbdd
		}
		
		
		return corredor;
	}

	private static Optional<CarreraDto> leerCarrera(CorredorDto corredor) {
		// TODO Auto-generated method stub
		Optional<CarreraDto> carrera;
		CarreraDto[] carreras;
		String nombre;
		int cual;
		
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <CarreraDto[]> response;
		String URL = URLBASE + "/carrera/consultarcarrerasdisponibles/{dni}";
		
		try {
			response = restTemplate.getForEntity(URL, CarreraDto[].class, corredor.getDni());
			carreras = response.getBody();
			
			do
			{
				Arrays.stream(carreras).map(CarreraDto::getNombre).forEach(System.out::println);
				nombre = Teclado.leerString("\nElegir una carrera");
				cual = Arrays.asList(carreras).indexOf(new CarreraDto (nombre));

			}while (cual < 0);
			
			carrera = Optional.of(carreras[cual]);
		}
		catch (RestClientException e)
		{
			System.out.println("Error obteniendo lista de carreras");
			carrera = Optional.empty();
		}
		
		
		
		return carrera;
	}

	private static int inscribirCorredorCarrera(CorredorDto corredor, CarreraDto carrera) {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Integer> response;
		String URL = URLBASE + "/carrera/inscribir";

		Integer dorsal =0;
		CarreraConCorredorCompletoDto carreraCorredor = CarreraConCorredorCompletoDto.builder().
												carreraNombre(carrera.getNombre()).
												corredor(corredor).
												build();
		
		try {
			dorsal = restTemplate.postForObject(URL, carreraCorredor,Integer.class);
		
		}
		catch (RestClientException e)
		{
			System.out.println("error inscribiendo corredor");
		}
		
		
		return dorsal;
	}

}
