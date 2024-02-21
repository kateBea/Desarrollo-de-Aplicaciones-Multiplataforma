package dam2.biblioteca.controlador;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.biblioteca.modelo.Prestamo;
import dam2.biblioteca.servicio.IPrestamoServ;

@RestController
@RequestMapping(value = "biblioteca/prestamos")
public class PrestamoControlador {
	
	@Autowired
	IPrestamoServ prestamoServ;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Prestamo>> consultarUsuarios() {
		Set<Prestamo> usuarios= prestamoServ.consultarTodos();
		return new ResponseEntity<>(usuarios.stream().collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Prestamo> registrar(@RequestBody Prestamo prestamo) {
		ResponseEntity<Prestamo> respuesta = null;
		
		Optional<Prestamo> result = prestamoServ.insertar(prestamo);
		
		if (result.isEmpty()) {
			respuesta = new ResponseEntity<Prestamo>(prestamo, HttpStatus.BAD_REQUEST);
		} else {
			respuesta = new ResponseEntity<Prestamo>(result.get(), HttpStatus.OK);
		}
		
		return respuesta;
	}
}
