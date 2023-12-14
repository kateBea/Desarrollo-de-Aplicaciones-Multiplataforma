package org.dam2.consultas;

import java.util.HashSet;
import java.util.Set;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppConsultasConJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericJPADAO<Profe, Integer> profeDAO;
		profeDAO = new GenericJPADAO<>(Profe.class, "consultas");
		String query;
		
		
		
        
        System.out.println("----------------------");
        
        query = "SELECT correos.direccionCorreo FROM Profe profe LEFT JOIN profe.correosElectronicos correos";
        profeDAO.executeQuery(query).forEach(System.out::println);
        
        System.out.println(profeDAO.executeQuery(query).count());
	}
	

}
