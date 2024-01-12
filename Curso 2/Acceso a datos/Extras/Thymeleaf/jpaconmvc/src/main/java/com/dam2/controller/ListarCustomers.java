package com.dam2.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@Controller
@RequestMapping("/customers") 
public class ListarCustomers {
	
		//@Autowired 
		private ICustomerService service;

		// Inyección por constructor
		public ListarCustomers (ICustomerService service)
		{
			this.service = service;
			System.out.println("Construyendo controlador...");
			cargarDatos ();
		
		}
		
		private void cargarDatos ()
		{
			service.save( Customer.builder().firstName("Jack").
						lastName("Bauer").
						fechaNacimiento(LocalDate.now().minusYears(20)).build());
			
			service.save( Customer.builder().firstName("Chloe").
						lastName("O'Brian").
						fechaNacimiento(LocalDate.now().minusYears(10)).build());
				
			service.save( Customer.builder().firstName("Kim").
						lastName("Bauer").
						fechaNacimiento(LocalDate.now().minusYears(25)).build());
				
			service.save( Customer.builder().firstName("David").
						lastName("Palmer").
						fechaNacimiento(LocalDate.now().minusYears(30)).build());
			
			service.save( Customer.builder().firstName("Michelle").
						lastName("Dessler").
						fechaNacimiento(LocalDate.now().minusYears(10)).build());

		}
		
		@GetMapping(value="todos")
		public ModelAndView getAllCustomer()
		//public ModelAndView getAllCustomer(HttpServletRequest request)
		{
			ModelAndView modeloYVista = new ModelAndView ();
			modeloYVista.setViewName("listar_template");
			
			// Llamar al servicio
			List<Customer>  customers = service.findAll();
			
			
			// Llamar al controlador rest customers/all
			// Crear URL
			
			/*
			String URLbase = ""+request.getRequestURL();
			URLbase = URLbase.replace(request.getRequestURI(), "/");
			String URL = URLbase + "customers/all";
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Customer[]> response  = restTemplate.getForEntity(URL, Customer[].class);
			
			List<Customer> customers = Arrays.asList(response.getBody());
			*/
			
			modeloYVista.addObject("customers", customers);
			
			return modeloYVista;
			
			
		}
		
		@GetMapping("customer")
		public ModelAndView getCustomer (@RequestParam("id") String id)
		{
			ModelAndView modeloYVista = new ModelAndView ();
			modeloYVista.setViewName("listar_uno_template");
			
			Customer  customer = service.findById(Long.valueOf(id));
			
			System.out.println(customer);
			modeloYVista.addObject("customer", customer);
			
			return modeloYVista;
		}
		
		@PostMapping("registrar")
		public ModelAndView saveCustomer (@Valid Customer customer, BindingResult result)
		{
			ModelAndView modeloYVista = new ModelAndView ();
		
			
			
			if (!result.hasErrors())
			{
				customer = service.save(customer);
				modeloYVista.setViewName("listar_uno_template");
			}
			else
				modeloYVista.setViewName("registrar");
			
			modeloYVista.addObject("customer", customer);
			
			return modeloYVista;
		}
		
		@GetMapping("insertar")
		public ModelAndView insertar ()
		{
			ModelAndView modeloYVista = new ModelAndView ();
			modeloYVista.setViewName("registrar");
			Customer customer = new Customer();
			modeloYVista.addObject("customer", customer);
			return modeloYVista;
		}
		

}
