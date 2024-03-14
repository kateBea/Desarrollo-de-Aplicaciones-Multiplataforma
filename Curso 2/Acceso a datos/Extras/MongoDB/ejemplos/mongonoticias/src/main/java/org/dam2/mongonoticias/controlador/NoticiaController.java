package org.dam2.mongonoticias.controlador;

import java.util.List;

import org.dam2.mongonoticias.modelo.Noticia;
import org.dam2.mongonoticias.modelo.Usuario;
import org.dam2.mongonoticias.servicio.INoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mongonoticias/noticia")
public class NoticiaController {
	
	@Autowired private INoticiaServicio noticiaServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Noticia>> obtenerTodasNoticias ()
	{
		ResponseEntity<List<Noticia>> response;
		List<Noticia> todos;
		
		todos = (List<Noticia>) noticiaServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}

	@GetMapping ("/consultar/{titulo}")
	public ResponseEntity<List<Noticia>> obtenerNoticiasPorTitulo (@PathVariable String titulo)
	{
		ResponseEntity<List<Noticia>> response;
		List<Noticia> todos;
		
		todos =  noticiaServicio.buscarPorTitulo(titulo);
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Noticia> insertarUsuario (@RequestBody Noticia noticia)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!noticiaServicio.insertar(noticia))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(noticia,status);
	}
	
}
