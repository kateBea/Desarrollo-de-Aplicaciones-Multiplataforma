package org.dam2.noticias.clienteREST;

import java.time.LocalDate;
import java.util.Optional;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class RedactarNoticia {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilidadesCliente.cargarDatos();

		//solicitar redactor noticia
		UtilidadesCliente.solicitarUsuario().
		ifPresentOrElse(
				redactor -> crearNoticia (redactor), 
				()-> System.out.println("redactor no existente")
				);

	}

	public static void crearNoticia (Usuario redactor)
	{
		// solicitar datos de noticia
		Noticia noticia = Noticia.builder().
				redactor(redactor).
				fecha(LocalDate.now()).
				build();
		noticia.setTitulo(Teclado.leerString("\nTítulo "));
		noticia.setCuerpo(Teclado.leerString("\nContenido "));
		noticia.setCategoria(Categoria.ECONOMIA);
		// insertar noticia
		insertarNoticia (noticia);

	}
	public static void insertarNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Noticia> response;
		String URL = UtilidadesCliente.URLBASE + "/noticia/insertar";

		try {
			response = restTemplate.postForEntity(URL, noticia,Noticia.class);
			noticia = response.getBody();
			System.out.println("Noticia insertada correctamente");
			System.out.println("Identificador asignado " + noticia.getId());

		}
		catch (RestClientException e)
		{
			System.out.println("Error insertando noticia...");
		}


	}

	
}
