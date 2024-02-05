package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.noticias.modelo.Comentario;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.repositorio.ComentarioRepositorio;
import org.dam2.noticias.repositorio.NoticiaRepositorio;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServicioImp implements IComentarioServicio {

	@Autowired private ComentarioRepositorio comentarioDAO;
	@Autowired private NoticiaRepositorio noticiaDAO;
	@Autowired private UsuarioRepositorio usuarioDAO;
	
	
	@Override
	public Comentario insertar(Comentario comentario) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario;
		Optional<Noticia> noticia;
		
		usuario = usuarioDAO.findById(comentario.getAutor().getNickname());
		noticia = noticiaDAO.findById(comentario.getNoticia().getId());
		
		if (usuario.isPresent() && noticia.isPresent() && comentario.getId() == 0)
			comentario = comentarioDAO.save(comentario);
		
		
		return comentario;
	}

	@Override
	public Optional<Comentario> findById(Long id) {
		// TODO Auto-generated method stub
		return comentarioDAO.findById(id);
	}

	@Override
	public List<Comentario> findByNoticia(String titulo) {
		// TODO Auto-generated method stub
		
		return comentarioDAO.findByTituloNoticia(titulo);
	}

	@Override
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return (List<Comentario>) comentarioDAO.findAll();
	}

	@Override
	public boolean update(Comentario comentario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (comentarioDAO.existsById(comentario.getId()))
		{
			comentario = comentarioDAO.save(comentario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (comentarioDAO.existsById(id))
		{
			comentarioDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}

}
