package org.dam2.unoamuchos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppUnoAMuchos implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("unoamuchos");
		
		EntityManager em = emFactory.createEntityManager();
		
		Depart d = createDepart();
		
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		
		em.detach(d);
		
		
		Depart d1 = em.find(Depart.class, d.getDeptNo());
		
		System.out.println(d1.getDname());
		em.detach(d1);
		
		d1.getEmpleados().forEach(System.out::println);
		
		
		
		/*
		Query query = em.createQuery("Select d.empleados from Depart d where d.loc = :localidad ");
		query.setParameter("localidad", "Madrid");
		
		Stream<Empleado> stream = query.getResultStream();
		stream.filter(e-> e.getSalario()>1000).forEach(System.out::println);
		*/
		
		
		em.close();

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
