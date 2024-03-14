package org.dam2.mongonoticias.controlador;

import java.util.List;
import java.util.Optional;

import org.dam2.mongonoticias.modelo.Usuario;
import org.dam2.mongonoticias.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongonoticias/usuario")
public class UsuarioControlador {
	
	@Autowired private IUsuarioServicio usuarioServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Usuario>> obtenerTodosUsuarios ()
	{
		ResponseEntity<List<Usuario>> response;
		List<Usuario> todos;
		
		todos = (List<Usuario>) usuarioServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}

	@GetMapping ("/consultar/{nickName}")
	public ResponseEntity<Usuario> obtenerCliente (@PathVariable String nickName)
	{
		ResponseEntity<Usuario> response;
		Optional<Usuario> usuario;
		
		usuario = usuarioServicio.findByNickName(nickName);
		
		if (usuario.isPresent())
			response = new ResponseEntity<>(usuario.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Usuario> insertarUsuario (@RequestBody Usuario usuario)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!usuarioServicio.insertar(usuario))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(usuario,status);
	}
	

}
