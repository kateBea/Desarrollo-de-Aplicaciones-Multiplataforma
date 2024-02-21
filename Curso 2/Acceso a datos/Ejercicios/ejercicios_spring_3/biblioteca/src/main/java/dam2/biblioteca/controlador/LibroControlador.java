package dam2.biblioteca.controlador;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.biblioteca.modelo.Libro;
import dam2.biblioteca.servicio.ILibroServ;

@RestController
@RequestMapping(value = "biblioteca/libros")
public class LibroControlador {
	
	@Autowired
	ILibroServ libroServ;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Libro>> consultarLibros() {
		Set<Libro> usuarios= libroServ.consultarTodos();
		return new ResponseEntity<>(usuarios.stream().collect(Collectors.toList()), HttpStatus.OK);
	}
}
