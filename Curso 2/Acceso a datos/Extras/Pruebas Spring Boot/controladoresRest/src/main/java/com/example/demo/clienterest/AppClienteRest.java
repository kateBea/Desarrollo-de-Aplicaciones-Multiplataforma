package com.example.demo.clienterest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Contacto;
import com.example.demo.modelo.Cuenta;
import com.example.demo.vistaylectura.LeerCliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppClienteRest {

	final static String URLBASE = "http://localhost:8080/banco/cliente";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		cargarDatos ();
		
		mostrarClientesPorNombre ("miguel");
		//mostrarObjeto ();
		
		//insertarCliente ();
		
		//buscarCliente ();
		
		//editarCliente ();
		
		//eliminarCliente ();
		
		//listarClientesRicos();

		
	}

	public static void mostrarClientesPorNombre (String nombre)
	{
		String URLCONSULTARPORNOMBRE = URLBASE + "/consultarpornombre?nombre={nombre}";
		Cliente[] clientes;
		RestTemplate restTemplate = new RestTemplate();
		Map<String,Object> parametros = new HashMap<String,Object>();
		
		parametros.put("nombre", nombre);
		
		try
		{
			
			ResponseEntity<Cliente[]> response  = 
					restTemplate.getForEntity(URLCONSULTARPORNOMBRE, Cliente[].class,parametros);
			
			clientes = response.getBody();
			System.out.println("Listado de clientes por nombre");
			Arrays.stream(clientes).forEach (System.out::println);
			
		}
		catch(HttpClientErrorException e)
		{
			System.out.println("Cliente no existente");
			
		}
		
	}
	
	public static void cargarDatos ()
	{
		String URLCARGARDATOS = URLBASE + "/cargardatos";
		RestTemplate restTemplate = new RestTemplate();
		String mensaje;
		
		try
		{
			
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLCARGARDATOS, String.class);
			
			mensaje = response.getBody();
			
		}
		catch(HttpClientErrorException e)
		{
			mensaje = "error cargando datos..." + e.getStatusCode();
		}
		
		System.out.println(mensaje);
		
	}
	
	public static void insertarCliente ()
	{
		
		String URLINSERTAR = URLBASE + "/insertar";
		Cliente cliente;
	
	
		RestTemplate restTemplate = new RestTemplate();
	
		LeerCliente leerCliente;
		
		boolean valido;
		
		// Comprobación de clave no repetida
		
		do
		{
			valido = true;
			leerCliente = new LeerCliente (new Cliente());
			leerCliente.leerClave();
			if (getCliente(leerCliente.getCliente().getNif()) != null)
				valido = false;
			if (!valido)
				System.out.println("Cliente ya existente");
		}while (!valido);
		
		// Leer el resto de los datos
		leerCliente.leerRestoDatos();
		
		//cliente.getTelefonos().add(new Contacto("999","Movistar"));
		
		// Insertar entidad
		try 
		{
			restTemplate.postForObject( URLINSERTAR, leerCliente.getCliente(), Cliente.class);
	
			System.out.println("cliente insertado correctamente");
		
		}
		catch (HttpClientErrorException  e)
		{
			System.out.println("error, insertando cliente");
		}
		
		
	}
	
	public static Cliente getCliente (String nif)
	{
		String URLBUSCAR = URLBASE + "/consultar/{nif}";
		Cliente cliente;
		RestTemplate restTemplate = new RestTemplate();
		
		try
		{
			
			ResponseEntity<Cliente> response  = 
					restTemplate.getForEntity(URLBUSCAR, Cliente.class,nif);
			
			cliente = response.getBody();
			
		}
		catch(HttpClientErrorException e)
		{
			cliente = null;
		}
		
		return cliente;
	}
	
	
	public static void mostrarObjeto ()
	{
		
		String URLBUSCAR = URLBASE + "/prueba/{cual}";
		Cliente cliente;
		Cuenta cuenta;
		String cual = "cliente";
		String recibido;
		
		RestTemplate restTemplate = new RestTemplate();
		
		try
		{
			System.out.println("Pidiendo datos...");
			ResponseEntity<String> response  = 
					restTemplate.getForEntity(URLBUSCAR, String.class,cual);

			// recibir datos como un json
			recibido = response.getBody();
			
			System.out.println("Datos recibidos");
			
			System.out.println(recibido);
			
			// parsear json
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			
			JsonNode raiz = objectMapper.readTree(recibido);
			
			Iterator<JsonNode> nodos = raiz.elements(); 
			
			// primer elmento el tipo
			Class tipo = objectMapper.readValue(nodos.next().toString(), Class.class);
			
			// segundo elemento el valor
			Object value = objectMapper.readValue(nodos.next().toString(), tipo);
			
			System.out.println(value);
			
			
			if (value instanceof Cliente)
			{
				System.out.println("Ha llegado un cliente");
				cliente = (Cliente) value;
				System.out.println(cliente.getNombre());
			}
			else
			{
				System.out.println("Ha llegado una cuenta");
				cuenta = (Cuenta) value;
				System.out.println(cuenta);
			}
			
			
			
		}
		catch(HttpClientErrorException | JsonProcessingException e)
		{
			System.out.println("error " + e.getMessage());
		}
		
	}
	
	public static void buscarCliente ()
	{
		Cliente cliente;
		String nif;
		Scanner teclado = new Scanner(System.in);
		
		
		System.out.println("Nif del cliente a buscar: ");
		nif = teclado.nextLine();
		cliente = getCliente(nif) ;
		if (cliente == null)
			System.out.println("Cliente NO existente");
		else
			System.out.println(cliente);
		
	}
	
	public static void editarCliente ()
	{
		String URLACTUALIZAR = URLBASE + "/actualizar";
		
		Cliente cliente = new Cliente ();
		RestTemplate restTemplate = new RestTemplate();
		LeerCliente leerCliente = new LeerCliente (cliente);
		
		
		leerCliente.leerClave();
		
		cliente = getCliente(cliente.getNif());
		
		
		if (cliente == null)
			System.out.println("Cliente NO existente");
		else
		{
			System.out.println(cliente);
		
			leerCliente.setCliente(cliente);
			leerCliente.leerRestoDatos();
			
			// Actualzar entidad
			try 
			{
	
				restTemplate.put(URLACTUALIZAR, cliente);
		
				System.out.println("cliente actualizado correctamente");
			
			}
			catch (HttpClientErrorException  e)
			{
				System.out.println("error, actualizando cliente " + e.getLocalizedMessage());
				
				
			}
					
			
		}
			
	}
	
	public static void eliminarCliente ()
	{
		String URLELIMINAR = URLBASE + "/eliminar/{nif}";
		Cliente cliente;
		String nif;
		Scanner teclado = new Scanner(System.in);
		RestTemplate restTemplate = new RestTemplate();
		
		
		nif = teclado.nextLine();
		
		try 
		{

			restTemplate.delete(URLELIMINAR, nif);
	
			System.out.println("cliente eliminado correctamente");
		
		}
		catch (HttpClientErrorException  e)
		{
			System.out.println("error, eliminando cliente");
		}
		
		
		
	}
	
	public static void listarClientesRicos()
	{
		String URLLILSTARTODOS = URLBASE + "/consultar";
		RestTemplate restTemplate = new RestTemplate();
		Cliente[] clientes;
		
		ResponseEntity<Cliente[]> response  = 
				restTemplate.getForEntity(URLLILSTARTODOS, Cliente[].class);
		
		clientes = response.getBody();
		
		for(Cliente c: clientes)
			if (c.getAval()> 12000)
				System.out.println(c);
		
		Arrays.stream(clientes).filter(c -> c.getAval()>12000).forEach(System.out::println);
	}
	
	
}
