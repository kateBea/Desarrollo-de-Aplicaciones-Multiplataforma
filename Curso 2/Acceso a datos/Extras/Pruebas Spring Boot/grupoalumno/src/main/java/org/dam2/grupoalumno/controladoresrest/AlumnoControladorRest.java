package org.dam2.grupoalumno.controladoresrest;

import java.util.Optional;

import org.dam2.grupoalumno.modelo.Alumno;
import org.dam2.grupoalumno.modelo.Grupo;
import org.dam2.grupoalumno.servicio.IAlumnoServicio;
import org.dam2.grupoalumno.servicio.IGrupoServicio;
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
@RequestMapping("grupos/alumno")
public class AlumnoControladorRest {
	@Autowired IGrupoServicio servicioGrupo;
	@Autowired IAlumnoServicio servicioAlumno;
	
	@PostMapping("/insertaralumno/{idgrupo}")
	public ResponseEntity<Alumno> addAlumno (@RequestBody Alumno alumno, @PathVariable String idgrupo)
	{
		ResponseEntity<Alumno> response;
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Optional<Grupo> grupo = servicioGrupo.findById(idgrupo);
		
		if (grupo.isPresent())
		{
			if (servicioAlumno.insertarAlumno(alumno))
			{
				grupo.get().getAlumnos().add(alumno);
				servicioGrupo.actualizarGrupo(grupo.get());
				status = HttpStatus.OK;
			}
		}
		response = new ResponseEntity<Alumno>(alumno,status);
		
		return response;
	}
	
	@DeleteMapping("/borraralumno")
	public ResponseEntity<Alumno> borrarAlumno (@RequestParam String nia)
	{
		
		ResponseEntity<Alumno> response;
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Alumno alumno;
		
		alumno = servicioAlumno.findById(nia).orElse(new Alumno());
		
		if (servicioAlumno.eliminarAlumno(nia))
		{
			status = HttpStatus.ACCEPTED;
		}
		response = new ResponseEntity<Alumno>(alumno,status);
		
		return response;
	}

	@GetMapping ("consultarid/{nia}")
	public ResponseEntity<Alumno> buscarPorIdAlumno (@PathVariable String nia)
	{
		ResponseEntity<Alumno> response;
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Optional<Alumno> alumno = servicioAlumno.findById(nia);
		
		if (alumno.isPresent())
			response = new ResponseEntity<Alumno> (alumno.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<Alumno> (new Alumno(),status);
		
		return response;
	}
}
