package org.dam2.banco;

import org.dam2.banco.modelo.Cliente;
import org.dam2.banco.modelo.Contacto;
import org.dam2.banco.modelo.Cuenta;
import org.dam2.banco.modelo.CuentaEmpresa;
import org.dam2.banco.modelo.CuentaPersonal;
import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AppBanco {
	
	private GenericJPADAO<Cliente,String> clienteDAO;
	private GenericJPADAO<Cuenta,String> cuentaDAO;
	private final static String UNIDADPERSISTENCIA = "banco";
	
	public AppBanco ()
	{
		clienteDAO = new GenericJPADAO<Cliente,String> (Cliente.class,UNIDADPERSISTENCIA);
		cuentaDAO = new GenericJPADAO<Cuenta,String> (Cuenta.class,UNIDADPERSISTENCIA);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppBanco app = new AppBanco ();
		
		app.cargarDatos ();
		
		app.cuentaDAO.findAll().forEach(System.out::println);
		app.clienteDAO.findAll().forEach(System.out::println);
		

	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		Cuenta cuenta1,cuenta2;
		Cliente cliente1,cliente2;
		
		cliente1 = Cliente.builder().
					nif("001").
					nombre("miguel").
					aval(10000).
					telefono(new Contacto("605353350","orange")).
					build();
		
		cliente2 = Cliente.builder().
				nif("002").
				nombre("luis").
				aval(5000).
				telefono(new Contacto("00000999","movistar")).
				telefono(new Contacto("11111999","orange")).
				build();
				
		
		
		cuenta1 = CuentaPersonal.builder().
							ncc("001").
							credito(true).
							saldo(5000).
							cliente(cliente1).
							build();
		
		cuenta2 = CuentaEmpresa.builder().
				ncc("002").
				saldo(15000).
				nombre("mi empresa").
				cif("000BB").
				local(false).
				cliente(cliente2).
				cliente(cliente1).
				build();
		
		cuentaDAO.save(cuenta1);
		cuentaDAO.save(cuenta2);
		
		System.out.println("Datos cargados correctamente");
	}
	
	

}
