package org.dam2.noticias.controlador;

import java.util.List;

import org.dam2.noticias.modelo.Comentario;
import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.servicio.IComentarioServicio;
import org.dam2.noticias.servicio.INoticiaServicio;
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
@RequestMapping("noticias/comentario")
public class ComentarioControlador {
	
	@Autowired private INoticiaServicio noticiaServicio;
	@Autowired private IComentarioServicio comentarioServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Comentario>> obtenerTodosComentarios ()
	{
		ResponseEntity<List<Comentario>> response;
		List<Comentario> todos;
		
		todos = (List<Comentario>) comentarioServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}
	
	@GetMapping ("/consultarpornoticia/{titulo}")
	public ResponseEntity<List<Comentario>> obtenerComentariosPorNoticia (@PathVariable String titulo)
	{
		ResponseEntity<List<Comentario>> response;
		List<Comentario> comentarios;
		
		comentarios = (List<Comentario>) comentarioServicio.findByNoticia(titulo);
		
		response = new ResponseEntity<>(comentarios,HttpStatus.OK);
		
		
		return response;
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Comentario> insertarComentario (@RequestBody Comentario comentario)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		
		comentario = comentarioServicio.insertar(comentario);
		
		if (comentario.getId() == 0)
			status = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(comentario,status);
	}

	

}
