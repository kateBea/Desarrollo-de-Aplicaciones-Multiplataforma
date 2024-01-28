package dam2.repoqueries.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dam2.repoqueries.app.servicio.DepartamentoServicio;
import dam2.repoqueries.app.servicio.EmpleadoServicio;

@Component
public class QueriesEntryPoint implements CommandLineRunner {
	@Autowired
	EmpleadoServicio servicioEmpleado;
	DepartamentoServicio servicioDepartamento;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.err.println("===================================");
		System.err.println("        QUERIES ENTRY POINT        ");
		System.err.println("===================================");
		
		// 1. Obtener los datos completos de los empleados.
		servicioEmpleado.findAll().forEach(System.out::println);
	}

}
