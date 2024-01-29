package dam2.repoqueries.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import dam2.repoqueries.app.modelo.Departamento;
import dam2.repoqueries.app.modelo.Empleado;
import dam2.repoqueries.app.modelo.Sexo;
import dam2.repoqueries.app.servicio.DepartamentoServicio;
import dam2.repoqueries.app.servicio.EmpleadoServicio;

@Component
@Order(0)
public class CargarDatos implements CommandLineRunner {
	@Autowired
	DepartamentoServicio servicioDept;
	
	@Autowired
	EmpleadoServicio servicioEmpl;

	public void accion() {
		// TODO Auto-generated method stub
		System.err.println("Cargando datos");
		
		// Crear una lista para almacenar los departamentos
        List<Departamento> departamentos = new ArrayList<>();

        // Crear cada departamento y agregarlo a la lista
        departamentos.add(
            Departamento.builder()
                .codigo(1000)
                .nombre("GERENCIA")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(1500)
                .nombre("PRODUCCIÓN")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(2000)
                .nombre("VENTAS")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(3000)
                .nombre("INVESTIGACIÓN")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(3500)
                .nombre("MERCADEO")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(2100)
                .nombre("VENTAS")
                .ciudad("POPAYAN")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(2200)
                .nombre("VENTAS")
                .ciudad("BUGA")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(2300)
                .nombre("VENTAS")
                .ciudad("CARTAGO")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(4000)
                .nombre("MANTENIMIENTO")
                .ciudad("CALI")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(4100)
                .nombre("MANTENIMIENTO")
                .ciudad("POPAYAN")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(4200)
                .nombre("MANTENIMIENTO")
                .ciudad("BUGA")
                .build()
        );

        departamentos.add(
            Departamento.builder()
                .codigo(4300)
                .nombre("MANTENIMIENTO")
                .ciudad("CARTAGO")
                .build()
        );

        for (Departamento depto : departamentos) {
            servicioDept.insertar(depto);
        }
        
        System.err.println("Datos de departamentos guardados");
        
        // Crear una lista para almacenar los empleados
        List<Empleado> empleados = new ArrayList<>();

        // Asignar departamento a cada empleado según el script SQL
        empleados.add(
            Empleado.builder()
                .id(16759060)
                .nombre("Darío Casas")
                .sexo(Sexo.M)
                .fechaNacimiento(LocalDate.of(1960, 4, 5))
                .fechaIncorporacion(LocalDate.of(1992, 11, 1))
                .salario(4500000)
                .comision(500000)
                .cargo("Investigador")
                .departamento(departamentos.get(2)) // VENTAS
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(22222222)
                .nombre("Carla López")
                .sexo(Sexo.F)
                .fechaNacimiento(LocalDate.of(1975, 5, 11))
                .fechaIncorporacion(LocalDate.of(2005, 7, 16))
                .salario(4500000)
                .comision(500000)
                .cargo("Jefe Mercadeo")
                .departamento(departamentos.get(2)) // VENTAS
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(22222333)
                .nombre("Carlos Rozo")
                .sexo(Sexo.M)
                .fechaNacimiento(LocalDate.of(1975, 5, 11))
                .fechaIncorporacion(LocalDate.of(2001, 9, 16))
                .salario(750000)
                .comision(500000)
                .cargo("Vigilante")
                .departamento(departamentos.get(2)) // VENTAS
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(1751219)
                .nombre("Melissa Roa")
                .sexo(Sexo.F)
                .fechaNacimiento(LocalDate.of(1960, 6, 19))
                .fechaIncorporacion(LocalDate.of(2001, 3, 16))
                .salario(2250000)
                .comision(2500000)
                .cargo("Vendedor")
                .departamento(departamentos.get(5)) // VENTAS Popayán
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(768782)
                .nombre("Joaquín Rosas")
                .sexo(Sexo.M)
                .fechaNacimiento(LocalDate.of(1947, 7, 7))
                .fechaIncorporacion(LocalDate.of(1990, 5, 16))
                .salario(2250000)
                .comision(2500000)
                .cargo("Vendedor")
                .departamento(departamentos.get(6)) // VENTAS Buga
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(737689)
                .nombre("Mario Llano")
                .sexo(Sexo.M)
                .fechaNacimiento(LocalDate.of(1945, 8, 30))
                .fechaIncorporacion(LocalDate.of(1990, 5, 16))
                .salario(2250000)
                .comision(2500000)
                .cargo("Vendedor")
                .departamento(departamentos.get(7)) // VENTAS Cartago
                .build()
        );

        empleados.add(
            Empleado.builder()
                .id(333333333)
                .nombre("Elisa Rojas")
                .sexo(Sexo.F)
                .fechaNacimiento(LocalDate.of(1979, 9, 28))
                .fechaIncorporacion(LocalDate.of(2004, 6, 1))
                .salario(3000000)
                .comision(1000000)
                .cargo("Jefe Mecánicos")
                .departamento(departamentos.get(8)) // MANTENIMIENTO
                .build()
        );
        
        for (Empleado empleado : empleados) {
        	servicioEmpl.insertar(empleado);
        }
        
        System.err.println("Datos de empleados guardados");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accion();
		
	}
	
}
