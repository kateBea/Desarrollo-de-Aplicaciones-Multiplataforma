package dam2.blog.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class CargarDatos implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("Cargando datos");
		
		// Crear usuarios
		
		// Crear noticias
		
		// Crear comentarios
		
	}

}
