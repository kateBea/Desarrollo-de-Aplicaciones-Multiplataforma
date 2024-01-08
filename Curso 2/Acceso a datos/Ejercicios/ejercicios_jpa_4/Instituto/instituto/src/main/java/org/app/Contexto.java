package org.app;

import org.instituto.Direccion;
import org.instituto.Email;
import org.instituto.Estudiante;
import org.instituto.Instituto;
import org.instituto.Persona;
import org.instituto.Profesor;
import org.utilidades_hibernate.GenericJPADAO;

public class Contexto {
	private static GenericJPADAO<Instituto, String> daoInstituto;
	private static GenericJPADAO<Persona, String> daoPersona;
	private static GenericJPADAO<Profesor, String> daoProfesor;
	private static GenericJPADAO<Estudiante, String> daoEstudiante;
	private static GenericJPADAO<Email, String> daoEmail;
	private static GenericJPADAO<Direccion, String> daoDireccion;
	
	private static boolean initSuccesful = false;
    
	
	/**
	 * Inicializa el contexto. Llamar una vez al inciar la aplicación.
	 * */
    public static void init(String persistanceUnitName) {
    	if (initSuccesful) {
    		System.err.println("Conetexto ya inicializado");
    		return;
    	}
    	
    	daoInstituto = new GenericJPADAO<>(Instituto.class, persistanceUnitName);
    	daoPersona = new GenericJPADAO<>(Persona.class, persistanceUnitName);
    	daoProfesor = new GenericJPADAO<>(Profesor.class, persistanceUnitName);
    	daoEstudiante = new GenericJPADAO<>(Estudiante.class, persistanceUnitName);
    	daoEmail = new GenericJPADAO<>(Email.class, persistanceUnitName);
    	daoDireccion = new GenericJPADAO<>(Direccion.class, persistanceUnitName);
    	
    	initSuccesful = true;
    }
    
    /**
     * Me servirá para mostrar como Hibernate
     * construye las tablas (mientras el show_sql esté a true en el persistance.xml).
     * */
    public static void debugRun() {
    	// Depuración
    	daoInstituto.findAll();
    	daoPersona.findAll();
    	daoProfesor.findAll();
    	daoEstudiante.findAll();
    	daoEmail.findAll();
    	daoDireccion.findAll();
    }
    
    public static GenericJPADAO<Instituto, String> getDaoInstituto() {
        return daoInstituto;
    }

    public static GenericJPADAO<Persona, String> getDaoPersona() {
        return daoPersona;
    }

    public static GenericJPADAO<Profesor, String> getDaoProfesor() {
        return daoProfesor;
    }

    public static GenericJPADAO<Estudiante, String> getDaoEstudiante() {
        return daoEstudiante;
    }

    public static GenericJPADAO<Email, String> getDaoEmail() {
        return daoEmail;
    }

    public static GenericJPADAO<Direccion, String> getDaoDireccion() {
        return daoDireccion;
    }
}
