package dam2.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dam2.biblioteca.modelo.Ejemplar;
import dam2.biblioteca.modelo.Estado;
import dam2.biblioteca.modelo.Libro;
import dam2.biblioteca.modelo.Usuario;
import dam2.biblioteca.servicio.IEjemplarServ;
import dam2.biblioteca.servicio.ILibroServ;
import dam2.biblioteca.servicio.IUsuarioServ;

@Order(0)
@Component
public class CargarDatos implements CommandLineRunner {
	
	@Autowired
	IUsuarioServ usuarioServ;
	
	@Autowired
	ILibroServ libroServ;
	
	@Autowired
	IEjemplarServ ejemplarServ;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		// Crear usuarios
		Usuario us1 = Usuario.builder().dni("12345678K").nombre("Pedro").password("123").telefono("662 66 22 33").build();
		Usuario us2 = Usuario.builder().dni("87654321Y").nombre("Julia").password("123").telefono("777 22 22 22").build();
		Usuario us3 = Usuario.builder().dni("65274892O").nombre("Carmen").password("123").telefono("777 11 22 11").build();
		
		usuarioServ.insertar(us1);
		usuarioServ.insertar(us2);
		usuarioServ.insertar(us3);
		
		System.err.println("Usuarios cargados");
		
		Libro lb1 = Libro.builder().isbn("848441423X").titulo("BAT-PAT 1").autor("Roberto").build();
		Libro lb2 = Libro.builder().isbn("979-8394118142").titulo("Oliva Mars").autor("Isabel Álvarez").build();
		
		libroServ.insertar(lb1);
		libroServ.insertar(lb2);
		
		System.err.println("Libros cargados");
		
		Ejemplar eje1 = Ejemplar.builder().numRegistro("123").diasPrestamo(3).estado(Estado.OPTIMO).libro(lb1).build();
		Ejemplar eje2 = Ejemplar.builder().numRegistro("234").diasPrestamo(5).estado(Estado.REGULAR).libro(lb1).build();
		Ejemplar eje3 = Ejemplar.builder().numRegistro("764").diasPrestamo(7).estado(Estado.DETERIORADO).libro(lb2).build();
		Ejemplar eje4 = Ejemplar.builder().numRegistro("193").diasPrestamo(2).estado(Estado.REGULAR).libro(lb2).build();
		
		ejemplarServ.insertar(eje1);
		ejemplarServ.insertar(eje2);
		ejemplarServ.insertar(eje3);
		ejemplarServ.insertar(eje4);
		
		System.err.println("Ejemplares cargados");
	}

}
