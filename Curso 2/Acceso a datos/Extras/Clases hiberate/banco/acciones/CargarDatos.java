package org.dam2.banco.acciones;

import org.dam2.banco.modelo.Cliente;
import org.dam2.banco.modelo.Contacto;
import org.dam2.banco.modelo.Cuenta;
import org.dam2.banco.modelo.CuentaEmpresa;
import org.dam2.banco.modelo.CuentaPersonal;
import org.dam2.utilidadesmenu.MenuAction;

public class CargarDatos extends AccionBanco implements MenuAction {


	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		Cuenta cuenta1,cuenta2,cuenta3;
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
		
		cuenta3 = CuentaEmpresa.builder().
				ncc("003").
				saldo(-15000).
				nombre("otra empresa").
				cif("000CC").
				local(true).
				cliente(cliente2).
				build();
		
		cuentaDAO.save(cuenta1);
		cuentaDAO.save(cuenta2);
		cuentaDAO.save(cuenta3);
		
		System.out.println("Datos cargados correctamente");
		
		
	}

}
