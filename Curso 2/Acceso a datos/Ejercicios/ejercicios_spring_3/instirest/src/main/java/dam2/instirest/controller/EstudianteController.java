package dam2.instirest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.instirest.model.Estudiante;
import dam2.instirest.service.EstudianteServ;

@RestController
@RequestMapping("/instituto/estudiantes")
public class EstudianteController {

	@Autowired
	EstudianteServ estudianteServ;
	
	@GetMapping("consultar")
	ResponseEntity<List<Estudiante>> consultar() {
		ResponseEntity<List<Estudiante>> respuesta = null;
		
		Set<Estudiante> estudiantes = estudianteServ.consultarTodos();
		respuesta = new ResponseEntity<>(estudiantes.stream().toList(), HttpStatus.OK);
		
		return respuesta;
	}
}
