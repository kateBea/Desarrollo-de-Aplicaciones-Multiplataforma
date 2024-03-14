package org.dam2.mongonoticias.controlador;

import java.util.List;

import org.dam2.mongonoticias.modelo.Lugar;
import org.dam2.mongonoticias.servicio.ILugarServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("mongonoticias/lugar")
public class LugarControlador {
	
	@Autowired private ILugarServicio lugarServicio;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Lugar>> obtenerTodosLugares ()
	{
		ResponseEntity<List<Lugar>> response;
		List<Lugar> todos;
		
		todos =  lugarServicio.findAll();
		
		todos.forEach(System.out::println);
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
	
		return response;
	}
	
	@GetMapping ("/consultarlugar")
	public ResponseEntity<List<Lugar>> obtenerLugaresPoligono ()
	{
		ResponseEntity<List<Lugar>> response;
		List<Lugar> todos;
		
		GeoJsonPolygon poligono = new GeoJsonPolygon(
			    new Point(-73.992514, 40.758934),
			    new Point(-73.961138, 40.760348),
			    new Point(-73.991658, 40.730006),
			    new Point(-73.992514, 40.758934)); 
		
		todos = (List<Lugar>) lugarServicio.buscarPorPosicionDentroDe(poligono);
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}
	
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Lugar> insertarUsuario (@RequestBody Lugar lugar)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!lugarServicio.insertar(lugar))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(lugar,status);
	}
	

}
