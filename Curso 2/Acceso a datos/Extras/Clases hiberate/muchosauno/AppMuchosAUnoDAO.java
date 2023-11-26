package org.dam2.muchosauno;

import java.time.LocalDate;


import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppMuchosAUnoDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericJPADAO<Factura,Long> facturaDAO;
		String PERSISTENCE_UNIT = "muchosauno";
		
		facturaDAO = new GenericJPADAO<>(Factura.class, PERSISTENCE_UNIT);
		
		Cliente cliente = Cliente.builder().
				nombre("Miguel Sutil").
				id(1).
				build();
		
		
		Factura factura1 = Factura.builder().
				fecha(LocalDate.now()).
				cliente(cliente).
				build();
		
		Factura factura2 = Factura.builder().
							fecha(LocalDate.now().minusYears(1)).
							cliente(cliente).
							build();

		// guardar facturas
		facturaDAO.save(factura1);
		facturaDAO.save(factura2);
		
		// Modifica fecha factura 1
		factura1 = facturaDAO.findById(1L).get();
		factura1.setFecha(LocalDate.now().minusDays(3));
		facturaDAO.update(factura1);
		
		// Mostrar todas las facturas
		facturaDAO.findAll().forEach(System.out::println);
		
		
		// Mostrar facturas de Miguel Sutil 
				facturaDAO.executeQuery("SELECT f FROM Factura f WHERE f.cliente.nombre = ?1", 
										"Miguel Sutil").
										//limit(1). // nos quedamos sólo con la primera
										forEach(System.out::println);
		
		// Mostrar facturas de Miguel Sutil de este año
		facturaDAO.executeQuery("SELECT f FROM Factura f WHERE f.cliente.nombre = ?1 and f.fecha > ?2", 
								"Miguel Sutil",
								LocalDate.of(2021, 12, 31)).
								forEach(System.out::println);
		
	}

}
