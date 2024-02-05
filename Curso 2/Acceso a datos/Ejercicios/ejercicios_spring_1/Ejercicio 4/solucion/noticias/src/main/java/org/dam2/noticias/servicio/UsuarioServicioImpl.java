package org.dam2.noticias.servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dam2.noticias.modelo.Usuario;
import org.dam2.noticias.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

	@Autowired UsuarioRepositorio usuarioDAO;
	
	@Override
	public boolean insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!usuarioDAO.existsById(usuario.getNickname()))
		{
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public Optional<Usuario> findByNickName(String nickName) {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(nickName);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public boolean update(Usuario usuario) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (usuarioDAO.existsById(usuario.getNickname()))
		{
			usuarioDAO.save(usuario);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(String nickName) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (usuarioDAO.existsById(nickName))
		{
			usuarioDAO.deleteById(nickName);
			exito = true;
		}
		return exito;
	}

}
