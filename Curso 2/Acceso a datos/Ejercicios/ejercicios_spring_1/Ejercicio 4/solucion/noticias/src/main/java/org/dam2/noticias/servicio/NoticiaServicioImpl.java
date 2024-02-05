package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.noticias.modelo.Categoria;
import org.dam2.noticias.modelo.Noticia;
import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.repositorio.NoticiaRepositorio;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServicioImpl implements INoticiaServicio {

	@Autowired private NoticiaRepositorio noticiaDAO;
	@Autowired private UsuarioRepositorio usuarioDAO;
	
	@Override
	@Transactional
	public Noticia insertar(Noticia noticia) {
		// TODO Auto-generated method stub
		Optional<Usuario> redactor;
		
		redactor = usuarioDAO.findById(noticia.getRedactor().getNickname());
		
		if (redactor.isPresent())
		{
			redactor.get().aumentarPuntos(noticia.getCategoria().ordinal() + 1);
			usuarioDAO.save(redactor.get());
			noticia.setRedactor(redactor.get());
			noticia = noticiaDAO.save(noticia);
		}
		
		
		return noticia;
	}

	@Override
	public Optional<Noticia> findById(Long id) {
		// TODO Auto-generated method stub
		return noticiaDAO.findById(id);
	}

	@Override
	public List<Noticia> findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return noticiaDAO.findByTitulo(titulo);
	}

	@Override
	public List<Noticia> findAll() {
		// TODO Auto-generated method stub
		return (List<Noticia>) noticiaDAO.findAll();
	}

	@Override
	public boolean update(Noticia noticia) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (noticiaDAO.existsById(noticia.getId()))
		{
			noticia = noticiaDAO.save(noticia);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (noticiaDAO.existsById(id))
		{
			noticiaDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}

	@Override
	@Transactional
	public int deleteByTitulo(String titulo) {
		// TODO Auto-generated method stub
		
		
		return (int) noticiaDAO.deleteByTitulo(titulo);
	}

	@Override
	public List<Noticia> findByUsuario(String nickname) {
		// TODO Auto-generated method stub
		Usuario redactor = Usuario.builder().nickname(nickname).build();
		
		return noticiaDAO.findByRedactor(redactor);
	}

	@Override
	public List<Noticia> findByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return noticiaDAO.findByCategoria(categoria);
	}

	@Override
	@Transactional
	public int borrarSinComentarios() {
		// TODO Auto-generated method stub
		return (int) noticiaDAO.deleteNoticiasSinComentarios();
	}

}
