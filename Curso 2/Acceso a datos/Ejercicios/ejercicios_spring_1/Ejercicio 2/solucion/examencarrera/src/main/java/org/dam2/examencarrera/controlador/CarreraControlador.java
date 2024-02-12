package org.dam2.examencarrera.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraConCorredorCompletoDto;
import org.dam2.examencarrera.modelo.dto.CarreraCorredorDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.servicio.ICarreraCorredorServicio;
import org.dam2.examencarrera.servicio.ICarreraServicio;
import org.dam2.examencarrera.servicio.ICorredorServicio;
import org.dam2.examencarrera.servicio.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carreras/carrera")
public class CarreraControlador {
	
	@Autowired ICorredorServicio corredorServicio;
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICarreraCorredorServicio carreraCorredorServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<CarreraDto>> obtenerTodasCorrerras ()
	{
		ResponseEntity<List<CarreraDto>> response;
		List<CarreraDto> todos;
		
		todos = carreraServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}

	
	@GetMapping ("/consultar/{nombre}")
	public ResponseEntity<CarreraDto> obtenerCarrera (@PathVariable String nombre)
	{
		ResponseEntity<CarreraDto> response;
		Optional<CarreraDto> carrera;
		
		carrera = carreraServicio.findByNombre(nombre);
		
		if (carrera.isPresent())
			response = new ResponseEntity<>(carrera.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}
	
	@GetMapping ("/consultarcorredores/{nombre}")
	public ResponseEntity<List<CorredorDto>> obtenerCorredores (@PathVariable String nombre)
	{
		ResponseEntity<List<CorredorDto>> response;
		List<CorredorDto> corredores;
		Optional<CarreraDto> carrera;
		
		carrera = carreraServicio.findByNombre(nombre);
		
		if (carrera.isPresent())
		{
			corredores = carreraServicio.obtenerCorredores (nombre);
			response = new ResponseEntity<>(corredores,HttpStatus.OK);
		}
		else
		{
			corredores = new ArrayList<>();
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return response;
	}
	
	@PostMapping("/inscribir")
	public ResponseEntity<Integer> inscribirCorredor (@RequestBody CarreraConCorredorCompletoDto carreraCorredorDto)
												
	{
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		int dorsal = 0;
		
 		
		CorredorDto corredor = carreraCorredorDto.getCorredor();
		
		CarreraDto carrera = CarreraDto.builder().
								nombre(carreraCorredorDto.getCarreraNombre()).
								build();
		
		try {
		dorsal = carreraCorredorServicio.insertarCorredorCarrera(corredor, carrera);
		if (dorsal > 0)
			status = HttpStatus.CREATED;
		}
		catch (RollBackException ex)
		{
			System.out.println(ex.getMensaje());
		}
		
		return new ResponseEntity<>(dorsal,status);
	}

	@PutMapping("/anotartiempo")
	public ResponseEntity<String> anotarTiempo (@RequestBody CarreraCorredorDto carreraCorredorDto)
	{
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String resultado = "no se ha podido anotar tiempo al corredor ";
		CorredorDto corredor = CorredorDto.builder().
				dni(carreraCorredorDto.getCorredorDni()).
				build();

		CarreraDto carrera = CarreraDto.builder().
				nombre(carreraCorredorDto.getCarreraNombre()).
				build();
		
		
		int tiempo = carreraCorredorDto.getTiempo();
		
		
		if (carreraCorredorServicio.anotarTiempoCorredorCarrera(corredor, carrera, tiempo))
		{
			status = HttpStatus.ACCEPTED;
			resultado = "tiempo anotado al corredor ";
		}
		
		return new ResponseEntity<>(resultado +  corredor.getNombre(),status);
	}
	
	@GetMapping ("/consultarcarrerasdisponibles/{dni}")
	public ResponseEntity<List<CarreraDto>> carrerasDisponiblesPorCorredor (@PathVariable String dni)
	{
		ResponseEntity<List<CarreraDto>> response;
		List<CarreraDto> carreras;
	
		carreras = carreraServicio.carrerasDisponiblesPorCorredor(dni);
		
		response = new ResponseEntity<>(carreras,HttpStatus.OK);
		
		
		return response;
	}
	
	
	@GetMapping ("/consultarmasantigua")
	public ResponseEntity<List<CorredorDto>> obtenerCorredoresMasAntigua ()
	{
		ResponseEntity<List<CorredorDto>> response;
		List<CorredorDto> corredores;
		
		
		corredores = carreraServicio.clasificacionCarreraMasAntigua();
		response = new ResponseEntity<>(corredores,HttpStatus.OK);
		
		return response;
	}
}
