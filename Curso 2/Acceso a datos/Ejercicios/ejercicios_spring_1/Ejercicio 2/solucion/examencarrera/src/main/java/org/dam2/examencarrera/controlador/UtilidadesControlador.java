package org.dam2.examencarrera.controlador;

import java.time.LocalDate;

import org.dam2.examencarrera.errores.RollBackException;
import org.dam2.examencarrera.modelo.dto.CarreraConPCDto;
import org.dam2.examencarrera.modelo.dto.CarreraDto;
import org.dam2.examencarrera.modelo.dto.CorredorDto;
import org.dam2.examencarrera.modelo.dto.PuntoControlDto;
import org.dam2.examencarrera.modelo.entidad.Carrera;
import org.dam2.examencarrera.modelo.entidad.CarreraCorredor;
import org.dam2.examencarrera.modelo.entidad.Corredor;
import org.dam2.examencarrera.modelo.entidad.PuntoControl;
import org.dam2.examencarrera.servicio.ICarreraCorredorServicio;
import org.dam2.examencarrera.servicio.ICarreraServicio;
import org.dam2.examencarrera.servicio.ICorredorServicio;
import org.dam2.examencarrera.servicio.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carreras/utilidades")
public class UtilidadesControlador {
	
	@Autowired ICorredorServicio corredorServicio;
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICarreraCorredorServicio carreraCorredorServicio;
	
	
private static boolean datosCargados = false;
	
	@GetMapping ("/cargardatos")
	public ResponseEntity<String> cargarDatos ()
	{
		ResponseEntity<String> response;
		CorredorDto c1,c2;
		CarreraConPCDto ca1, ca2;
		CarreraDto cr1,cr2;
		String mensaje = "datos cargados correctamente";

		
		if (!datosCargados)
		{
			datosCargados = true;
			
			c1 = CorredorDto.builder().dni("001").nombre("c1").sexo(true).build();
			c2 = CorredorDto.builder().dni("002").nombre("c2").sexo(false).build();
			
			// No hace falta lo inserta al inscribirse la primera vez
			//corredorServicio.insertar(c1);
			//corredorServicio.insertar(c2);
			
			ca1 = CarreraConPCDto.builder().
					nombre("ca1").
					maximo(100).
					fecha(LocalDate.now().minusYears(1)).
					pc(PuntoControlDto.builder().juez("j1").pk(1f).build()).
					pc(PuntoControlDto.builder().juez("j2").pk(5f).build()).
					build();
			
			ca2 = CarreraConPCDto.builder().
					nombre("ca2").
					maximo(20).
					fecha(LocalDate.now()).
					pc(PuntoControlDto.builder().juez("j3").pk(2f).build()).
					pc(PuntoControlDto.builder().juez("j4").pk(15f).build()).
					build();
			
			carreraServicio.insertar(ca1);
			carreraServicio.insertar(ca2);
			
			System.out.println("listado de carreras creadas");
			carreraServicio.findAll().forEach(System.out::println);
			
			cr1 = ObjectMapperUtils.map(ca1, CarreraDto.class);
			cr2 = ObjectMapperUtils.map(ca2, CarreraDto.class);
			
			try { 
			carreraCorredorServicio.insertarCorredorCarrera(c1, cr1);
			carreraCorredorServicio.insertarCorredorCarrera(c1, cr2);
			carreraCorredorServicio.insertarCorredorCarrera(c2, cr1);
			carreraCorredorServicio.insertarCorredorCarrera(c2, cr2);
			}
			catch (RollBackException ex)
			{
				System.out.println(ex.getMensaje());
				mensaje = ex.getMensaje();
			}
			
			System.out.println("listado de corredores creados");
			corredorServicio.findAll().forEach(System.out::println);
			
			System.out.println("listado de corredores inscritos en carreras");
			carreraCorredorServicio.findAll().forEach(System.out::println);
			
			response = new ResponseEntity<>(mensaje,HttpStatus.OK);
		}
		else
			response = new ResponseEntity<>("datos cargados anteriormente",HttpStatus.OK);
		
		return response;
		
	}
	

}
