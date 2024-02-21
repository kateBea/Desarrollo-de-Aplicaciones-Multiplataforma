package dam2.biblioteca.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dam2.biblioteca.modelo.Usuario;
import dam2.biblioteca.servicio.IUsuarioServ;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "biblioteca/usuarios")
public class UsuarioControlador {
	
	@Autowired
	IUsuarioServ usuarioServ;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Usuario>> consultarUsuarios() {
		Set<Usuario> usuarios= usuarioServ.consultarTodos();
		return new ResponseEntity<>(usuarios.stream().collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@GetMapping("/consultar/{dni}")
	public ResponseEntity<Usuario> consultarUsuario(@RequestParam String dni) {
		Optional<Usuario> usuario = usuarioServ.buscarPorId(dni);
		ResponseEntity<Usuario> respuesta = null;
		
		if (usuario.isEmpty()) {
			new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		}
		
		return respuesta;
	}
	
}
