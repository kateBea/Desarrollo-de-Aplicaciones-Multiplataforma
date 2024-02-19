package org.dam2.examenspring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.dam2.examenspring.model.Mecanico;
import org.dam2.examenspring.service.MecanicoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/taller/mecanicos")
public class MecanicoController {
	@Autowired
	MecanicoServ mecanicoServ;
	
	@GetMapping("consultar")
	public ResponseEntity<List<Mecanico>> consultar() {
		ResponseEntity<List<Mecanico>> respuesta = null;
		
		List<Mecanico> mecanicos = mecanicoServ.consultarTodos().stream().
			collect(Collectors.toList());
		respuesta = new ResponseEntity<>(mecanicos, HttpStatus.OK);
		
		return respuesta;
	}
}
