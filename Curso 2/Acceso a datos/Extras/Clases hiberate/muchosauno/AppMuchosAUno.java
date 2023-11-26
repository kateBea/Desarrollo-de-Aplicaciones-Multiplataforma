package org.dam2.muchosauno;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppMuchosAUno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("muchosauno");
		
		EntityManager em = emFactory.createEntityManager();
		
		Cliente cliente = Cliente.builder().nombre("Miguel Sutil").build();
		
		Factura factura = Factura.builder().
							fecha(LocalDate.now()).
							cliente(cliente).
							build();
		Factura factura1 = Factura.builder().
				fecha(LocalDate.now()).
				cliente(cliente).
				build();
		
		
		// Insertar factura
		em.getTransaction().begin();
		em.persist(factura);
		em.getTransaction().commit();

		// Liberar factura del em
		em.detach(factura);

		// Buscar factura
		Factura f = em.find(Factura.class, factura.getId());
		em.detach(f);
		
		System.out.println(f);
		
	}

}
