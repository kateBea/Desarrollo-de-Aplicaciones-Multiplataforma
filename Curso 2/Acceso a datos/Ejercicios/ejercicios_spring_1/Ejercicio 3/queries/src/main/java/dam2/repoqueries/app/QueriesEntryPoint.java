package dam2.repoqueries.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dam2.repoqueries.app.servicio.DepartamentoServicio;
import dam2.repoqueries.app.servicio.EmpleadoServicio;

@Component
@Order(1)
public class QueriesEntryPoint implements CommandLineRunner {
	@Autowired
	EmpleadoServicio servicioEmpleado;
	
	@Autowired
	DepartamentoServicio servicioDepartamento;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.err.println("===================================");
		System.err.println("        QUERIES ENTRY POINT        ");
		System.err.println("===================================");
	
		
		// 1. Obtener los datos completos de los empleados.
		System.err.println("Query 1");
		servicioEmpleado.findAll().forEach(System.out::println);
		
		// 2. Obtener los datos completos de los departamentos
		System.err.println("Query 2");
		servicioDepartamento.findAll().forEach(System.out::println);
		
		// 3. Obtener los datos de los empleados con cargo 'Secretaria'.
		System.err.println("Query 3");
		
		// 4. Obtener el nombre y salario de los empleados.
		System.err.println("Query 4");
		
		// 5. Obtener los datos de los empleados vendedores, ordenado por nombre.
		System.err.println("Query 5");
		
		// 6. Listar el nombre de los departamentos
		System.err.println("Query 6");
		
		// 7. Listar el nombre de los departamentos, ordenado por nombre
		System.err.println("Query 7");
		
		// 8. Listar el nombre de los departamentos, ordenado por ciudad
		System.err.println("Query 8");
		
		// 9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso
		System.err.println("Query 9");
		
		// 10. Obtener el nombre y cargo de todos los empleados, ordenado por salario
		System.err.println("Query 10");
	}

}
