package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Contacto;
import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.CuentaEmpresa;
import com.example.demo.modelo.CuentaPersonal;
import com.example.demo.modelo.Wrapper;
import com.example.demo.service.IClienteService;
import com.example.demo.service.ICuentaService;

@RestController
@RequestMapping("banco/cliente")
public class ClienteControladorRest {
	
	@Autowired private IClienteService servicioCliente;
	@Autowired private ICuentaService servicioCuenta;
	

	@GetMapping ("/consultar")
	public ResponseEntity<List<Cliente>> obtenerTodosClientes ()
	{
		ResponseEntity<List<Cliente>> response;
		List<Cliente> todos;
		
		todos = servicioCliente.findAll();
		
		response = new ResponseEntity<>(todos,HttpStatus.OK);
		
		
		return response;
	}
	
	@GetMapping ("/consultar/{nif}")
	public ResponseEntity<Cliente> obtenerCliente (@PathVariable String nif)
	{
		ResponseEntity<Cliente> response;
		Optional<Cliente> cliente;
		
		cliente = servicioCliente.findByNif(nif);
		
		if (cliente.isPresent())
			response = new ResponseEntity<>(cliente.get(),HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}
	
	@GetMapping ("/consultarpornombre")
	public ResponseEntity<List<Cliente>> obtenerClientesPorNombre (@RequestParam String nombre)
	{
		ResponseEntity<List<Cliente>> response;
		List<Cliente> clientes;
		
		System.out.println("recibido " + nombre);
		
		clientes = servicioCliente.buscarPorNombre(nombre);
		
		
		response = new ResponseEntity<>(clientes,HttpStatus.OK);
		
		
		return response;
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Cliente> insertarCliente (@Valid @RequestBody Cliente cliente)
	{
		
		HttpStatus status = HttpStatus.CREATED;
		
		if (!servicioCliente.insert(cliente))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(cliente,status);
	}
	
	@PutMapping ("/actualizar")
	public ResponseEntity<Cliente> modificarCliente (@Valid @RequestBody Cliente cliente)
	{
		
		HttpStatus status = HttpStatus.ACCEPTED;
		
		if (!servicioCliente.update(cliente))
			status = HttpStatus.BAD_REQUEST;
		
		
		return new ResponseEntity<>(cliente,status);
	}
	
	@DeleteMapping ("/eliminar/{nif}")
	public ResponseEntity<String> eliminarCliente (@PathVariable String nif)
	{
		HttpStatus status = HttpStatus.OK;
		
		if (!servicioCliente.delete(nif))
			status = HttpStatus.NOT_FOUND;
		
		
		return new ResponseEntity<>(nif,status);
		
	}
	
	@GetMapping ("/cargardatos")
	public ResponseEntity<String> cargarClientes ()
	{
		HttpStatus status = HttpStatus.NOT_MODIFIED;
		
		Cliente cliente1,cliente2;
		Cuenta cuenta,cuenta2;
		
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
		
		if (servicioCliente.insert(cliente1) && 
				servicioCliente.insert(cliente2))	
			status = HttpStatus.OK;
		
		
		cuenta = CuentaPersonal.builder().
				ncc("001").
				credito(true).
				saldo(5000).
				cliente(cliente1).
				build();
		
		cuenta2 = CuentaEmpresa.builder().
				ncc("002").
				saldo(15000).
				cliente(cliente2).
				cif("00002").
				nombre("empresa 1").
				local(true).
				build();
		
		if (!servicioCuenta.insert(cuenta) || 
				!servicioCuenta.insert(cuenta2))
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>("datos cargados correctamente",status);
		

	}
	
	@GetMapping ("/prueba/{cual}")
	public ResponseEntity<?> obtenerObjeto (@PathVariable String cual)
	{
		ResponseEntity<?> response;
		Wrapper wrapper;
		Object value;
		
		Cliente cliente = Cliente.builder().
				nif("001").
				nombre("miguel").
				aval(10000).
				telefono(new Contacto("605353350","orange")).
				build();
		
	
		if (cual.equals("cliente"))
			value = Cliente.builder().
					nif("001").
					nombre("miguel").
					aval(10000).
					telefono(new Contacto("605353350","orange")).
					build();
		else
			value = servicioCuenta.findByNcc("001").get();
		
		
		
		wrapper = new Wrapper (value.getClass(), value);
		
		response = new ResponseEntity<>(wrapper,HttpStatus.OK);
		
		return response;
	}
	
}
