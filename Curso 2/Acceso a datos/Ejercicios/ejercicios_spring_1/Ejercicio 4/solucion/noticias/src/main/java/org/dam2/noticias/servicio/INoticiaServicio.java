package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Noticia;



public interface INoticiaServicio {
	public Noticia insertar (Noticia noticia);
	public Optional<Noticia> findById (Long id);
	public List<Noticia> findByTitulo (String titulo);
	public List<Noticia> findAll ();
	public boolean update (Noticia noticia);
	public boolean delete (Long id);
	public int deleteByTitulo (String titulo);
	public List<Noticia> findByUsuario (String nickname);
	public List<Noticia> findByCategoria (Categoria categoria);
	public int borrarSinComentarios();

}
