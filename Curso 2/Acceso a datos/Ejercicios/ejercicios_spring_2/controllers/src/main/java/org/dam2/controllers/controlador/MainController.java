package org.dam2.controllers.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.controllers.modelo.Cliente;
import org.dam2.controllers.servicio.ClienteServicio;
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
// Nombre de tu aplicación
@RequestMapping("app")
public class MainController {
	@Autowired
	ClienteServicio servicio;
	
	
	@GetMapping("inicio")
	ResponseEntity<String> greeting() {
		return new ResponseEntity<>("Hola Mundo", HttpStatus.OK);
	}
	
	@GetMapping("consultar")
	ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<>(servicio.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("cargardatos")
	ResponseEntity<String> cargarDatos() {
		
		Stream.of(
			Cliente.builder().
				nif("12345678A").
				nombre("Juan Perez").
				aval(1000.0f).
				build(),
			Cliente.builder().
				nif("87654321B").
				nombre("María López").
				aval(1500.0f).build(),
			Cliente.builder().
				nif("98765432C").
				nombre("Pedro Martinez").
				aval(2000.0f).
				build(),
			Cliente.builder().
				nif("23456789D").
				nombre("Ana García").
				aval(1800.0f).
				build(),
			Cliente.builder().
				nif("34567890E").
				nombre("Luisa Fernández").
				aval(2200.0f).
				build())
			.forEach(cl -> servicio.insertar(cl));
		
		return new ResponseEntity<String>("Datos cargados", HttpStatus.OK);
	}
	
	@GetMapping("consultar/{nif}")
	ResponseEntity<Cliente> consultarPorNif(@PathVariable String nif) {
		ResponseEntity<Cliente> respuesta;
		
		Optional<Cliente> resultado = servicio.findById(nif);
		
		if (resultado.isPresent()) {
			respuesta = new ResponseEntity<>(resultado.get(), HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@PostMapping("insertar")
	ResponseEntity<Cliente> insertar(@RequestBody Cliente cliente) {
		ResponseEntity<Cliente> respuesta;
		Optional<Cliente> resultado = servicio.insertar(cliente);
		
		if (resultado.isPresent()) {
			respuesta = new ResponseEntity<>(resultado.get(), HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return respuesta;
	}
	
	@PutMapping("actualizar")
	ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente) {
		ResponseEntity<Cliente> respuesta;
		Optional<Cliente> resultado = servicio.actualizar(cliente);
		
		if (resultado.isPresent()) {
			respuesta = new ResponseEntity<>(resultado.get(), HttpStatus.OK);
		} else {
			respuesta = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@PutMapping("borrar")
	ResponseEntity<Boolean> borrar(@RequestParam String cliente) {
		boolean resultado = servicio.borrar(cliente);
		
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}
}
