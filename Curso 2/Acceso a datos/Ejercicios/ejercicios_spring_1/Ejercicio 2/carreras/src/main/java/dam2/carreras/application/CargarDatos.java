package dam2.carreras.application;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dam2.carreras.model.Carrera;
import dam2.carreras.model.Corredor;
import dam2.carreras.model.PuntoControl;
import dam2.carreras.model.Sexo;
import dam2.carreras.model.Tiempo;
import dam2.carreras.service.ICarreraService;
import dam2.carreras.service.ICorredorService;
import dam2.carreras.service.IPuntoControlService;
import dam2.carreras.service.ITiempoService;

@Component

/**
 * Carga los datos iniciales necesarios para pruebas.
 * 
 * */
public class CargarDatos implements CommandLineRunner {
	@Autowired ITiempoService servicioTiempo;
	@Autowired ICarreraService servicioCarrera;
	@Autowired ICorredorService servicioCorredor;
	@Autowired IPuntoControlService servicioPuntoDeControlService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("Cargando datos");
		
		// Crear los puntos de control
        PuntoControl puntoControl1Carrera1 = PuntoControl.builder()
                                            .puntoKilometrico(10.5f)
                                            .nombreJuez("Juez 1")
                                            .tiempoLlegada(120.5f)
                                            .build();
        
        PuntoControl puntoControl2Carrera1 = PuntoControl.builder()
                                            .puntoKilometrico(20.5f)
                                            .nombreJuez("Juez 2")
                                            .tiempoLlegada(180.5f)
                                            .build();
        
        PuntoControl puntoControl1Carrera2 = PuntoControl.builder()
                                            .puntoKilometrico(15.3f)
                                            .nombreJuez("Juez 3")
                                            .tiempoLlegada(150.2f)
                                            .build();
        
        PuntoControl puntoControl2Carrera2 = PuntoControl.builder()
                                            .puntoKilometrico(25.8f)
                                            .nombreJuez("Juez 4")
                                            .tiempoLlegada(200.7f)
                                            .build();
        
        // Crear los corredores
        Corredor corredor1 = Corredor.builder()
                                .dni("12345678A")
                                .dorsal(1)
                                .nombre("Juan")
                                .sexo(Sexo.HOMBRE)
                                .build();
        
        Corredor corredor2 = Corredor.builder()
                                .dni("87654321B")
                                .dorsal(2)
                                .nombre("Maria")
                                .sexo(Sexo.MUJER)
                                .build();
        
        // Crear las carreras
        Set<PuntoControl> puntosControlCarrera1 = new HashSet<>();
        puntosControlCarrera1.add(puntoControl1Carrera1);
        puntosControlCarrera1.add(puntoControl2Carrera1);
        
        Carrera carrera1 = Carrera.builder()
                                .nombre("Carrera 1")
                                .maxCorredores(100)
                                .fechaCelebracion(LocalDateTime.now())
                                .puntosControl(puntosControlCarrera1)
                                .build();
        
        Set<PuntoControl> puntosControlCarrera2 = new HashSet<>();
        puntosControlCarrera2.add(puntoControl1Carrera2);
        puntosControlCarrera2.add(puntoControl2Carrera2);
        
        Carrera carrera2 = Carrera.builder()
                                .nombre("Carrera 2")
                                .maxCorredores(150)
                                .fechaCelebracion(LocalDateTime.now().plusDays(1))
                                .puntosControl(puntosControlCarrera2)
                                .build();
        
        // Asignar corredores a las carreras
        Set<Corredor> corredores = new HashSet<>();
        corredores.add(corredor1);
        corredores.add(corredor2);
        
        carrera1.setCorredores(corredores);
        carrera2.setCorredores(corredores);
        
        
        // Crear tiempos
        Tiempo tiempoCorredor1Carrera1 = Tiempo.builder()
                                            .tiempo(3600) // 1 hora
                                            .corredor(corredor1)
                                            .carrera(carrera1)
                                            .build();
        
        Tiempo tiempoCorredor1Carrera2 = Tiempo.builder()
                                            .tiempo(5400) // 1 hora y media
                                            .corredor(corredor1)
                                            .carrera(carrera2)
                                            .build();
        
        Tiempo tiempoCorredor2Carrera1 = Tiempo.builder()
                                            .tiempo(4200) // 1 hora y 10 minutos
                                            .corredor(corredor2)
                                            .carrera(carrera1)
                                            .build();
        
        // Imprimir los datos cargados
        System.out.println("Datos cargados:");
        System.out.println("Carrera 1: " + carrera1);
        System.out.println("Carrera 2: " + carrera2);
        System.out.println("Corredor 1: " + corredor1);
        System.out.println("Corredor 2: " + corredor2);
        System.out.println("Tiempo Corredor 1 Carrera 1: " + tiempoCorredor1Carrera1);
        System.out.println("Tiempo Corredor 1 Carrera 2: " + tiempoCorredor1Carrera2);
        System.out.println("Tiempo Corredor 2 Carrera 1: " + tiempoCorredor2Carrera1);
        
        // Guardamaos a la base de datos 
        servicioPuntoDeControlService.insertar(puntoControl1Carrera1);
        servicioPuntoDeControlService.insertar(puntoControl1Carrera2);
        servicioPuntoDeControlService.insertar(puntoControl2Carrera1);
        servicioPuntoDeControlService.insertar(puntoControl2Carrera2);
        
        servicioCorredor.insertar(corredor1);
        servicioCorredor.insertar(corredor2);
        
        servicioCarrera.insertar(carrera1);
        servicioCarrera.insertar(carrera2);
        
        servicioTiempo.insertar(tiempoCorredor1Carrera1);
        servicioTiempo.insertar(tiempoCorredor1Carrera2);
        servicioTiempo.insertar(tiempoCorredor2Carrera1);
        
  

		
	}

}
