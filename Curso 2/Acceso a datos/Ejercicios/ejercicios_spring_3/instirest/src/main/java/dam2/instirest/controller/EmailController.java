package dam2.instirest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.instirest.model.Email;
import dam2.instirest.service.EmailServ;

@RestController
@RequestMapping("/instituto/emails")
public class EmailController {
	@Autowired
	EmailServ emailServ;
	
	@GetMapping("consultar")
	ResponseEntity<List<Email>> consultar() {
		ResponseEntity<List<Email>> respuesta = null;
		
		Set<Email> emails = emailServ.consultarTodos();
		respuesta = new ResponseEntity<>(emails.stream().toList(), HttpStatus.OK);
		
		return respuesta;
	}
}
