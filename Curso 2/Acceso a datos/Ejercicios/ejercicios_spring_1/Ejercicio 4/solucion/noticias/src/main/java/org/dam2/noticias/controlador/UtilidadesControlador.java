package org.dam2.noticias.controlador;

import java.time.LocalDate;
import java.util.List;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Comentario;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.repositorio.ComentarioRepositorio;
import org.dam2.noticias.servicio.IComentarioServicio;
import org.dam2.noticias.servicio.INoticiaServicio;
import org.dam2.noticias.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("noticias/utilidades")
public class UtilidadesControlador {
	
	@Autowired private INoticiaServicio noticiaServicio;
	@Autowired private IComentarioServicio comentarioServicio;
	@Autowired private IUsuarioServicio usuarioServicio;
	@Autowired private ComentarioRepositorio comentarioDAO;
	
	private static boolean datosCargados = false;
	
	@GetMapping ("/cargardatos")
	public ResponseEntity<String> cargarDatos ()
	{
		ResponseEntity<String> response;
		Usuario u1,u2,u3;
		Noticia n1,n2,n3;
		Comentario c1,c2,c3;
		
		if (!datosCargados)
		{
			datosCargados = true;
			
			u1 = Usuario.builder().
							nickname("usu1").
							password("usu1").
							build();

			u2 = Usuario.builder().
					nickname("usu2").
					password("usu2").
					build();
			
			u3 = Usuario.builder().
					nickname("usu3").
					password("usu3").
					build();
			
			usuarioServicio.insertar(u1);
			usuarioServicio.insertar(u2);
			usuarioServicio.insertar(u3);
			
			
			n1 = Noticia.builder().
					titulo("noticia 1").
					cuerpo("cuerpo noticia 1").
					categoria(Categoria.POLITICA).
					fecha(LocalDate.now()).
					redactor(u1).
					build();
			
			n2 = Noticia.builder().
					titulo("noticia 2").
					cuerpo("cuerpo noticia 2").
					categoria(Categoria.DEPORTES).
					fecha(LocalDate.now()).
					redactor(u2).
					build();
			
			
			n3 = Noticia.builder().
					titulo("noticia 3").
					cuerpo("cuerpo noticia 3").
					categoria(Categoria.POLITICA).
					fecha(LocalDate.now()).
					redactor(u3).
					build();
		
			noticiaServicio.insertar(n1);
			noticiaServicio.insertar(n2);
			noticiaServicio.insertar(n3);
			
			c1 = Comentario.builder().
					autor(u3).
					noticia(n1).
					contenido("contenido comentario 1").
					fecha(LocalDate.now().minusMonths(1)).
					valoracion(3).
					build();
			
			c2 = Comentario.builder().
					autor(u3).
					noticia(n2).
					contenido("contenido comentario 2").
					fecha(LocalDate.now()).
					valoracion(5).
					build();
			
			c3 = Comentario.builder().
					autor(u1).
					noticia(n2).
					contenido("contenido comentario 3").
					fecha(LocalDate.now()).
					valoracion(4).
					build();
			
		
			comentarioServicio.insertar(c1);
			comentarioServicio.insertar(c2);
			comentarioServicio.insertar(c3);
			
			response = new ResponseEntity<>("datos cargados correctamente",HttpStatus.OK);
		}
		else
			response = new ResponseEntity<>("datos cargados anteriormente",HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping ("/query1")
	public ResponseEntity<String> hacerQuery1 ()
	{
		ResponseEntity<String> response;
		
		String titulo = comentarioDAO.buscarNoticiaConMasComentarios().orElse("sin datos");
		response = new ResponseEntity<>(titulo,HttpStatus.OK);
		
		return response;
	}
	
	

}
