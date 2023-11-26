package org.dam2.banco.acciones;

import org.dam2.banco.modelo.Cliente;
import org.dam2.banco.modelo.Contacto;
import org.dam2.banco.modelo.Cuenta;
import org.dam2.utilidadeshibernate.GenericJPADAO;
import org.dam2.utilidadesmenu.MenuAction;

public class AccionBanco {

	private final static String UNIDADPERSISTENCIA = "banco";
	protected static GenericJPADAO<Cliente,String> clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
	protected static GenericJPADAO<Cuenta,String> cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);
	protected GenericJPADAO<Contacto,String> contactoDAO = new GenericJPADAO<Contacto,String> (Contacto.class,UNIDADPERSISTENCIA);
	
	/*
	public AccionBanco ()
	{
		clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
		cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);

	}

	*/
}
