package org.dam2.grupoalumno.controladoresrest;

import java.time.LocalDate;
import java.util.List;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.dam2.grupoalumno.servicio.IAlumnoServicio;
import org.dam2.grupoalumno.servicio.IGrupoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("grupos/grupo")
public class GrupoControladorRest {
	
	@Autowired IGrupoServicio servicioGrupo;
	@Autowired IAlumnoServicio alumnoService;
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<Grupo>> obtenerTodosGrupos ()
	{
		ResponseEntity<List<Grupo>> response;
		List<Grupo> todos;
		
		todos = servicioGrupo.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		return response;
	}
	
	@GetMapping ("/listarids")
	public ResponseEntity <List<String>> listarTodosIds ()
	{
		ResponseEntity<List<String>> response;
		List<String> todos;
		
		todos = servicioGrupo.listarTodosIds();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping ("/cargardatos")
	public ResponseEntity<String> cargarClientes ()
	{
		HttpStatus status = HttpStatus.NOT_MODIFIED;
		
		Grupo g = Grupo.builder().
				id("DAM1").
				ciclo("C1").
				curso(1).
				gradoSuperior(true).
				alumno(Alumno.builder().
						nia("001").
						nombre("alumno1").
						fechaNacimiento(LocalDate.of(1980, 1, 10)).
						nota(8f).
						build()).
				alumno(Alumno.builder().
						nia("002").
						nombre("alumno2").
						fechaNacimiento(LocalDate.of(1983, 3, 10)).
						nota(9f).
						build()).
				build();
		
		Grupo g1 = Grupo.builder().
				id("DAM2").
				ciclo("C1").
				curso(2).
				gradoSuperior(true).
				alumno(Alumno.builder().
						nia("003").
						nombre("alumno3").
						fechaNacimiento(LocalDate.of(1982, 1, 10)).
						nota(6f).
						build()).
				alumno(Alumno.builder().
						nia("004").
						nombre("alumno4").
						fechaNacimiento(LocalDate.of(1993, 3, 10)).
						nota(3f).
						build()).
				build();
		
		if (servicioGrupo.insertarGrupo(g) && 
				servicioGrupo.insertarGrupo(g1))
			status = HttpStatus.OK;
		
		return new ResponseEntity<>("datos cargados correctamente",status);
	}

}
