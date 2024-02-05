package org.dam2.noticias.clienteREST;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Comentario;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import daw.com.Teclado;

public class ConsultaPorCategoria {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UtilidadesCliente.cargarDatos();
		
		seleccionarNoticia().ifPresent(ConsultaPorCategoria::mostrarComentarios);

	}
	
	
	public static void mostrarComentarios (String titulo)
	{
	
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Comentario[]> response;
		
		String URL = UtilidadesCliente.URLBASE + "/comentario/consultarpornoticia/{titulo}";
		
		try {
			response = restTemplate.getForEntity(URL, Comentario[].class,titulo);
			Arrays.stream(response.getBody()).
					forEach(c -> System.out.println (c.getAutor().getNickname()+
								"," + c.getContenido() +
								"," + c.getValoracion()+
								"," + c.getFecha()));

		}
		catch (RestClientException e)
		{
			System.out.println("Error consultado comentarios..."  + e.getMessage());
		}
	}
	
	public static Optional<String> seleccionarNoticia ()
	{
		List<Noticia> noticias;
		RestTemplate restTemplate = new RestTemplate ();
		ResponseEntity <Noticia[]> response;
		Categoria categoria = Categoria.POLITICA;
		String titulo;
		List<String> titulos;

		
		String URL = UtilidadesCliente.URLBASE + "/noticia/consultarporcategoria?categoria={categoria}";
		
		try {
			response = restTemplate.getForEntity(URL, Noticia[].class,categoria);
			// leer título noticia
			titulos = Arrays.stream(response.getBody()).
					map(Noticia::getTitulo).
					collect(Collectors.toList());
			do {
				titulos.forEach(System.out::println);
				titulo = Teclado.leerString("título a elegir");
			}while (!titulos.contains(titulo));
			
		}
		catch (RestClientException e)
		{
			System.out.println("Error consultado noticias..."  + e.getMessage());
			titulo = null;
		}
		
		return Optional.ofNullable(titulo);
	}

}
