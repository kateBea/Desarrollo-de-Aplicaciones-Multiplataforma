package org.dam2.mongonoticias.servicio;

import java.util.List;

import org.dam2.mongonoticias.modelo.Noticia;
import org.dam2.mongonoticias.repositorio.NoticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticiaServicioImpl implements INoticiaServicio {

	@Autowired private NoticiaRepositorio noticiaDAO;
	@Override
	public boolean insertar(Noticia noticia) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!noticiaDAO.existsById(noticia.getId()))
		{
			noticiaDAO.insert(noticia);
			exito = true;
		}
		return exito;
	}

	@Override
	public List<Noticia> findAll() {
		// TODO Auto-generated method stub
		return noticiaDAO.findAll();
	}

	@Override
	public List<Noticia> buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		
		return noticiaDAO.query(titulo);
	}

}
