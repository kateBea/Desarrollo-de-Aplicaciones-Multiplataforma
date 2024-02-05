package org.dam2.noticias.controlador;

import java.util.List;
import java.util.Optional;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.servicio.INoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("noticias/noticia")
public class NoticiaControlador {
	
	@Autowired private INoticiaServicio noticiaServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Noticia>> obtenerTodoasNoticias ()
	{
		ResponseEntity<List<Noticia>> response;
		List<Noticia> todos;
		
		todos = (List<Noticia>) noticiaServicio.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}

	@GetMapping ("/consultar/{id}")
	public ResponseEntity<Noticia> obtenerNoticia (@PathVariable Long id)
	{
		ResponseEntity<Noticia> response;
		Optional<Noticia> noticia;
		
		
		noticia = noticiaServicio.findById(id);
		response = noticia.isPresent()?
							new ResponseEntity<>(noticia.get(),HttpStatus.OK): 
							new ResponseEntity<>(HttpStatus.NOT_FOUND);
							
		
		return response;
	}
	
	
	@GetMapping ("/consultarporcategoria")
	public ResponseEntity<List<Noticia>> obtenerNoticiasPorCategoria (@RequestParam Categoria categoria)
	{
		ResponseEntity<List<Noticia>> response;
		List<Noticia> noticias;
		
		noticias = (List<Noticia>) noticiaServicio.findByCategoria(categoria);
		
		response = new ResponseEntity<>(noticias,HttpStatus.OK);
		
		
		return response;
	}

	@PostMapping("/insertar")
	public ResponseEntity<Noticia> insertarNoticia (@RequestBody Noticia noticia)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		noticia = noticiaServicio.insertar(noticia);
		
		if (noticia.getId() == 0)
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(noticia,status);
	}
	
	@DeleteMapping("/eliminarnoticiasnocomentadas")
	public ResponseEntity<Integer> eliminarNoticiasNoComentadas ()
	{
		HttpStatus status = HttpStatus.OK;
		
		return new ResponseEntity<>(noticiaServicio.borrarSinComentarios(),status);
	}
}
