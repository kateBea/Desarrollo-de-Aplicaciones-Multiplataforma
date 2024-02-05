package org.dam2.noticias.clienteREST;

import java.util.Optional;

import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class UtilidadesCliente {
	
	final static String URLBASE = "http://localhost:8080/noticias";
	
	public static void cargarDatos() {
		// TODO Auto-generated method stub
		String URLCARGARDATOS = URLBASE + "/utilidades/cargardatos";
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
	
	public static Optional<Usuario> solicitarUsuario() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Usuario> response;
		String URL = URLBASE + "/usuario/consultar/{nickName}";
		Optional<Usuario> usuario;
		
		String nickName = Teclado.leerString("\nnickname");
		
		try {
			response = restTemplate.getForEntity(URL, Usuario.class, nickName);
			usuario = Optional.of(response.getBody());
		}
		catch (RestClientException e)
		{
			usuario = Optional.empty();
		}
		
		return usuario;
	}
	
	public static Optional<Noticia> solicitarNoticia() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Noticia> response;
		
		String URL = URLBASE + "/noticia/consultar/{id}";
		Optional<Noticia> noticia;
		
		Long id = (long) Teclado.leerInt("\nid noticia");
		
		try {
			response = restTemplate.getForEntity(URL, Noticia.class, id);
			noticia = Optional.of(response.getBody());
		}
		catch (RestClientException e)
		{
			noticia = Optional.empty();
		}
		
		return noticia;
	}
	

	
}
