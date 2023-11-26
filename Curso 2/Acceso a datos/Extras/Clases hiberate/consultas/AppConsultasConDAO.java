package org.dam2.consultas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppConsultasConDAO {
	//@SuppressWarnings("unchecked")
	public static final Runnable SINDATOS = () -> System.out.println("No hay resultado");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO<Profe, Integer> profeDAO;
		profeDAO = new GenericJPADAO<>(Profe.class, "consultas");
		String query;
		
		
		
        
        
        // Realizar querys
        System.out.println("Un profe");
        System.out.println("----------------------");
        query = "SELECT p FROM Profe p WHERE id=1";
        profeDAO.executeQuerySingleResult(query).
        				ifPresentOrElse(System.out::println,SINDATOS);
        
        System.out.println("Todos los profesores");
        System.out.println("----------------------");
        query = "SELECT p FROM Profe p";
        profeDAO.executeQuery(query).forEach(System.out::println);
        
        System.out.println("Todos los correoElectronicos");
        System.out.println("----------------------");
        query = "SELECT c FROM CorreoElectronico c";
        profeDAO.executeQuery(query).forEach(System.out::println);
        
        System.out.println("Cada profe con todos los correoElectronicos");
        System.out.println("----------------------");
        query = "SELECT p.id,correos FROM Profe p JOIN p.correosElectronicos correos";
		Stream <Object[]> stream = profeDAO.executeQuery(query);
		stream.map(datos ->datos[0] + "--" + datos[1]).
					forEach(System.out::println);
        
		System.out.println("correoElectronicos  con parámetros");
        System.out.println("----------------------");
        query = "SELECT c FROM CorreoElectronico c "
        		+ "WHERE c.direccionCorreo LIKE ?1";
        profeDAO.executeQuery(query, "%yahoo%").forEach(System.out::println);
        
        System.out.println("consulta con nombre");
        System.out.println("----------------------");
        profeDAO.executeQueryNamed("findAllProfesores").
        									forEach(System.out::println);
        
        System.out.println("Consulta de actualización");
        System.out.println("----------------------");
        query = "UPDATE Profe p SET p.nombre='Rosa' WHERE p.id=1";
        Integer n = (Integer) profeDAO.executeQuerySingleResult(query).orElse(0); 
		System.out.println (n + " registro(s) actualizado(s)");
        
        System.out.println("Consulta de borrado");
        System.out.println("----------------------");
        query = "DELETE FROM CorreoElectronico c WHERE c.idCorreo=12";
        n = (Integer) profeDAO.executeQuerySingleResult(query).orElse(0); 
		System.out.println (n + " registro(s) borrados(s)");
        
        System.out.println("consulta profes por nombre");
        System.out.println("----------------------");
        profeDAO.executeQueryNamed("findProfeByNombre","Rosa").
        									forEach(System.out::println);
        
        System.out.println("Todos los profesores sin correos");
        System.out.println("----------------------");
        query = "select p.nombre from Profe p where p.correosElectronicos is empty";
        profeDAO.executeQuery(query).forEach(System.out::println);

	}

}
