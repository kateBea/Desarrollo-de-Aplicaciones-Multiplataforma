package com.example.demo.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.CuentaEmpresa;
import com.example.demo.modelo.CuentaPersonal;
import com.example.demo.modelo.WrapperCuenta;
import com.example.demo.service.IClienteService;
import com.example.demo.service.ICuentaService;

@RestController
@RequestMapping("banco/cuenta")
public class CuentaControladorRest {
	
	@Autowired private IClienteService servicioCliente;
	@Autowired private ICuentaService servicioCuenta;
	
	@GetMapping ("/consultar/{ncc}")
	public ResponseEntity<WrapperCuenta> obtenerCliente (@PathVariable String ncc)
	{
		ResponseEntity<WrapperCuenta> response;
		Optional<Cuenta> cuenta;
		WrapperCuenta wrapper;
		
		cuenta = servicioCuenta.findByNcc(ncc);
		
		if (cuenta.isPresent())
		{
			wrapper = encapsularCuenta (cuenta.get());
			response = new ResponseEntity<>(wrapper,HttpStatus.OK);
		}
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return response;
	}
	
	@GetMapping ("/consultar")
	public ResponseEntity<List<WrapperCuenta>> obtenerClientes ()
	{
		ResponseEntity<List<WrapperCuenta>> response;

		List<WrapperCuenta> wrappers;
		
		wrappers = servicioCuenta.findAll().
					stream().
					map(CuentaControladorRest::encapsularCuenta).
					collect(Collectors.toList());
		
	
		response = new ResponseEntity<>(wrappers,HttpStatus.OK);
		
		return response;
	}
	
	
	@PostMapping("/insertarempresa")
	public ResponseEntity<Cuenta> insertarCuentaEmpresa (@RequestBody CuentaEmpresa cuenta)
	{
		
		return insertarCuenta (cuenta);
	}
	
	@PostMapping("/insertarpersonal")
	public ResponseEntity<Cuenta> insertarCuentaPersonal (@RequestBody CuentaPersonal cuenta)
	{
		
		return insertarCuenta (cuenta);
	}
	
	private ResponseEntity<Cuenta> insertarCuenta (Cuenta cuenta)
	{
		HttpStatus status = HttpStatus.CREATED;
		
		if (!servicioCuenta.insert(cuenta))
			status = HttpStatus.BAD_REQUEST;
		
		return new ResponseEntity<>(cuenta,status);
	}
	
	@PostMapping("/ingresar")
	public ResponseEntity<Float> ingresar (@RequestParam String ncc, @RequestParam float cantidad)
	{
		ResponseEntity<Float> response;
		boolean exito;
		
		Cuenta cuenta;
		
		
		exito = servicioCuenta.ingresarDinero(ncc, cantidad);
		
		if (exito)
		{
			cuenta = servicioCuenta.findByNcc(ncc).get();
			response = new ResponseEntity (cuenta.getSaldo(),HttpStatus.OK);
		}
		else
			response = new ResponseEntity (0,HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	@PostMapping("/retirar")
	public ResponseEntity<Float> retirar (@RequestParam String ncc, @RequestParam float cantidad)
	{
		ResponseEntity<Float> response;
		float exito;
		
		Cuenta cuenta;
		
		
		exito = servicioCuenta.retirarDinero(ncc, cantidad);
		
		if (exito != 0)
		{
			
			response = new ResponseEntity (exito,HttpStatus.OK);
		}
		else 
			response = new ResponseEntity (0,HttpStatus.BAD_REQUEST);
		
		return response;
	}
	
	@GetMapping("/obtenersaldo/{ncc}")
	public ResponseEntity<Float> obtenerSaldo (@PathVariable String ncc)
	{
		ResponseEntity<Float> response;
		
		Cuenta cuenta = servicioCuenta.findByNcc(ncc).orElse(null);
		
		if (cuenta != null)
			response = new ResponseEntity (cuenta.getSaldo(),HttpStatus.OK);
		else
			response = new ResponseEntity (0,HttpStatus.NOT_FOUND);
		
		return response;
	}
	
	@PostMapping("/hacertransferenica")
	public ResponseEntity<Float> hacerTransferencia (@RequestParam String nccOrigen, @RequestParam String nccDestino ,@RequestParam float cantidad)
	{
		ResponseEntity<Float> response;
		float exito;
		
		Cuenta cuenta;
		
		
		exito = servicioCuenta.transferirDinero(nccOrigen, nccDestino, cantidad);
		
		if (exito != 0)
		{
			
			response = new ResponseEntity (exito,HttpStatus.OK);
		}
		else 
			response = new ResponseEntity (0,HttpStatus.NOT_FOUND);
		
		return response;
	}

	public static WrapperCuenta encapsularCuenta (Cuenta cuenta)
	{
		return WrapperCuenta.builder().
				tipo(cuenta.getClass()).
				cuenta(cuenta).
				build();
		
	}
}
