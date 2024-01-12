package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.example.demo.modelo.Contacto;
import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.CuentaEmpresa;
import com.example.demo.modelo.CuentaPersonal;
import com.example.demo.service.IClienteService;
import com.example.demo.service.ICuentaService;
import com.example.demo.modelo.Cliente;


//@Component
public class BancoAppConsola implements CommandLineRunner {

	@Autowired private ICuentaService serviceCuenta;
	@Autowired private IClienteService serviceCliente;
	@Override
	public void run(String... args) throws Exception {
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

		
		if (serviceCuenta.insert(cuenta1))
			System.out.println("Cuenta añadida correctamente");
		else
			System.out.println("Cuenta existente");
		
		if (serviceCuenta.insert(cuenta2))
			System.out.println("Cuenta añadida correctamente");
		else
			System.out.println("Cuenta existente");

		/* Sólo para bidireccional
		List<Cuenta> lista1 = new ArrayList<>();
		List<Cuenta> lista2 = new ArrayList<>();
		
		lista1.add(cuenta1);
		lista1.add(cuenta2);
		cliente1.setCuentas(lista1);
		
		lista2.add(cuenta2);
		cliente2.setCuentas(lista2);
		
		serviceCliente.save(cliente1);
		serviceCliente.save(cliente2);
		*/
		
		System.out.println("Listado de cuentas");
		serviceCuenta.findAll().forEach(System.out::println);
		
		// Hacer ingreso
		
		if (serviceCuenta.ingresarDinero("001", 2000))
			System.out.println("Ingreso realizado correctamento");
		else
			System.out.println("Cuenta inexistente");
		
		
		// Retirar dinero
		float exito = serviceCuenta.retirarDinero("001", 1000);
		
		if (exito > 0)
			System.out.println("Retirada de dinero realizado correctamento");
		else if (exito == 0)
			System.out.println("Cuenta inexistente");
		else
		{
			System.out.println("Retirada de dinero no realizada correctamento");
			System.out.println("Maximo permitido en negativo " + exito);
		}

		// Retirar dinero
			exito = serviceCuenta.transferirDinero("001", "002", 500);
			
			if (exito > 0)
				System.out.println("Transferencia de dinero realizado correctamento");
			else if (exito == 0)
				System.out.println("Cuenta inexistente");
			else
			{
				System.out.println("Transferencia de dinero no realizada correctamento");
				System.out.println("Maximo permitido en negativo " + exito);
			}

		
		// Mostrar todas las cuentas
		serviceCuenta.findAll().forEach(System.out::println);
		
		// Mostrar Saldo total
		System.out.println("Saldo total: " + serviceCuenta.findSaldoTotal());
		
	/*	
		// Mostrar cliente más rico
		List<Object[]> lista = serviceCuenta.findClienteMasRico();
		Cliente cliente = (Cliente) lista.get(0)[0];	
		System.out.println(cliente.getNombre() + " saldo " + lista.get(0)[1]);
	*/
		// Mostrar Proveedor más usado
		//List<Object[]> lista1 = serviceCliente.findProveedorMasUsado();
		//System.out.println( lista1.get(0)[0]+ " clientes " + lista1.get(0)[1]);
		
		System.out.println(serviceCliente.findProveedorMasUsado());
	
	}

}
