package dam2.biblioteca.controlador;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dam2.biblioteca.modelo.Ejemplar;
import dam2.biblioteca.servicio.IEjemplarServ;

@RestController
@RequestMapping(value = "biblioteca/ejemplares")
public class EjemplarControlador {
	
	@Autowired
	IEjemplarServ ejemplarServ;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Ejemplar>> consultarEjemplares() {
		Set<Ejemplar> usuarios= ejemplarServ.consultarTodos();
		return new ResponseEntity<>(usuarios.stream().collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@GetMapping("/consultar/libres/{isbn}")
	public ResponseEntity<List<Ejemplar>> consultarEjemplaresLibresDe(@RequestParam String isbn) {
		Set<Ejemplar> usuarios= ejemplarServ.ejemplaresDisponiblesDe(isbn);
		return new ResponseEntity<>(usuarios.stream().collect(Collectors.toList()), HttpStatus.OK);
	}
}
