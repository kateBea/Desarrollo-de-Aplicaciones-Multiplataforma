package org.dam2.unoamuchos;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppUnoAMuchosDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO <Depart,String> departDAO ;
		String PERSISTENCE_UNIT = "unoamuchos";

		departDAO = new GenericJPADAO (Depart.class,PERSISTENCE_UNIT);

		Depart depart = createDepart();
		
		departDAO.save(depart);
		
		departDAO.findAll().forEach(System.out::println);
		
		
		Stream<Empleado>  empleados = departDAO.executeQuery("Select d.empleados from Depart d where d.loc = ?1", 
								"Madrid");

		empleados.filter(e -> e.getSalario() > 1000).forEach(System.out::println);
		
	}

	public static Depart createDepart()
	{
		
		
		Empleado emple1 = Empleado.builder().
				empNo("007").
				apellido("Boon").
				fechaAlta(LocalDate.now().minusYears(3)).
				salario(1000).
				build();
		
		Empleado emple2 = Empleado.builder().
				empNo("107").
				apellido("Sutil").
				fechaAlta(LocalDate.now().minusYears(1)).
				salario(1400).
				build();
		
		
		Depart depart = Depart.builder().
				deptNo("001").
				dname("infor").
				loc("Madrid").
				empleado(emple1).
				empleado(emple2).
				build();
					
		return depart;
	}
}
