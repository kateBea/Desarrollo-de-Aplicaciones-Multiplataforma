package org.dam2.examenspring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.dam2.examenspring.model.Pieza;
import org.dam2.examenspring.service.PiezaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/taller/piezas")
public class PiezaController {

	@Autowired
	PiezaServ piezaServ;
	
	@GetMapping("consultar")
	public ResponseEntity<List<Pieza>> consultar() {
		ResponseEntity<List<Pieza>> respuesta = null;
		
		List<Pieza> piezas = piezaServ.consultarTodos().stream().
			collect(Collectors.toList());
		respuesta = new ResponseEntity<>(piezas, HttpStatus.OK);
		
		return respuesta;
	}
}
