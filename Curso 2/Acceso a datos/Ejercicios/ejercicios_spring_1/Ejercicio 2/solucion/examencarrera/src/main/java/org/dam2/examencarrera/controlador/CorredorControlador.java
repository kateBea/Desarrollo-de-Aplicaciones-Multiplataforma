package org.dam2.examencarrera.controlador;

import java.util.List;
import java.util.Optional;

import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.servicio.ICorredorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carreras/corredor")
public class CorredorControlador {
	@Autowired ICorredorServicio corredorServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<CorredorDto>> obtenerTodosCorredores ()
	{
		ResponseEntity<List<CorredorDto>> response;
		List<CorredorDto> todos;
		
		todos =  corredorServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		return response;
	}

	
	@GetMapping ("/consultar/{dni}")
	public ResponseEntity<CorredorDto> obtenerCorredor (@PathVariable String dni)
	{
		ResponseEntity<CorredorDto> response;
		Optional<CorredorDto> corredor;
		
		corredor = corredorServicio.findByDNI(dni);
		
		if (corredor.isPresent())
			response = new ResponseEntity<>(corredor.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}


}
