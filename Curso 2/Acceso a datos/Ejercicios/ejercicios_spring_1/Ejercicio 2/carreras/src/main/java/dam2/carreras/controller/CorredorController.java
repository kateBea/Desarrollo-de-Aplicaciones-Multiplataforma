package dam2.carreras.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.carreras.model.Corredor;
import dam2.carreras.service.ICorredorService;

@RestController
@RequestMapping("carreras/corredores")
public class CorredorController {

	@Autowired
	ICorredorService service;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Corredor>> consultarTodos() {
		List<Corredor> todas = service.buscarTodos().stream()
			.collect(Collectors.toList());
		
		return new ResponseEntity<>(todas, HttpStatus.OK);
	}
}
