package org.dam2.examenspring;

import java.time.LocalDate;
import java.util.Set;

import org.dam2.examenspring.model.Estado;
import org.dam2.examenspring.model.Mecanico;
import org.dam2.examenspring.model.Pieza;
import org.dam2.examenspring.model.PiezaUsada;
import org.dam2.examenspring.model.Trabajo;
import org.dam2.examenspring.model.TrabajoAsignado;
import org.dam2.examenspring.service.MecanicoServ;
import org.dam2.examenspring.service.PiezaServ;
import org.dam2.examenspring.service.PiezaUsadaServ;
import org.dam2.examenspring.service.TrabajoAsignadoServ;
import org.dam2.examenspring.service.TrabajoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {

	@Autowired
	PiezaServ piezaServ;
	
	@Autowired
	TrabajoServ trabajoServ;
	
	@Autowired
	TrabajoAsignadoServ trabajoAsigServ;
	
	@Autowired
	MecanicoServ mecServ;
	
	@Autowired
	PiezaUsadaServ piezaUsadaServ;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Pieza p1 = Pieza.builder().numRef("123").nombre("pieza1").precioUnidad(12.2f).build();
		Pieza p2 = Pieza.builder().numRef("234").nombre("pieza2").precioUnidad(8.44f).build();
	
		Set.of(p1, p2).forEach(p -> piezaServ.insertar(p));
		System.out.println("Piezas insertadas");
		
		Mecanico mec1 = Mecanico.builder().nickname("alex").contrasena("123").fechaAlta(LocalDate.now()).build();
		Mecanico mec2 = Mecanico.builder().nickname("raul").contrasena("234").fechaAlta(LocalDate.now().minusDays(2)).build();
		
		Set.of(mec1, mec2).forEach(mec -> mecServ.insertar(mec));
		System.out.println("Mecánicos insertadas");
		
		Trabajo tb1 = Trabajo.builder().descripcion("descripcion1").build();
		Trabajo tb2 = Trabajo.builder().descripcion("descripcion2").build();
		
		trabajoServ.insertar(tb1);
		trabajoServ.insertar(tb2);
		
		PiezaUsada us1 = PiezaUsada.builder().pieza(p1).cantidad(2).build();
		PiezaUsada us2 = PiezaUsada.builder().pieza(p2).cantidad(1).build();
		
		piezaUsadaServ.insertar(us1);
		piezaUsadaServ.insertar(us2);
		
		TrabajoAsignado asig1 = TrabajoAsignado.builder().
				estado(Estado.FINALIZADO).
				horasDedicadas(4).
				mecanico(mec2).
				piezasUsadas(Set.of()).
				trabajo(tb2).build();
		
		PiezaUsada us3 = PiezaUsada.builder().pieza(p1).cantidad(4).build();
		piezaUsadaServ.insertar(us3);
		TrabajoAsignado asig2 = TrabajoAsignado.builder().
				estado(Estado.EN_PROCESO).
				horasDedicadas(2).
				mecanico(mec2).
				piezasUsadas(Set.of(us3)).
				trabajo(tb2).build();
		
		TrabajoAsignado asig3 = TrabajoAsignado.builder().
				estado(Estado.ESPERA).
				horasDedicadas(0).
				mecanico(null).
				piezasUsadas(Set.of()).
				trabajo(tb2).build();
		
		trabajoAsigServ.insertar(asig1);
		trabajoAsigServ.insertar(asig2);
		trabajoAsigServ.insertar(asig3);		
	}
	
}
