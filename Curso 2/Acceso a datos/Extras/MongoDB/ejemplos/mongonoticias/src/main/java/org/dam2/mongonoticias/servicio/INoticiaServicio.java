package org.dam2.mongonoticias.servicio;

import java.util.List;


import org.dam2.mongonoticias.modelo.Noticia;


public interface INoticiaServicio {
	public boolean insertar (Noticia noticia);

	public List<Noticia> findAll ();
	
	public List<Noticia> buscarPorTitulo(String titulo);
	

}
