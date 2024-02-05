package org.dam2.noticias.clienteREST;

import java.time.LocalDate;
import java.util.Optional;

import org.dam2.noticias.modelo.Comentario;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class RealizarComentario {

	final static String URLBASE = "http://localhost:8080/noticias";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UtilidadesCliente.cargarDatos();
	
		UtilidadesCliente.solicitarUsuario().
					ifPresentOrElse(
							usuario -> UtilidadesCliente.solicitarNoticia().
												ifPresentOrElse(
														noticia -> insertarComentario(usuario,noticia),
														()-> System.out.println("noticia no existente")
														), 
							()-> System.out.println("usuario no existente")
							);
		
	}
	private static void insertarComentario(Usuario usuario, Noticia noticia) {
		// TODO Auto-generated method stub
		int puntuacion;
		String URL = UtilidadesCliente.URLBASE + "/comentario/insertar";
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Comentario> response;
		Comentario comentario;
		String contenido;
		
		contenido = Teclado.leerString("contenido del comentario");
		
		// leer puntuación
		do
		{
			puntuacion = Teclado.leerInt("puntuación");
		}while (puntuacion < 1 || puntuacion > 5);
		
		comentario = Comentario.builder().
							autor(usuario).
							noticia(noticia).
							contenido(contenido).
							valoracion(puntuacion).
							fecha(LocalDate.now()).
							build();
	
		// insertar comentario
		try {
			response = restTemplate.postForEntity(URL, comentario,Comentario.class);
			comentario = response.getBody();
			System.out.println("Comentario insertada correctamente");
			System.out.println("Identificador asignado " + comentario.getId());

		}
		catch (RestClientException e)
		{
			System.out.println("Error comentario noticia...");
		}

		
	}
	

}
