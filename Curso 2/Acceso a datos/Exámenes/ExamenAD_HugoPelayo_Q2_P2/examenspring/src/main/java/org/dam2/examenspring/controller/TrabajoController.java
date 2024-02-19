package org.dam2.examenspring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dam2.examenspring.model.Pieza;
import org.dam2.examenspring.model.Trabajo;
import org.dam2.examenspring.model.TrabajoAsignado;
import org.dam2.examenspring.service.PiezaServ;
import org.dam2.examenspring.service.TrabajoAsignadoServ;
import org.dam2.examenspring.service.TrabajoServ;
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
@RequestMapping(value = "/taller/trabajos")
public class TrabajoController {

	@Autowired
	TrabajoServ trabajoServ;
	
	@Autowired
	TrabajoAsignadoServ trabajoAsignadoServ;
	
	@GetMapping("consultar")
	public ResponseEntity<List<Trabajo>> consultar() {
		ResponseEntity<List<Trabajo>> respuesta = null;
		
		List<Trabajo> trabajos = trabajoServ.consultarTodos().stream().
			collect(Collectors.toList());
		respuesta = new ResponseEntity<>(trabajos, HttpStatus.OK);
		
		return respuesta;
	}
	
	@GetMapping("consultarasignaciones")
	public ResponseEntity<List<TrabajoAsignado>> consultarasignaciones() {
		ResponseEntity<List<TrabajoAsignado>> respuesta = null;
		
		List<TrabajoAsignado> asignaciones = trabajoAsignadoServ.consultarTodos().stream().
			collect(Collectors.toList());
		respuesta = new ResponseEntity<>(asignaciones, HttpStatus.OK);
		
		return respuesta;
	}
	
	@GetMapping("consultar/{id}")
	public ResponseEntity<Trabajo> consultar(@PathVariable Long id) {
		ResponseEntity<Trabajo> respuesta = null;
		
		Optional<Trabajo> res = trabajoServ.consultarPorId(id);
		
		if (res.isEmpty()) {
			respuesta = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			respuesta = new ResponseEntity<>(res.get(), HttpStatus.NOT_FOUND);
		}
		
		return respuesta;
	}
	
	@PutMapping("finalizar")
	public ResponseEntity<Trabajo> consultar(@RequestBody Trabajo trabajo) {
		ResponseEntity<Trabajo> respuesta = null;
		
		Optional<Trabajo> res = trabajoServ.consultarPorId(trabajo.getId());
		
		return respuesta;
	}
	
	@PostMapping("registrar")
	public ResponseEntity<TrabajoAsignado> consultar(@RequestParam String desc) {
		ResponseEntity<TrabajoAsignado> respuesta = null;
		
		Optional<Trabajo> res = trabajoServ.insertar(Trabajo.builder().descripcion(desc).build());
		
		
		return respuesta;
	}
}
