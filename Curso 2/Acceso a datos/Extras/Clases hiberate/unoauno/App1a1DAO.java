package org.dam2.unoauno;



import java.time.LocalDate;

import org.dam2.utilidadeshibernate.GenericJPADAO;

public class App1a1DAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericJPADAO <Alumno,Integer> alumnoDAO ;
		String PERSISTENCE_UNIT = "unoauno";

		alumnoDAO = new GenericJPADAO (Alumno.class,PERSISTENCE_UNIT);


        Direccion d = Direccion.builder().  
        		//idDireccion(1).
				calle("calle").
				numero(34).
				poblacion("poblacion").
				provincia("provincia").
				build();

        // guardar alumno
        Alumno alumno = Alumno.builder().
        					//id(0).
        					firstName("ana").
        					fecha(LocalDate.now()).
        					direccion(d).
        					build();
        
               
       alumnoDAO.save(alumno);
        //System.out.println(alumno);
        
        System.out.println("consultando...");
        
        //alumnoDAO.findById(1).ifPresent(System.out::println);
        
        alumnoDAO.findAll().forEach(System.out::println);
        
        // actualizar
        alumno = alumnoDAO.findById(2).get();
        
        alumno.setFecha(LocalDate.now().minusYears(2));
        alumno.getDireccion().setCalle("villablanca");
        alumnoDAO.update(alumno);
        
        System.out.println("Listar todos");
        alumnoDAO.findAll().forEach(System.out::println);
        
        // borrar alumno
        alumnoDAO.delete(alumno);
        
        System.out.println("Listar todos");
        alumnoDAO.findAll().forEach(System.out::println);
        
	}

}
