package dam2.instirest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.instirest.model.Instituto;
import dam2.instirest.service.InstitutoServ;

@RestController
@RequestMapping("/instituto/institutos")
public class InstitutoController {
	@Autowired
	InstitutoServ institutoServ;
	
	@GetMapping("consultar")
	ResponseEntity<List<Instituto>> consultar() {
		ResponseEntity<List<Instituto>> respuesta = null;
		
		Set<Instituto> institutos = institutoServ.consultarTodos();
		respuesta = new ResponseEntity<>(institutos.stream().toList(), HttpStatus.OK);
		
		return respuesta;
	}
}
