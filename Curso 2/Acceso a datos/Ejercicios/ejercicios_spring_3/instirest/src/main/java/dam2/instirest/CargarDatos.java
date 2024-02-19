package dam2.instirest;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dam2.instirest.model.Direccion;
import dam2.instirest.model.Email;
import dam2.instirest.model.Estudiante;
import dam2.instirest.model.Instituto;
import dam2.instirest.model.NivelEstudios;
import dam2.instirest.model.Profesor;
import dam2.instirest.service.EmailServ;
import dam2.instirest.service.EstudianteServ;
import dam2.instirest.service.InstitutoServ;
import dam2.instirest.service.ProfesorServ;

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {

	@Autowired
	EmailServ emailServ;
	
	@Autowired
	ProfesorServ profesorServ;
	
	@Autowired
	EstudianteServ estudianteServ;
	
	@Autowired
	InstitutoServ institutoServ;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// Emails
		Email e1 = Email.builder().direccion("roberto@unmail.com").tipo("institucional").build();
		Email e2 = Email.builder().direccion("elisa@unmail.com").tipo("personal").build();
		Email e3 = Email.builder().direccion("pedro@unmail.com").tipo("personal").build();
		Email e4 = Email.builder().direccion("maria@unmail.com").tipo("personal").build();
		Email e5 = Email.builder().direccion("pabblo.rubio@unmail.com").tipo("institucional").build();
		Email e6 = Email.builder().direccion("silvia@unmail.com").tipo("personal").build();
		
		Set.of(e1, e2, e3, e4, e5, e6).forEach(email -> emailServ.insertar(email));
		System.err.println("Emails insertados");
		
		// Estudiantes
		Estudiante est1 = Estudiante.builder().
			nif("12345678K").
			nombre("Pedro").
			poblacion("Madrid").
			curso("2023-2024").
			grupo(NivelEstudios.BACHILLERATO).
			delegado(false).
			fechaNacimiento(LocalDate.now().minusYears(18)).
			emails(Set.of(e3)).
			build();
		
		Estudiante est2 = Estudiante.builder().
				nif("12546372I").
				nombre("Maria").
				poblacion("Madrid").
				curso("2023-2024").
				grupo(NivelEstudios.BACHILLERATO).
				delegado(false).
				fechaNacimiento(LocalDate.now().minusYears(17)).
				emails(Set.of(e4)).
				build();
		
		Estudiante est3 = Estudiante.builder().
				nif("64836529R").
				nombre("Pablo").
				poblacion("Madrid").
				curso("2023-2024").
				grupo(NivelEstudios.FP_SUPERIOR).
				delegado(false).
				fechaNacimiento(LocalDate.now().minusYears(19)).
				emails(Set.of(e5)).
				build();
		
		Estudiante est4 = Estudiante.builder().
				nif("26543976H").
				nombre("Silvia").
				poblacion("Madrid").
				curso("2023-2024").
				grupo(NivelEstudios.FP_SUPERIOR).
				delegado(true).
				fechaNacimiento(LocalDate.now().minusYears(20)).
				emails(Set.of(e6)).
				build();
		
		Set.of(est1, est2, est3, est4).forEach(est -> estudianteServ.insertar(est));
		System.err.println("Estudiantes insertados");
		
		// Profesores
		Profesor prof1 = Profesor.builder().
				nif("46583452Y").
				nombre("Roberto").
				poblacion("Madrid").
				departamento("CIENCIAS SOCIALES").
				despacho("453D").
				estudiantes(Set.of(est1, est2)).
				fechaNacimiento(LocalDate.now().minusYears(27)).
				emails(Set.of(e1)).
				build();
		
		Profesor prof2 = Profesor.builder().
				nif("29735643O").
				nombre("Elisa").
				poblacion("Madrid").
				departamento("INFORMÁTICA").
				despacho("123P").
				estudiantes(Set.of(est3, est4)).
				fechaNacimiento(LocalDate.now().minusYears(29)).
				emails(Set.of(e2)).
				build();
		
		Set.of(prof1, prof2).forEach(prof -> profesorServ.insertar(prof));
		System.err.println("Profesores insertados");
		
		// Institutos
		Instituto insti1 = Instituto.builder().
			codigo("12345").
			telefono("91 711 22 33").
			estudiantes(Set.of(est1, est2)).
			profesores(Set.of(prof1)).
			direccion(Direccion.builder().calle("C/ Desconocida").codigoPostal("28734").poblacion("Madrid").build()).
			build();
				
		Instituto insti2 = Instituto.builder().
				codigo("35463").
				telefono("91 822 22 11").
				estudiantes(Set.of(est3, est4)).
				profesores(Set.of(prof2)).
				direccion(Direccion.builder().calle("C/ Otra era").codigoPostal("45362").poblacion("Madrid").build()).
				build();
		
		Set.of(insti1, insti2).forEach(insti -> institutoServ.insertar(insti));
		System.err.println("Institutos insertados");
		
	}

}
