package com.example.demo.clienterest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.CuentaEmpresa;
import com.example.demo.modelo.CuentaPersonal;
import com.example.demo.modelo.WrapperCuenta;
import com.example.demo.vistaylectura.LeerCliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import daw.com.Teclado;

public class AppCuentaRest {

	final static String URLBASE = "http://localhost:8080/banco";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ncc;
		Cuenta cuenta;
		
		
		AppClienteRest.cargarDatos ();
		
		
		ncc = leerNCC ();
		
		cuenta = crearCuenta (ncc);
		
		leerDatosCuenta (cuenta);
		
		leerClientesCuenta (cuenta);
		
		insertarCuenta (cuenta);
		
		//consultarCuenta (ncc);
		
		consultarTodas ();
		
	}
	
	
	private static void consultarTodas() {
		// TODO Auto-generated method stub
		String URLCONSULTARCUENTAS = URLBASE + "/cuenta/consultar";
		RestTemplate restTemplate = new RestTemplate();
		List<String> cuentasjson;

		
		try {
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLCONSULTARCUENTAS, String.class);
			// parsear json de todas las cuentas
			cuentasjson = jsonToCuentas (response.getBody());
			// parsear json de cada cuenta
			cuentasjson.stream().
						map(s -> jsonToCuenta(s)).
						map(Optional::get).
						forEach(System.out::println);
		}
		catch(HttpClientErrorException e)
		{
			System.out.println(e.getMessage());
		}
		
	}


	private static void consultarCuenta(String ncc) {
		// TODO Auto-generated method stub
		obtenerCuenta(ncc).
				ifPresentOrElse(System.out::println,
							() -> System.out.println("error buscando cuenta"));
	}


	private static void insertarCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		String URLINSERTARCUENTA = URLBASE + "/cuenta/insertar";
		Class tipoCuenta;
		String tipo;
		
		RestTemplate restTemplate = new RestTemplate();
		
		try 
		{
			if (cuenta instanceof CuentaPersonal)
			{
				tipoCuenta = CuentaPersonal.class;
				tipo = "personal";
			}
			else
			{
				tipoCuenta = CuentaEmpresa.class;
				tipo = "empresa";
			}
			
			restTemplate.postForObject( URLINSERTARCUENTA+tipo, cuenta, tipoCuenta);
			
			System.out.println("cuenta insertada correctamente");
		
		}
		catch (HttpClientErrorException  e)
		{
			System.out.println("error, insertando cuenta");
		}
		
	}


	private static void leerClientesCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		Cliente cliente;
		String URLCONSULTARCLIENTE = URLBASE + "/cliente/consultar/{nif}";
		ArrayList<Cliente> clientes = new ArrayList<> ();
		String nif;
	
		
		RestTemplate restTemplate = new RestTemplate();
		
		do
		{
			
			nif = Teclado.leerString("\nNIF cliente :");
			
			// buscar cliente en BBDD
			
			try {
				ResponseEntity<Cliente> response  = 
						restTemplate.getForEntity(URLCONSULTARCLIENTE, Cliente.class,nif);
				
				cliente = response.getBody();
			}
			catch(HttpClientErrorException e)
			{
				cliente = Cliente.builder().nif(nif).build();
				(new LeerCliente(cliente)).leerRestoDatos();
			}
			
			
			System.out.println(cliente);
			clientes.add(cliente);

		}while (Teclado.leerString("Introducir más clientes (S/N)").equalsIgnoreCase("S"));
			
		cuenta.setClientes(clientes);
	}
	
	
	private static void leerDatosCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		float saldo;
	
		cuenta.setSaldo(Teclado.leerFloat("Saldo :"));
		
		if (cuenta instanceof CuentaPersonal c)
		{

			c.setCredito(Teclado.leerString("\nTarjeta de credito (S/N): ").equalsIgnoreCase("S"));
		}
		else if (cuenta instanceof CuentaEmpresa c)
		{
			
			c.setCif(Teclado.leerString("\nCIF: "));
			c.setNombre(Teclado.leerString("\nNombre: "));
			c.setLocal(Teclado.leerString("\nLocal propio (S/N): ").equalsIgnoreCase("S"));
			
		}
		
	}
	
	private static Cuenta crearCuenta(String ncc) {
		// TODO Auto-generated method stub
		int tipo;
		Cuenta cuenta;
		Scanner teclado = new Scanner(System.in);
		
		do
		{
			tipo = Teclado.leerInt("\ntipo de cuenta 1- Personal 2- Empresa");
		}while (tipo != 1 && tipo!= 2);
		
		cuenta = tipo == 1 ?CuentaPersonal.builder().ncc(ncc).build():
							CuentaEmpresa.builder().ncc(ncc).build();
		
		
		
		return cuenta;
	}
	
	
	private static String leerNCC() {
		// TODO Auto-generated method stub
		
		String ncc;
		
		boolean valido;
		
		// Comprobación de clave no repetida
		
		do
		{
			ncc = Teclado.leerString("\nNCC: ");
			valido = obtenerCuenta(ncc).isEmpty();
			
			if (!valido)
				System.out.println("Error - El NCC ya existe");
		}while (!valido);
		
		return ncc;
	}
	
	public static Optional<Cuenta> obtenerCuenta (String ncc)
	{
		String URLCONSULTARCUENTA = URLBASE + "/cuenta/consultar/{ncc}";
		Optional<Cuenta> cuenta;
		RestTemplate restTemplate = new RestTemplate();
		Cuenta c;
		
		try {
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLCONSULTARCUENTA, String.class,ncc);
			// parsear json
			cuenta = jsonToCuenta (response.getBody());
			
		}
		catch(HttpClientErrorException e)
		{
			cuenta = Optional.empty();
			System.out.println(e.getMessage());
		}
		
		return cuenta;
	}

	private static Optional<Cuenta> jsonToCuenta (String json)
	{
		Optional<Cuenta> cuenta;
		
		try 
		{
			// parsear json
			ObjectMapper objectMapper = new ObjectMapper();			
			JsonNode raiz = objectMapper.readTree(json);			
			Iterator<JsonNode> nodos = raiz.elements(); 
			
			// primer elmento el tipo
			Class tipo = objectMapper.readValue(nodos.next().toString(), Class.class);
						
			// segundo elemento el valor
			Object value = objectMapper.readValue(nodos.next().toString(), tipo);
			
			cuenta = Optional.of((Cuenta)value);
		}
		catch(JsonProcessingException e)
		{
			cuenta = Optional.empty();
			System.out.println(e.getMessage());
		}
		
		return cuenta;
	}
	

	private static List<String> jsonToCuentas(String body) {
		// TODO Auto-generated method stub
		List<String> cuentas = new ArrayList<>();
		
		try 
		{
			// parsear json
			ObjectMapper objectMapper = new ObjectMapper();			
			JsonNode raiz = objectMapper.readTree(body);			
			Iterator<JsonNode> nodos = raiz.elements(); 
			while (nodos.hasNext())
				cuentas.add(nodos.next().toString());
		}
		
		catch(JsonProcessingException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return cuentas;
	}
	
}
